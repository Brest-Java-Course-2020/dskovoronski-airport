package com.myproject.rest;

import com.myproject.FlightDtoService;
import com.myproject.model.dto.FlightDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

/**
 * FlightDto rest Controller
 */
@RestController
public class FlightDtoController {

    private static final Logger LOGGER = LoggerFactory.getLogger(FlightDtoController.class);

    private final FlightDtoService flightDtoService;

    public FlightDtoController(FlightDtoService flightDtoService) {
        this.flightDtoService = flightDtoService;
    }

    /**
     * Get flight with quantity passengers.
     *
     * @return Department Dtos collection.
     */
    @GetMapping(value = "/flight_quantity")
    public final Collection<FlightDto> flightDtos() {

        LOGGER.debug("flightDtos()");
        return flightDtoService.findAllWithQuantityPassengers();
    }
}
