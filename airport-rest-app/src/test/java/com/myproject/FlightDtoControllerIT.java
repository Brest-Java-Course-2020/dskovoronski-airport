package com.myproject;

import com.myproject.dao.FlightDtoDao;
import com.myproject.model.dto.FlightDto;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;



@ExtendWith(SpringExtension.class)
@ContextConfiguration(locations = {"classpath:app-context-test.xml"})
public class FlightDtoControllerIT {

    private static final Logger LOGGER = LoggerFactory.getLogger(FlightDtoControllerIT.class);

//    ObjectMapper objectMapper = new ObjectMapper();
//
//    @Autowired
//    private CustomExceptionHandler customExceptionHandler;
//
//    @Autowired
//    private FlightDtoController flightDtoController;
//
//    @Autowired
//    private FlightController flightController;
//
//    private MockMvc mockMvcFlightDto;
//    private MockMvc mockMvcFlight;
//
//    MockMvcFlightDtoService flightDtoServiceMockMvc = new MockMvcFlightDtoService();
//    MockMvcFlightService flightServiceMockMvc = new MockMvcFlightService();
//
//    @BeforeEach
//    public void setup() {
//        mockMvcFlightDto = MockMvcBuilders.standaloneSetup(flightDtoController)
//                .setMessageConverters(new MappingJackson2HttpMessageConverter())
//                .setControllerAdvice(customExceptionHandler)
//                .alwaysDo(MockMvcResultHandlers.print())
//                .build();
//    }
//
//    @Test
//    void shouldFindPassengersWithFilter() throws Exception {
//
//        mockMvcFlight = MockMvcBuilders.standaloneSetup(flightController)
//                .setMessageConverters(new MappingJackson2HttpMessageConverter())
//                .setControllerAdvice(customExceptionHandler)
//                .alwaysDo(MockMvcResultHandlers.print())
//                .build();
//
//        LocalDate dateFrom = LocalDate.now().minusMonths(1);
//        LocalDate dateTo = LocalDate.now();
//        Flight flight = new Flight();
//        flight.setDirection(RandomStringUtils.randomAlphabetic(DIRECTION_MAX_SIZE));
//
//        Integer id = flightServiceMockMvc.create(flight);
//        assertTrue(id != null);
//        List<FlightDto> flightsDtoList = flightDtoServiceMockMvc.findFlightsWithFilter(dateFrom,dateTo);
//
//        assertEquals(flight.getDirection(),flightsDtoList.get(0).getDirection());
//
//
//
//    }
//       class MockMvcFlightDtoService{
//
//        public List<FlightDto> findFlightsWithFilter(LocalDate dateFrom, LocalDate dateTo) throws Exception {
//
//            LOGGER.debug("REST FlightDtoTest findFlightsWithFilter({}, {})", dateFrom, dateTo);
//
//            MockHttpServletResponse response = mockMvcFlightDto.perform(get("/flights_quantity" +"?dateFrom="+dateFrom+"&dateTo="+dateTo)
//                    .contentType(MediaType.APPLICATION_JSON)
//                    .accept(MediaType.APPLICATION_JSON)
//            ).andExpect(status().isOk())
//                    .andReturn().getResponse();
//            assertNotNull(response);
//
//            return objectMapper.readValue(response.getContentAsString(), new TypeReference<List<FlightDto>>() {
//            });
//        }
//
//        public List<FlightDto> findAllWithQuantityPassengers() throws Exception {
//
//            LOGGER.debug("FLIGHTS_DTO TEST findAll()");
//            MockHttpServletResponse response = mockMvcFlightDto.perform(get("/flights_quantity"+"/findAllWithQuantityPassengers")
//                    .contentType(MediaType.APPLICATION_JSON)
//                    .accept(MediaType.APPLICATION_JSON)
//            ).andExpect(status().isOk())
//                    .andReturn().getResponse();
//            assertNotNull(response);
//            return objectMapper.readValue(response.getContentAsString(), new TypeReference<List<FlightDto>>() {
//            });
//        }
//    }
//
//
//    class MockMvcFlightService{
//        public Integer create(Flight flight) throws Exception {
//
//            LOGGER.debug(" create({})", flight);
//            String json = objectMapper.writeValueAsString(flight);
//            MockHttpServletResponse response =
//                    mockMvcFlight.perform(post("/flights")
//                            .contentType(MediaType.APPLICATION_JSON)
//                            .content(json)
//                            .accept(MediaType.APPLICATION_JSON)
//                    ).andExpect(status().isOk())
//                            .andReturn().getResponse();
//
//            return objectMapper.readValue(response.getContentAsString(), Integer.class);
//        }
//    }


    @Autowired
    FlightDtoDao flightDtoDao;
    @Test
    public void shouldFindAllWithQuantityPassengers() {
        LOGGER.debug("TEST findAll() with quantity passengers");
        List<FlightDto> flights = flightDtoDao.findAllWithQuantityPassengers();
        assertNotNull(flights);
        assertTrue(flights.size() > 0);
        assertTrue(flights.get(0).getQuantityPassengers().intValue() > 0);
    }

    @Test
    public void findAllWithQuantityPassengersAndDateFilter() {
        LOGGER.debug("TEST findAll() with quantity passengers with date filter");
        LocalDate dateFrom = LocalDate.now().minusMonths(1);
        LocalDate dateTo = LocalDate.now();
        assertTrue(dateFrom.compareTo(dateTo)<0);
        List<FlightDto> flights = flightDtoDao.findAllWithQuantityPassengersAndDateFilter(dateFrom,dateTo);
        assertNotNull(flights);
        List<FlightDto> flightList = flightDtoDao.findAllWithQuantityPassengersAndDateFilter(dateFrom,dateTo);
        assertTrue(flightList.size() > 0);

    }
}
