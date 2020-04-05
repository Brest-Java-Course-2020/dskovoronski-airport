package com.myproject;

import com.myproject.rest.FlightController;
import org.junit.jupiter.api.extension.ExtendWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;


@ExtendWith(SpringExtension.class)
@ContextConfiguration(locations = {"classpath:app-context-test.xml"})
public class FlightControllerIT {

    private static final Logger LOGGER = LoggerFactory.getLogger(FlightControllerIT.class);

    public static final String FLIGHTS_ENDPOINT = "/flights";

    @Autowired
    private FlightController flightController;
}