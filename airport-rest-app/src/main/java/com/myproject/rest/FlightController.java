package com.myproject.rest;

import com.myproject.FlightService;
import com.myproject.model.Flight;
import com.myproject.rest.exceptions.ErrorResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.Collection;
import java.util.Optional;

import static com.myproject.constants.RestConstants.*;

/**
 * Flight rest Controller
 */
@RestController
public class FlightController {

    private static final Logger LOGGER = LoggerFactory.getLogger(FlightController.class);

    private final FlightService flightService;

    public FlightController(FlightService flightService) {
        this.flightService = flightService;
    }

    /**
     * Go to flights list page
     *
     * @return view name
     */
    @GetMapping(value = "/flights")
    public final Collection<Flight> flights(){
        LOGGER.debug("flights()");
        return flightService.findAll();
    }

    /**
     * find flight by id
     * @param id
     * @return flight
     */
    @GetMapping(value = "/flights/{id}")
     public ResponseEntity<Flight> findById(@PathVariable Integer id){
            LOGGER.debug("find flight by id({})", id);

            Optional<Flight> optional = flightService.findById(id);
            return optional.isPresent()
                    ? new ResponseEntity<>(optional.get(), HttpStatus.OK)
                    : new ResponseEntity(
                    new ErrorResponse(FLIGHT_NOT_FOUND,
                            Arrays.asList(FLIGHT_NOT_FOUND_BY_ID + id)),
                    HttpStatus.NOT_FOUND);
            //return flightService.findById(id).orElseThrow(()->new FlightNotFoundException(id)); // more easy
    }

    /**
     * create new flight
     * @param flight
     * @return id flight
     */
    @PostMapping(path = "/flights", consumes = "application/json", produces = "application/json")
    public ResponseEntity<Integer> createFlight(@RequestBody Flight flight) {

        LOGGER.debug("createFlight({})", flight);
        Integer id = flightService.create(flight);
        return new ResponseEntity<>(id, HttpStatus.OK); //???????????
    }

    /**
     * Update flight
     * @param flight
     * @return id flight
     */
    @PutMapping(value = "/flights", consumes = {"application/json"}, produces = {"application/json"})
    public ResponseEntity<Integer> updateFlight(@RequestBody Flight flight) {

        LOGGER.debug("updateFlight({})", flight);
        int result = flightService.update(flight);
        return new ResponseEntity(result, HttpStatus.OK);

    }

    /**
     * delete flight
     * @param id
     * @return result of delete
     */
    @DeleteMapping(value = "/flights/{id}", produces = {"application/json"})
    public ResponseEntity<Integer> deleteFlight(@PathVariable Integer id) {

        int result = flightService.delete(id);
        return new ResponseEntity(result, HttpStatus.OK);
    }
}
