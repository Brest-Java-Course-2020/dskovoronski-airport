package com.myproject.model;

import java.sql.Date;

/**
 * POJO Flight for model.
 */
public class Flight {

    /**
     * Constructor without arguments.
     */
    public Flight() {
    }

    /**
     * Constructor with Flight id, name of route flight and date.
     * @param flightId Flight id.
     * @param flight name of route flight.
     * @param date Date of flight.
     */
    public Flight(Integer flightId, String flight, Date date) {
        this.flightId = flightId;
        this.flight = flight;
        this.date = date;
    }

    /**
     * Flight id.
     */
    private Integer flightId;

    /**
     * Name of flight direction .
     */
    private String flight;

    /**
     * Date of flight.
     */
    private Date date;

    /**
     * Return Flight id.
     * @return flightId.
     */
    public Integer getFlightId() {
        return flightId;
    }

    /**
     * Set Flight id.
     * @param flightId Flight id.
     */
    public void setFlightId(Integer flightId) {
        this.flightId = flightId;
    }

    /**
     * Return name of route flight.
     * @return flight .
     */
    public String getFlight() {
        return flight;
    }

    /**
     * Set name of route flight.
     * @param flight name of route flight.
     */
    public void setFlight(String flight) {
        this.flight = flight;
    }

    /**
     * Return Date of flight.
     * @return date Date of flight.
     */
    public Date getDate() {
        return date;
    }

    /**
     * Set Date of flight.
     * @param date Date of flight.
     */
    public void setDate(Date date) {
        this.date = date;
    }

}
