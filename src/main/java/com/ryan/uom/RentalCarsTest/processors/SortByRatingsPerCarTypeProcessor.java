package com.ryan.uom.RentalCarsTest.processors;

import com.ryan.uom.RentalCarsTest.model.Vehicle;
import com.ryan.uom.RentalCarsTest.model.VehicleList;
import com.ryan.uom.RentalCarsTest.util.SippMap;
import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.springframework.stereotype.Component;

import java.util.Comparator;
import java.util.List;

@Component
public class SortByRatingsPerCarTypeProcessor implements Processor {

    @Override
    public void process(Exchange exchange) throws Exception {
        List<Vehicle> vehicleList = exchange.getIn().getBody(VehicleList.class).getSearch().getVehicleList();
        vehicleList.sort(new Comparator<Vehicle>() {
            @Override
            public int compare(Vehicle o1, Vehicle o2) {
                return o2.getRating().compareTo(o1.getRating());
            }
        });

        char[] carTypes = new char[]{'M', 'E', 'C', 'I', 'S', 'F', 'P', 'L', 'X'};

        String vehicleRatingPerSupplier = "";
        int carsInList = 0;
        for (int i = 0; i < carTypes.length; i++) {
            for (int j = 0; j < vehicleList.size(); j++) {
                Vehicle vehicle = vehicleList.get(j);
                if ((vehicleList.get(j).getSipp().charAt(0)) == carTypes[i]) {
                    vehicleRatingPerSupplier += (carsInList + 1) + ". "
                            + vehicle.getName()
                            + " - " + SippMap.getCarType(vehicle.getSipp().charAt(0))
                            + " - " + vehicle.getSupplier()
                            + " - " + vehicle.getRating()
                            + System.lineSeparator();
                    carsInList++;
                    break;
                }
            }
        }

        exchange.getOut().setBody(vehicleRatingPerSupplier);
    }
}
