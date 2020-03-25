package com.myproject.web_app;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


/**
 * Flight controller.
 */
@Controller
public class FLightController {

    /**
     * Goto FLights list page.
     *
     * @return view name
     */
    @GetMapping(value = "/flights")
    public final String flights(Model model) {
        return "flights";
    }

    /**
     * Goto flight page.
     *
     * @return view name
     */
    @GetMapping(value = "/flight")
    public final String gotoAddFlightPage(Model model) {
        return "flight";
    }
}
