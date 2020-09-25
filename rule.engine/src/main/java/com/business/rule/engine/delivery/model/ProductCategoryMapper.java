package com.business.rule.engine.delivery.model;

public class ProductCategoryMapper {
    public static ProductCategory mapToDomain(ProductCategory productCategory){
        switch (productCategory){
            case VIDEO:
                return ProductCategory.VIDEO;
            case PHYSICAL_PRODUCT:
                return ProductCategory.PHYSICAL_PRODUCT;
            case BOOK:
                return ProductCategory.BOOK;
            case MEMBERSHIP_UPGRADE:
                return ProductCategory.MEMBERSHIP_UPGRADE;
            case MEMBERSHIP_ACTIVATE:
                return ProductCategory.MEMBERSHIP_ACTIVATE;
        }
        throw new UnsupportedOperationException("Product category is not supported");
    }
}

