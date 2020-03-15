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
     * @param direction name of direction flight.
     * @param date Date of flight.
     */
    public Flight(Integer flightId, String direction, Date date) {
        this.flightId = flightId;
        this.direction = direction;
        this.date = date == null ? null : (Date) date.clone();
    }

    /**
     * Flight id.
     */
    private Integer flightId;

    /**
     * Name of flight direction .
     */
    private String direction;

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
     * Return name of direction flight.
     * @return direction .
     */
    public String getDirection() {
        return direction;
    }

    /**
     * Set name of route flight.
     * @param direction name of direction flight.
     */
    public void setDirection(String direction) {
        this.direction = direction;
    }

    /**
     * Return Date of flight.
     * @return date Date of flight.
     */
    public Date getDate() {
        return date == null ? null : (Date) date.clone();
    }

    /**
     * Set Date of flight.
     * @param date Date of flight.
     */
    public void setDate(Date date) {
        this.date = date == null ? null : (Date) date.clone();
    }

}
