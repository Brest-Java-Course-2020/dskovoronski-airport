package com.myproject.dao;

import java.util.List;

public interface FlightDtoDao {
         /**
         * Get all flights with quantity passengers.
         *
         * @return Flights list.
         */
        List <FlightDtoDao> findAllWithQuantityPassengers();

}
