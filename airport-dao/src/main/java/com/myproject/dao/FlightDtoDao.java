package com.myproject.dao;

import com.myproject.model.dto.FlightDto;

import java.util.List;

public interface FlightDtoDao {
         /**
         * Get all flights with quantity passengers.
         *
         * @return Flights list.
         */
        List <FlightDto> findAllWithQuantityPassengers();

}
