package com.myproject.jdbc;

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
import java.time.LocalDate;
import java.util.List;

import static com.myproject.constants.FlightConstants.*;


public class FlightDtoDaoJdbc implements FlightDtoDao {

   private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    public FlightDtoDaoJdbc(NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
    }

    private static final Logger LOGGER = LoggerFactory.getLogger(FlightDtoDaoJdbc.class);

    @Value("${flightDto.findAllWithQuantityPassengers}")
    private String findAllWithQuantityPassengers;

    @Value("${flightDto.findAllWithQuantityPassengersAndDateFilter}")
    private String findAllWithQuantityPassengersAndDateFilter;

    //FlightDtoRowMapper flightDtoRowMapper= new FlightDtoRowMapper();

    @Override
    public List<FlightDto> findAllWithQuantityPassengers() {
        LOGGER.debug("findAllWithQuantityPassengers()");
        List<FlightDto>flights = namedParameterJdbcTemplate.query(
                findAllWithQuantityPassengers, BeanPropertyRowMapper.newInstance(FlightDto.class));
        return flights;
    }

    @Override
    public List<FlightDto> findAllWithQuantityPassengersAndDateFilter(LocalDate dateFrom, LocalDate dateTo) {
        LOGGER.debug("findAllWithQuantityPassengersAndDateFilter(Date dateFrom=:{}, Date dateTo=:{})", dateFrom, dateTo);
        MapSqlParameterSource mapSqlParameterSource = new MapSqlParameterSource();
        mapSqlParameterSource.addValue(DATE_FROM, dateFrom);
        mapSqlParameterSource.addValue(DATE_TO, dateTo);
        List<FlightDto>flights = namedParameterJdbcTemplate.query
                (findAllWithQuantityPassengersAndDateFilter,mapSqlParameterSource,BeanPropertyRowMapper.newInstance(FlightDto.class));
        return flights;
    }
//    private static class FlightDtoRowMapper implements RowMapper<FlightDto> {
//
//        @Override
//        public FlightDto mapRow(ResultSet resultSet, int i) throws SQLException {
//            FlightDto flightDto = new FlightDto();
//            flightDto.setFlightId(resultSet.getInt(FLIGHT_ID));
//            flightDto.setDirection(resultSet.getString(DIRECTION));
//            flightDto.setDate(resultSet.(DATE_FLIGHT));
//            flightDto.setQuantityPassengers(resultSet.get);
//            return flightDto;
//            }
//    }
}
