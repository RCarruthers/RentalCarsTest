package com.ryan.uom.RentalCarsTest.processors;

import com.ryan.uom.RentalCarsTest.model.Vehicle;
import com.ryan.uom.RentalCarsTest.model.VehicleList;
import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

@Component
public class SortBySupplierRatingProcessor implements Processor {

    @Override
    public void process(Exchange exchange) throws Exception {
        List<Vehicle> vehicleList = exchange.getIn().getBody(VehicleList.class).getSearch().getVehicleList();

        for (Vehicle vehicle : vehicleList) {
            int score = 0;
            String sipp = vehicle.getSipp();
            if ('M' == sipp.charAt(2))
                score += 2;
            if ('A' == sipp.charAt(2))
                score += 5;
            if ('R' == sipp.charAt(3))
                score += 3;
            vehicle.setScore(score);
        }

        vehicleList.sort(new Comparator<Vehicle>() {
            @Override
            public int compare(Vehicle o1, Vehicle o2) {
                return Double.compare((o2.getRating() + o2.getScore()), (o1.getRating() + o1.getScore()));
            }
        });

        String vehicleSupplierRating = "";
        int carsInList = 0;
        for (Vehicle vehicle : vehicleList) {
            carsInList++;
            vehicleSupplierRating += carsInList + ". "
                    + vehicle.getName() + " - "
                    + vehicle.getScore() + " - "
                    + vehicle.getRating() + " - "
                    + (double) (vehicle.getRating() + vehicle.getScore())
                    + System.lineSeparator();
        }

        exchange.getOut().setBody(vehicleSupplierRating, String.class);
    }
}
