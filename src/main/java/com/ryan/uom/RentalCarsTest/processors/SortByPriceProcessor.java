package com.ryan.uom.RentalCarsTest.processors;


import com.ryan.uom.RentalCarsTest.model.Vehicle;
import com.ryan.uom.RentalCarsTest.model.VehicleList;
import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;

import static com.ryan.uom.RentalCarsTest.util.Constants.LINE_SEPERATOR;

@Component
public class SortByPriceProcessor implements Processor {

    @Override
    public void process(Exchange exchange) throws Exception {
        List<Vehicle> vehicleList = exchange.getIn().getBody(VehicleList.class).getSearch().getVehicleList();
        Collections.sort(vehicleList);
        String vehiclePriceRanking = "";
        int carsInList = 0;
        for (Vehicle vehicle : vehicleList) {
            carsInList++;
            vehiclePriceRanking += (carsInList + ". " + vehicle.getName() + " - " + vehicle.getPrice() + LINE_SEPERATOR);
        }
        exchange.getOut().setBody(vehiclePriceRanking);
    }
}
