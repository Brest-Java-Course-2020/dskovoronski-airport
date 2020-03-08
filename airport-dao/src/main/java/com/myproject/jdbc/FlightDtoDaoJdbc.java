package com.myproject.jdbc;

import com.myproject.model.dto.FlightDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.myproject.dao.FlightDtoDao;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import java.util.List;

public class FlightDtoDaoJdbc implements FlightDtoDao {

    private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    public FlightDtoDaoJdbc(NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
    }

    private static final Logger LOGGER = LoggerFactory.getLogger(FlightDtoDaoJdbc.class);

    @Value("${flightDto.findAllWithQuantityPassengers}")
    private String findAllWithQuantityPassengers;


    @Override
    public List<FlightDto> findAllWithQuantityPassengers() {
        LOGGER.debug("findAllWithQuantityPassengers()");
        List<FlightDto>flights = namedParameterJdbcTemplate.query(
                findAllWithQuantityPassengers,BeanPropertyRowMapper.newInstance(FlightDto.class));
        return flights;
    }
}
