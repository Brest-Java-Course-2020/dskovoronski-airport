package com.myproject.web_app;

import com.myproject.FlightService;
import com.myproject.PassengerService;
import com.myproject.model.Passenger;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import java.util.Optional;

/**
 * Passenger controller.
 */
@Controller
public class PassengerController {

    private static final Logger LOGGER = LoggerFactory.getLogger(PassengerController.class);

    private final PassengerService passengerService;

    private  final FlightService flightService;


    public PassengerController(PassengerService passengerService, FlightService flightService) {
        this.passengerService = passengerService;
        this.flightService = flightService;
    }

    /**
     * Goto passengers page.
     *
     * @return view name
     */
    @GetMapping(value = "/passengers")
    public final String passengers(Model model) {

        LOGGER.debug("passengers()");
        model.addAttribute("passengers", passengerService.findAll());
        return "passengers";
    }

    /**
     * Goto edit passenger page.
     *
     * @return view name
     */
    @GetMapping(value = "/passenger/{id}")
    public final String gotoEditPassengerPage(@PathVariable Integer id, Model model) {

        LOGGER.debug("gotoEditPassengerPage({},{})", id, model);
        Optional<Passenger> optionalPassenger = passengerService.findById(id);
        if (optionalPassenger.isPresent()) {
            model.addAttribute("isNew", false);
            model.addAttribute("passenger", optionalPassenger.get());
            model.addAttribute("flights", flightService.findAll());
            return "passenger";
        } else {
            // TODO employee not found - pass error message as parameter or handle not found error
            return "redirect:passengers";
        }
    }

    /**
     * Update passenger.
     *
     * @param passenger passenger with filled data.
     * @param result    binding result
     * @return          view name
     */
    @PostMapping(value = "/passenger/{id}")
    public String updatePassenger(@Valid Passenger passenger,
                                 BindingResult result) {

        LOGGER.debug("updatePassenger({}, {})", passenger, result);
        // TODO implement validation
        if (result.hasErrors()) {
            return "passenger";
        } else {
            this.passengerService.update(passenger);
            return "redirect:/passengers";
        }
    }

    /**
     * Goto add passenger page.
     *
     * @return view name
     */
    @GetMapping(value = "/passenger")
    public final String gotoAddPassengerPage(Model model) {

        LOGGER.debug("gotoAddPassengerPage({})", model);
        model.addAttribute("isNew", true);
        model.addAttribute("passenger", new Passenger(1));
        model.addAttribute("flights", flightService.findAll());
        return "passenger";
    }

    /**
     * Persist new passenger into persistence storage.
     *
     * @param passenger new employee with filled data.
     * @param result binding result.
     * @return view name
     */
    @PostMapping(value = "/passenger")
    public String addPassenger(@Valid Passenger passenger,
                              BindingResult result) {

        LOGGER.debug("addPassenger({}, {})", passenger, result);
        // TODO implement validation
        if (result.hasErrors()) {
            return "employee";
        } else {
            this.passengerService.create(passenger);
            return "redirect:/passengers";
        }
    }

    /**
     * Delete passenger.
     *
     * @return view name
     */
    @GetMapping(value = "/passenger/{passengerId}/delete")
    public final String deletePassengerById(@PathVariable Integer passengerId, Model model) {

        LOGGER.debug("delete({},{})", passengerId, model);
        passengerService.delete(passengerId);
        return "redirect:/passengers";
    }
}
