package com.ryan.uom.RentalCarsTest.util;

public class Constants {
    public static final String ENDPOINT_START_ROUTE = "direct:mainRoute";
    public static final String ENDPOINT_SORT_BY_PRICE = "direct:sortByPriceRoute";
    public static final String ENDPOINT_SORT_BY_SIPP = "direct:sortBySippRoute";
    public static final String ENDPOINT_SORT_BY_CAR_TYPE_RATING = "direct:sortByCarTypeRating";
    public static final String ENDPOINT_SORT_BY_SUPPLIER_RATING = "direct:sortBySupplierRating";
    public static final String ENDPOINT_JSON_LOCATION = "http4://www.rentalcars.com/js/vehicles.json";

    public static final String HEADER_REQUEST_PATH = "headerRequestPath";
    public static final String REQUEST_PATH_PRICE = "/getVehiclesByPrice";
    public static final String REQUEST_PATH_SIPP = "/getVehiclesBySIPP";
    public static final String REQUEST_PATH_RATING = "/getVehiclesByRating";
    public static final String REQUEST_PATH_SCORE = "/getVehiclesByScore";


    public static final String LINE_SEPERATOR = System.getProperty("line.separator");

}
