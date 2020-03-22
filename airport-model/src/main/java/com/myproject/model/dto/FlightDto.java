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
     * @param direction name of route flight
     * @param date Date of flight
     */
    public FlightDto(Integer flightId, String direction, Date date) {
        this.flightId = flightId;
        this.direction = direction;
        this.date = date == null ? null : (Date) date.clone();
    }

    /**
     * Flight number
     */
    private Integer flightId;

    /**
     * Name of flight direction
     */
    private String direction;

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
     * Return name of direction route flight
     * @return direction
     */
    public String getDirection() {
        return direction;
    }

    /**
     * Set name of direction route flight
     * @param direction name of direction route flight
     */
    public void setDirection(String direction) {
        this.direction = direction;
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
