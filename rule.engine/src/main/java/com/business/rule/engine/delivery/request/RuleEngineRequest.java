package com.business.rule.engine.delivery.request;

import com.business.rule.engine.delivery.model.ProductCategory;


public class RuleEngineRequest {
    private String orderId;

    private ProductCategory productCategory;

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public ProductCategory getProductCategory() {
        return productCategory;
    }

    public void setProductCategory(ProductCategory productCategory) {
        this.productCategory = productCategory;
    }
}

