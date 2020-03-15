package com.myproject;

import com.myproject.dao.PassengerDao;
import com.myproject.model.Passenger;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class PassengerServiceImpl implements PassengerService {

    private static final Logger LOGGER = LoggerFactory.getLogger(FlightServiceImpl.class);

    private final PassengerDao passengerDao;

    public PassengerServiceImpl(PassengerDao passengerDao) {
        this.passengerDao = passengerDao;
    }


    @Override
    @Transactional(readOnly = true)
    public List<Passenger> findAll() {
        LOGGER.trace("findAll()");
        return passengerDao.findAll();
    }

    @Override
    public Optional<Passenger> findById(Integer passengerId) {
        LOGGER.debug("findById(passengerId:{})", passengerId);
        return passengerDao.findById(passengerId);
    }

    @Override
    public Integer create(Passenger passenger) {
        LOGGER.debug("create(passenger:{})", passenger);
        return passengerDao.create(passenger);
    }

    @Override
    public int update(Passenger passenger) {
        LOGGER.debug("create(passenger:{})", passenger);
        return passengerDao.update(passenger);
    }

    @Override
    public int delete(Integer passengerId) {
        LOGGER.debug("create(passengerId:{})", passengerId);
        return passengerDao.delete(passengerId);
    }
}
