package com.ryan.uom.RentalCarsTest;

import com.ryan.uom.RentalCarsTest.model.Search;
import com.ryan.uom.RentalCarsTest.model.Vehicle;
import com.ryan.uom.RentalCarsTest.model.VehicleList;
import org.apache.camel.CamelContext;
import org.apache.camel.Exchange;
import org.apache.camel.impl.DefaultExchange;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RentalCarsTestApplicationTests {

    @Autowired
    private CamelContext context;

    @Test
    public void contextLoads() {
        Assert.assertNotNull(context);
    }

    public void itShouldSortCarsByPrice() {

    }


    public Exchange getExchange() {
        Exchange exchange = new DefaultExchange(context);
        exchange.getIn().setBody(getVehicleList(), VehicleList.class);
        return exchange;
    }

    public VehicleList getVehicleList() {
        VehicleList vehicleList = new VehicleList();
        Search search = new Search();
        List<Vehicle> vehicles = new ArrayList<Vehicle>();
        vehicles.add(getVehicle("Ford Focus", "CDMR", 157.85, "Hertz", 8.9, 0));
        vehicles.add(getVehicle("VW Passat Estate", "IWMR", 469.37, "Hertz", 8.9, 0));
        vehicles.add(getVehicle("Skoda Fabia", "CDAR", 219.71, "Sixt", 8.2, 0));
        vehicleList.setSearch(new Search());
        search.setVehicleList(vehicles);
        return vehicleList;
    }

    public Vehicle getVehicle(String name, String sipp, double price, String supplier, Double rating, int score) {
        Vehicle vehicle = new Vehicle();
        vehicle.setName(name);
        vehicle.setSipp(sipp);
        vehicle.setPrice(price);
        vehicle.setSupplier(supplier);
        vehicle.setRating(rating);
        vehicle.setScore(score);
        return vehicle;
    }
}
