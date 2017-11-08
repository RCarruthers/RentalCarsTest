package com.ryan.uom.RentalCarsTest.processors;


import com.ryan.uom.RentalCarsTest.model.Vehicle;
import com.ryan.uom.RentalCarsTest.model.VehicleList;
import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;

@Component
public class SortByPriceProcessor implements Processor {

    private static final String LINE_SEPERATOR = System.getProperty("line.separator");

    @Override
    public void process(Exchange exchange) throws Exception {
        List<Vehicle> vehicleList = exchange.getIn().getBody(VehicleList.class).getSearch().getVehicleList();
        Collections.sort(vehicleList);
        String vehiclePriceRanking = "";
        for(Vehicle vehicle : vehicleList) {
            vehiclePriceRanking += ("Vehicle: " + vehicle.getName() + " - " + "Price: " + vehicle.getPrice() + LINE_SEPERATOR);
        }
        exchange.getOut().setBody(vehiclePriceRanking);
    }
}
