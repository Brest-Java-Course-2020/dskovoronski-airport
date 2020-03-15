package com.myproject;


import com.myproject.dao.FlightDtoDao;
import com.myproject.model.dto.FlightDto;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(locations = {"classpath*:test-db.xml", "classpath*:test-dao.xml", "classpath:dao.xml"})
public class FlightDtoDaoJdbcIT {
    @Autowired
    FlightDtoDao flightDtoDao;

    @Test
    public void shouldFindAllWithAvgSalary() {
        List<FlightDto> flights = flightDtoDao.findAllWithQuantityPassengers();
        assertNotNull(flights);
        assertTrue(flights.size() > 0);
        assertTrue(flights.get(0).getQuantityPassengers().intValue() > 0);
    }
}