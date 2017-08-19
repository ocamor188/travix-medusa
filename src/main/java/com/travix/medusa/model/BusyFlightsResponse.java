package com.travix.medusa.model;

import java.time.LocalDateTime;
import java.util.Date;


public class BusyFlightsResponse {

    private String airline;

    private String supplier;

    private double fare;

    private String departureAirportCode;

    private String destinationAirportCode;

    private LocalDateTime departureDate;

    private LocalDateTime arrivalDate;

    public BusyFlightsResponse(String airline, String supplier, double fare, String departureAirportCode,
                               String destinationAirportCode, LocalDateTime departureDate, LocalDateTime arrivalDate) {
        this.airline = airline;
        this.supplier = supplier;
        this.fare = fare;
        this.departureAirportCode = departureAirportCode;
        this.destinationAirportCode = destinationAirportCode;
        this.departureDate = departureDate;
        this.arrivalDate = arrivalDate;
    }

    public BusyFlightsResponse() {
        
    }


    public String getAirline() {
        return airline;
    }

    public void setAirline(String airline) {
        this.airline = airline;
    }

    public String getSupplier() {
        return supplier;
    }

    public void setSupplier(String supplier) {
        this.supplier = supplier;
    }

    public double getFare() {
        return fare;
    }

    public void setFare(double fare) {
        this.fare = Math.round(fare * 100) / 100;
    }

    public String getDepartureAirportCode() {
        return departureAirportCode;
    }

    public void setDepartureAirportCode(String departureAirportCode) {
        this.departureAirportCode = departureAirportCode;
    }

    public String getDestinationAirportCode() {
        return destinationAirportCode;
    }

    public void setDestinationAirportCode(String destinationAirportCode) {
        this.destinationAirportCode = destinationAirportCode;
    }

    public LocalDateTime getDepartureDate() {
        return departureDate;
    }

    public void setDepartureDate(LocalDateTime departureDate) {
        this.departureDate = departureDate;
    }

    public LocalDateTime getArrivalDate() {
        return arrivalDate;
    }

    public void setArrivalDate(LocalDateTime arrivalDate) {
        this.arrivalDate = arrivalDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof BusyFlightsResponse)) return false;

        BusyFlightsResponse that = (BusyFlightsResponse) o;

        if (Double.compare(that.getFare(), getFare()) != 0) return false;
        if (getAirline() != null ? !getAirline().equals(that.getAirline()) : that.getAirline() != null) return false;
        if (getSupplier() != null ? !getSupplier().equals(that.getSupplier()) : that.getSupplier() != null)
            return false;
        if (getDepartureAirportCode() != null ? !getDepartureAirportCode().equals(that.getDepartureAirportCode()) : that.getDepartureAirportCode() != null)
            return false;
        if (getDestinationAirportCode() != null ? !getDestinationAirportCode().equals(that.getDestinationAirportCode()) : that.getDestinationAirportCode() != null)
            return false;
        if (getDepartureDate() != null ? !getDepartureDate().equals(that.getDepartureDate()) : that.getDepartureDate() != null)
            return false;
        return getArrivalDate() != null ? getArrivalDate().equals(that.getArrivalDate()) : that.getArrivalDate() == null;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = getAirline() != null ? getAirline().hashCode() : 0;
        result = 31 * result + (getSupplier() != null ? getSupplier().hashCode() : 0);
        temp = Double.doubleToLongBits(getFare());
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + (getDepartureAirportCode() != null ? getDepartureAirportCode().hashCode() : 0);
        result = 31 * result + (getDestinationAirportCode() != null ? getDestinationAirportCode().hashCode() : 0);
        result = 31 * result + (getDepartureDate() != null ? getDepartureDate().hashCode() : 0);
        result = 31 * result + (getArrivalDate() != null ? getArrivalDate().hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "BusyFlightsResponse{" +
                "airline='" + airline + '\'' +
                ", supplier='" + supplier + '\'' +
                ", fare=" + fare +
                ", departureAirportCode='" + departureAirportCode + '\'' +
                ", destinationAirportCode='" + destinationAirportCode + '\'' +
                ", departureDate=" + departureDate +
                ", arrivalDate=" + arrivalDate +
                '}';
    }
}
