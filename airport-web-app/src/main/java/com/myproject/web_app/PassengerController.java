package com.myproject.web_app;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Passenger controller.
 */
@Controller
public class PassengerController {

    /**
     * Goto passengers page.
     *
     * @return view name
     */
    @GetMapping(value = "/passengers")
    public final String passengers() {
        return "passengers";
    }

    /**
     * Goto passenger page.
     *
     * @return view name
     */
    @GetMapping(value = "/passenger")
    public final String passenger() {
        return "passenger";
    }
}
