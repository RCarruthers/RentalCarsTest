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
public class SortBySippProcessorTest {

    @Autowired
    CamelContext camelContext;

    @Autowired
    SortBySippProcessor processor;

    @Test
    public void itShouldSortBySippRatingsPerCarType() throws Exception {
        Exchange exchange = CamelHelper.getExchange(camelContext);
        processor.process(exchange);
        System.out.println(exchange.getOut().getBody());
        Assert.assertTrue(exchange.getOut().getBody() instanceof String);
        Assert.assertEquals("1. Ford Focus - CDMR - Compact - 5 doors - Manual - Petrol - AC" + System.lineSeparator()
                        + "2. VW Passat Estate - IWMR - Intermediate - Estate - Manual - Petrol - AC" + System.lineSeparator()
                        + "3. Skoda Fabia - CDAR - Compact - 5 doors - Automatic - Petrol - AC" + System.lineSeparator(),
                exchange.getOut().getBody());
    }

}