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
}
