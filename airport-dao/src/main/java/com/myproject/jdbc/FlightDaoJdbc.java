package com.myproject.jdbc;

import com.myproject.dao.FlightDao;
import com.myproject.model.Flight;

import java.util.List;
import java.util.Optional;

public class FlightDaoJdbc implements FlightDao {

    @Override
    public List<Flight> findAll() {
        return null;
    }

    @Override
    public Optional<Flight> findById(Integer flightId) {
        return Optional.empty();
    }

    @Override
    public Integer create(Flight flight) {
        return null;
    }

    @Override
    public int update(Flight flight) {
        return 0;
    }

    @Override
    public int delete(Integer flightId) {
        return 0;
    }
}
