package com.ryan.uom.RentalCarsTest.processors;

import com.ryan.uom.RentalCarsTest.model.Vehicle;
import com.ryan.uom.RentalCarsTest.model.VehicleList;
import com.ryan.uom.RentalCarsTest.util.SippMap;
import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class SortBySippProcessor implements Processor {

    @Override
    public void process(Exchange exchange) throws Exception {
        List<Vehicle> vehicleList = exchange.getIn().getBody(VehicleList.class).getSearch().getVehicleList();
        String vehicleSpec = "";
        int carsInList = 0;
        for (Vehicle vehicle : vehicleList) {
            carsInList++;
            String sipp = vehicle.getSipp();
            vehicleSpec += (carsInList + ". "
                    + vehicle.getName() + " - "
                    + sipp + " - "
                    + SippMap.getCarType(sipp.charAt(0)) + " - "
                    + SippMap.getCarDoors(sipp.charAt(1)) + " - "
                    + SippMap.getTransmission(sipp.charAt(2)) + " - "
                    + SippMap.getFuel(sipp.charAt(3)) + " - "
                    + SippMap.getAc(sipp.charAt(3))
                    + System.lineSeparator());
        }

        exchange.getOut().setBody(vehicleSpec);
    }
}
