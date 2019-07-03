/*******************************************************************************
 *
 *    Copyright 2019 Adobe. All rights reserved.
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

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.shopify.graphql.support.AbstractResponse;
import com.shopify.graphql.support.SchemaViolationError;

/**
 * Simple Cart Item
 */
public class SimpleCartItem extends AbstractResponse<SimpleCartItem> implements CartItemInterface {
    public SimpleCartItem() {
    }

    public SimpleCartItem(JsonObject fields) throws SchemaViolationError {
        for (Map.Entry<String, JsonElement> field : fields.entrySet()) {
            String key = field.getKey();
            String fieldName = getFieldName(key);
            switch (fieldName) {
                case "customizable_options": {
                    List<SelectedCustomizableOption> optional1 = null;
                    if (!field.getValue().isJsonNull()) {
                        List<SelectedCustomizableOption> list1 = new ArrayList<>();
                        for (JsonElement element1 : jsonAsArray(field.getValue(), key)) {
                            SelectedCustomizableOption optional2 = null;
                            if (!element1.isJsonNull()) {
                                optional2 = new SelectedCustomizableOption(jsonAsObject(element1, key));
                            }

                            list1.add(optional2);
                        }

                        optional1 = list1;
                    }

                    responseData.put(key, optional1);

                    break;
                }

                case "id": {
                    responseData.put(key, jsonAsString(field.getValue(), key));

                    break;
                }

                case "product": {
                    responseData.put(key, UnknownProductInterface.create(jsonAsObject(field.getValue(), key)));

                    break;
                }

                case "quantity": {
                    responseData.put(key, jsonAsDouble(field.getValue(), key));

                    break;
                }

                case "__typename": {
                    responseData.put(key, jsonAsString(field.getValue(), key));
                    break;
                }
                default: {
                    throw new SchemaViolationError(this, key, field.getValue());
                }
            }
        }
    }

    public String getGraphQlTypeName() {
        return "SimpleCartItem";
    }

    public List<SelectedCustomizableOption> getCustomizableOptions() {
        return (List<SelectedCustomizableOption>) get("customizable_options");
    }

    public SimpleCartItem setCustomizableOptions(List<SelectedCustomizableOption> arg) {
        optimisticData.put(getKey("customizable_options"), arg);
        return this;
    }

    public String getId() {
        return (String) get("id");
    }

    public SimpleCartItem setId(String arg) {
        optimisticData.put(getKey("id"), arg);
        return this;
    }

    public ProductInterface getProduct() {
        return (ProductInterface) get("product");
    }

    public SimpleCartItem setProduct(ProductInterface arg) {
        optimisticData.put(getKey("product"), arg);
        return this;
    }

    public Double getQuantity() {
        return (Double) get("quantity");
    }

    public SimpleCartItem setQuantity(Double arg) {
        optimisticData.put(getKey("quantity"), arg);
        return this;
    }

    public boolean unwrapsToObject(String key) {
        switch (getFieldName(key)) {
            case "customizable_options": return true;

            case "id": return false;

            case "product": return false;

            case "quantity": return false;

            default: return false;
        }
    }
}
