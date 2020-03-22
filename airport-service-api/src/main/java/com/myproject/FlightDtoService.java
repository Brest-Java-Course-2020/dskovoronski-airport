package com.myproject;

import com.myproject.model.Flight;
import com.myproject.model.dto.FlightDto;

import java.util.Date;
import java.util.List;

public interface FlightDtoService {
    /**
     * Get all flights with quantity passengers.
     *
     * @return Flights list.
     */
    List<FlightDto> findAllWithQuantityPassengers();

    /**
     * Get all flights with quantity passengers and filter of date.
     *
     * @return Flights list.
     */
    List <FlightDto> findAllWithQuantityPassengersAndDateFilter(Date dateFrom, Date dateTo);

}
