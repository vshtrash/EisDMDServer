package com.eis.controller;


public class RestSettingsPath {
    public static final String CUSTOMERS ="/customers/";
    public static final String PRODUCTS = CUSTOMERS + "{customerId}/products/"; // "/customers/{customerId}/products/"
    public static final String DMD_VERSIONS ="/dmd/{productId}/versions/";



    public static String getProductWithCustomerId(Long customerId) {
        if (customerId == null) {
            return PRODUCTS.replaceAll("\\{customerId\\}","null");
        }
        return PRODUCTS.replaceAll("\\{customerId\\}",customerId.toString());
    }


    public static String getDmdVersionWithProductId(Long productId) {
        if (productId == null) {
            return DMD_VERSIONS.replaceAll("\\{productId\\}","null");
        }
        return DMD_VERSIONS.replaceAll("\\{productId\\}",productId.toString());
    }
}