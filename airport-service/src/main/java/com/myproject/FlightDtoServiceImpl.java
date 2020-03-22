package com.myproject;

import com.myproject.dao.FlightDtoDao;
import com.myproject.model.dto.FlightDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
@Transactional
public class FlightDtoServiceImpl implements FlightDtoService {

    private static final Logger LOGGER = LoggerFactory.getLogger(FlightServiceImpl.class);

    private final FlightDtoDao flightDtoDao;

    public FlightDtoServiceImpl(FlightDtoDao flightDtoDao) {
        this.flightDtoDao = flightDtoDao;
    }

    @Override
    public List<FlightDto> findAllWithQuantityPassengers() {
        LOGGER.trace("findAllWithQuantityPassengers()");
        return flightDtoDao.findAllWithQuantityPassengers();
    }

    @Override
    public List<FlightDto> findAllWithQuantityPassengersAndDateFilter(Date dateFrom, Date dateTo) {
        LOGGER.trace("findAllWithQuantityPassengersAndDateFilter()");
        return flightDtoDao.findAllWithQuantityPassengersAndDateFilter(dateFrom,dateTo);
    }

}
