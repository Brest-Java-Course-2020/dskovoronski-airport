package com.myproject.jdbc;

import com.myproject.dao.CustomerDao;
import com.myproject.model.Passenger;

import java.util.List;
import java.util.Optional;

public class CustomerDaoJdbc implements CustomerDao {
    @Override
    public List<Passenger> findAll() {
        return null;
    }

    @Override
    public Optional<Passenger> findById(Integer passengerId) {
        return Optional.empty();
    }

    @Override
    public Integer create(Passenger passenger) {
        return null;
    }

    @Override
    public int update(Passenger passenger) {
        return 0;
    }

    @Override
    public int delete(Integer passengerId) {
        return 0;
    }
}
