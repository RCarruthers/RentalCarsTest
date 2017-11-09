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
public class SortByRatingsPerCarTypeProcessorTest {

    @Autowired
    CamelContext camelContext;

    @Autowired
    SortByRatingsPerCarTypeProcessor processor;

    @Test
    public void itShouldSortByRatingsPerCarType() throws Exception {
        Exchange exchange = CamelHelper.getExchange(camelContext);
        processor.process(exchange);
        System.out.println(exchange.getOut().getBody());
        Assert.assertTrue(exchange.getOut().getBody() instanceof String);
        Assert.assertEquals("1. Ford Focus - Compact - Hertz - 8.9"
                + System.lineSeparator() + "2. VW Passat Estate - Intermediate - Hertz - 8.9" + System.lineSeparator(), exchange.getOut().getBody());
    }
}
