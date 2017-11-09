package com.ryan.uom.RentalCarsTest.routes;

import com.ryan.uom.RentalCarsTest.model.VehicleList;
import com.ryan.uom.RentalCarsTest.processors.SortByPriceProcessor;
import com.ryan.uom.RentalCarsTest.processors.SortByRatingsPerCarTypeProcessor;
import com.ryan.uom.RentalCarsTest.processors.SortBySippProcessor;
import com.ryan.uom.RentalCarsTest.processors.SortBySupplierRatingProcessor;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.dataformat.JsonLibrary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import static com.ryan.uom.RentalCarsTest.util.Constants.*;

@Component
public class MainRoute extends RouteBuilder {

    @Autowired
    private SortByPriceProcessor priceProcessor;

    @Autowired
    private SortBySippProcessor sippProcessor;

    @Autowired
    private SortByRatingsPerCarTypeProcessor ratingsProcessor;

    @Autowired
    private SortBySupplierRatingProcessor supplierRatingProcessor;

    @Override
    public void configure() throws Exception {

        from(ENDPOINT_START_ROUTE)
                .setHeader(HEADER_REQUEST_PATH, body())
                .to(ENDPOINT_JSON_LOCATION)
                .unmarshal().json(JsonLibrary.Jackson, VehicleList.class)
                .choice()
                .when(header(HEADER_REQUEST_PATH).isEqualTo(REQUEST_PATH_PRICE)).to(ENDPOINT_SORT_BY_PRICE)
                .when(header(HEADER_REQUEST_PATH).isEqualTo(REQUEST_PATH_SIPP)).to(ENDPOINT_SORT_BY_SIPP)
                .when(header(HEADER_REQUEST_PATH).isEqualTo(REQUEST_PATH_RATING)).to(ENDPOINT_SORT_BY_CAR_TYPE_RATING)
                .when(header(HEADER_REQUEST_PATH).isEqualTo(REQUEST_PATH_SCORE)).to(ENDPOINT_SORT_BY_SUPPLIER_RATING)
                .end();

        from(ENDPOINT_SORT_BY_PRICE)
                .process(priceProcessor)
                .end();

        from(ENDPOINT_SORT_BY_SIPP)
                .process(sippProcessor)
                .end();

        from(ENDPOINT_SORT_BY_CAR_TYPE_RATING)
                .process(ratingsProcessor)
                .end();

        from(ENDPOINT_SORT_BY_SUPPLIER_RATING)
                .process(supplierRatingProcessor)
                .end();

    }
}
