package com.myproject.rest;

import com.myproject.FlightDtoService;
import com.myproject.model.dto.FlightDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.Collection;

/**
 * FlightDto rest Controller
 */
@RestController
@RequestMapping("/flightsDto")
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
    @GetMapping(value = "/flights_quantity")
    public final Collection<FlightDto> flightDtos() {

        LOGGER.debug("flight Dtos()");
        return flightDtoService.findAllWithQuantityPassengers();
    }

    /**
     * @param dateFrom
     * @param dateTo
     * @return Collection of flights with date filter
     */
    @GetMapping
    public Collection<FlightDto> findDtoWithDateFilter
    (@RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate dateFrom
            , @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate dateTo) {

        LOGGER.debug("find with date filter({},{})", dateFrom, dateTo);
        return flightDtoService.findAllWithQuantityPassengersAndDateFilter(dateFrom, dateTo);
    }
}
