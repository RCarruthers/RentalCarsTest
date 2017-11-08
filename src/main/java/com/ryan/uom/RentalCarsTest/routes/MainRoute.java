package com.ryan.uom.RentalCarsTest.routes;

import com.ryan.uom.RentalCarsTest.model.VehicleList;
import com.ryan.uom.RentalCarsTest.processors.SortByPriceProcessor;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.dataformat.JsonLibrary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import static com.ryan.uom.RentalCarsTest.util.Constants.ENDPOINT_START_ROUTE;

@Component
public class MainRoute extends RouteBuilder {

    @Autowired
    private SortByPriceProcessor priceProcessor;

    @Override
    public void configure() throws Exception {

        from(ENDPOINT_START_ROUTE)
                .to("http4://www.rentalcars.com/js/vehicles.json")
                .unmarshal().json(JsonLibrary.Jackson, VehicleList.class)
                .process(priceProcessor)
                .log("${body}")
                .end();

    }
}
