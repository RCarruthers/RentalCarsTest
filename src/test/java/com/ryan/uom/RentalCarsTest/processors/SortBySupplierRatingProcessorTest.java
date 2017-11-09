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
public class SortBySupplierRatingProcessorTest {

    @Autowired
    CamelContext camelContext;

    @Autowired
    SortBySupplierRatingProcessor processor;

    @Test
    public void itShouldSortBySupplierRating() throws Exception {
        Exchange exchange = CamelHelper.getExchange(camelContext);
        processor.process(exchange);
        System.out.println(exchange.getOut().getBody());
        Assert.assertTrue(exchange.getOut().getBody() instanceof String);
        Assert.assertEquals("1. Skoda Fabia - 8 - 8.2 - 16.2" + System.lineSeparator()
                        + "2. Ford Focus - 5 - 8.9 - 13.9" + System.lineSeparator()
                        + "3. VW Passat Estate - 5 - 8.9 - 13.9" + System.lineSeparator(),
                exchange.getOut().getBody());
    }
}