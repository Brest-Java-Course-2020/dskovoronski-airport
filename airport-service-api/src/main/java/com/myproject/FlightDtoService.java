package com.myproject;

import com.myproject.model.dto.FlightDto;

import java.util.List;

public interface FlightDtoService {
    /**
     * Get all flights with quantity passengers.
     *
     * @return Flights list.
     */
    List<FlightDto> findAllWithQuantityPassengers();

}
