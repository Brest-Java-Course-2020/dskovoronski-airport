package com.myproject.dao;

import com.myproject.model.dto.FlightDto;

import java.util.Date;
import java.util.List;

public interface FlightDtoDao {
         /**
         * Get all flights with quantity passengers.
         *
         * @return Flights list.
         */
        List <FlightDto> findAllWithQuantityPassengers();

        List <FlightDto> findAllWithQuantityPassengersAndDateFilter(Date dateFrom, Date dateTo);

}
