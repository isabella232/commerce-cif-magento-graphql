/*******************************************************************************
 *
 *    Copyright 2020 Adobe. All rights reserved.
 *    This file is licensed to you under the Apache License, Version 2.0 (the "License");
 *    you may not use this file except in compliance with the License. You may obtain a copy
 *    of the License at http://www.apache.org/licenses/LICENSE-2.0
 *
 *    Unless required by applicable law or agreed to in writing, software distributed under
 *    the License is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR REPRESENTATIONS
 *    OF ANY KIND, either express or implied. See the License for the specific language
 *    governing permissions and limitations under the License.
 *
 ******************************************************************************/

package com.adobe.cq.commerce.magento.graphql;

import com.shopify.graphql.support.AbstractQuery;

public class ReorderItemsOutputQuery extends AbstractQuery<ReorderItemsOutputQuery> {
    ReorderItemsOutputQuery(StringBuilder _queryBuilder) {
        super(_queryBuilder);
    }

    /**
     * Contains detailed information about the customer&#39;s cart.
     */
    public ReorderItemsOutputQuery cart(CartQueryDefinition queryDef) {
        startField("cart");

        _queryBuilder.append('{');
        queryDef.define(new CartQuery(_queryBuilder));
        _queryBuilder.append('}');

        return this;
    }

    /**
     * An array of reordering errors.
     */
    public ReorderItemsOutputQuery userInputErrors(CheckoutUserInputErrorQueryDefinition queryDef) {
        startField("userInputErrors");

        _queryBuilder.append('{');
        queryDef.define(new CheckoutUserInputErrorQuery(_queryBuilder));
        _queryBuilder.append('}');

        return this;
    }
}