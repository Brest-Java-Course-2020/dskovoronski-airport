package com.myproject.model.dto;

import java.sql.Date;

public class FlightDto {

    /**
     * Constructor without arguments.
     */
    public FlightDto() {
    }

    /**
     * Constructor with Flight number, name of route flight and date
     * @param flightId Flight number
     * @param flight name of route flight
     * @param date Date of flight
     */
    public FlightDto(Integer flightId, String flight, Date date) {
        this.flightId = flightId;
        this.flight = flight;
        this.date = date == null ? null : (Date) date.clone();
    }

    /**
     * Flight number
     */
    private Integer flightId;

    /**
     * Name of flight direction
     */
    private String flight;

    /**
     * Date of flight
     */
    private Date date;

     /**
     * Quantity of passengers
     */
    private Integer quantityPassengers;

    /**
     * Return Flight number
     * @return flightId
     */
    public Integer getFlightId() {
        return flightId;
    }

    /**
     * Set Flight number
     * @param flightId Flight number
     */
    public void setFlightId(Integer flightId) {
        this.flightId = flightId;
    }

    /**
     * Return name of route flight
     * @return flight
     */
    public String getFlight() {
        return flight;
    }

    /**
     * Set name of route flight
     * @param flight name of route flight
     */
    public void setFlight(String flight) {
        this.flight = flight;
    }

    /**
     * Return Date of flight
     * @return date
     */
    public Date getDate() {
        return date == null ? null : (Date) date.clone();
    }

    /**
     * Set Date of flight
     * @param date
     */
    public void setDate(Date date) {
        this.date = date == null ? null : (Date) date.clone();
    }

    /**
     * Return Quantity of passengers
     * @return quantityPassengers
     */
    public Integer getQuantityPassengers() {
        return quantityPassengers;
    }

    /**
     * Set quantity of passengers
     * @param quantityPassengers
     */
    public void setQuantityPassengers(Integer quantityPassengers) {
        this.quantityPassengers = quantityPassengers;
    }
}
