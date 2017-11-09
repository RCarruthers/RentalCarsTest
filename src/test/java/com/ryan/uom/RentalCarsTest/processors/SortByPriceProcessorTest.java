package com.ryan.uom.RentalCarsTest.processors;

import com.ryan.uom.RentalCarsTest.util.CamelHelper;
import org.apache.camel.CamelContext;
import org.apache.camel.Exchange;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class SortByPriceProcessorTest {

    @Autowired
    CamelContext camelContext;

    @Autowired
    SortByPriceProcessor processor;

    @Test
    public void itShouldSortCarsByPriceTest() throws Exception {
        Exchange exchange = CamelHelper.getExchange(camelContext);
        processor.process(exchange);
        System.out.println(exchange.getOut().getBody());
        Assert.assertTrue(exchange.getOut().getBody() instanceof String);
        Assert.assertEquals(exchange.getOut().getBody(), "1. Ford Focus - 157.85" + System.lineSeparator()
                + "2. Skoda Fabia - 219.71" + System.lineSeparator() + "3. VW Passat Estate - 469.37" + System.lineSeparator());
    }
}