package com.myproject.jdbc;

import com.myproject.model.Flight;
import com.myproject.model.dto.FlightDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.myproject.dao.FlightDtoDao;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import static com.myproject.constansts.FlightConstants.*;

public class FlightDtoDaoJdbc implements FlightDtoDao {

    private FlightDtoRowMapper flightDtoRowMapper = new FlightDtoRowMapper();

    private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    public FlightDtoDaoJdbc(NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
    }

    private static final Logger LOGGER = LoggerFactory.getLogger(FlightDtoDaoJdbc.class);

    @Value("${flightDto.findAllWithQuantityPassengers}")
    private String findAllWithQuantityPassengers;

    @Value("${flightDto.findAllWithQuantityPassengersAndDateFilter}")
    private String findAllWithQuantityPassengersAndDateFilter;


    @Override
    public List<FlightDto> findAllWithQuantityPassengers() {
        LOGGER.debug("findAllWithQuantityPassengers()");
        List<FlightDto>flights = namedParameterJdbcTemplate.query(
                findAllWithQuantityPassengers,flightDtoRowMapper);
        return flights;
    }

    @Override
    public List<FlightDto> findAllWithQuantityPassengersAndDateFilter(Date dateFrom, Date dateTo) {
        LOGGER.debug("findAllWithQuantityPassengersAndDateFilter(Date dateFrom, Date dateTo:{})");
        MapSqlParameterSource mapSqlParameterSource = new MapSqlParameterSource();
        mapSqlParameterSource.addValue(DATE_FROM, dateFrom);
        mapSqlParameterSource.addValue(DATE_TO, dateTo);
        List<FlightDto>flights = namedParameterJdbcTemplate.query
                (findAllWithQuantityPassengersAndDateFilter,mapSqlParameterSource,flightDtoRowMapper);
        return flights;
    }
    private static class FlightDtoRowMapper implements RowMapper<FlightDto> {

        @Override
        public FlightDto mapRow(ResultSet resultSet, int i) throws SQLException {
            FlightDto flightDto = new FlightDto();
            flightDto.setFlightId(resultSet.getInt(FLIGHT_ID));
            flightDto.setDate(resultSet.getDate(DATE_FLIGHT));
            flightDto.setDirection(resultSet.getString(DIRECTION));
            return flightDto;
        }
    }
}
