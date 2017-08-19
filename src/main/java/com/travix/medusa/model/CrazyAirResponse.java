package com.travix.medusa.model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;


public class CrazyAirResponse {

    private String airline;

    private double price;

    private String cabinClass;

    private String departureAirportCode;

    private String destinationAirportCode;

    private LocalDateTime departureDate;

    private LocalDateTime arrivalDate;

    public CrazyAirResponse(String airline, double price, String cabinClass, String departureAirportCode,
                            String destinationAirportCode, LocalDateTime departureDate, LocalDateTime arrivalDate) {
        this.airline = airline;
        this.price = price;
        this.cabinClass = cabinClass;
        this.departureAirportCode = departureAirportCode;
        this.destinationAirportCode = destinationAirportCode;
        this.departureDate = departureDate;
        this.arrivalDate = arrivalDate;
    }

    public String getAirline() {
        return airline;
    }

    public void setAirline(String airline) {
        this.airline = airline;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getCabinClass() {
        return cabinClass;
    }

    public void setCabinClass(String cabinClass) {
        this.cabinClass = cabinClass;
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
        if (!(o instanceof CrazyAirResponse)) return false;

        CrazyAirResponse that = (CrazyAirResponse) o;

        if (Double.compare(that.getPrice(), getPrice()) != 0) return false;
        if (getAirline() != null ? !getAirline().equals(that.getAirline()) : that.getAirline() != null) return false;
        if (getCabinClass() != null ? !getCabinClass().equals(that.getCabinClass()) : that.getCabinClass() != null)
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
        temp = Double.doubleToLongBits(getPrice());
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + (getCabinClass() != null ? getCabinClass().hashCode() : 0);
        result = 31 * result + (getDepartureAirportCode() != null ? getDepartureAirportCode().hashCode() : 0);
        result = 31 * result + (getDestinationAirportCode() != null ? getDestinationAirportCode().hashCode() : 0);
        result = 31 * result + (getDepartureDate() != null ? getDepartureDate().hashCode() : 0);
        result = 31 * result + (getArrivalDate() != null ? getArrivalDate().hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "CrazyAirResponse{" +
                "airline='" + airline + '\'' +
                ", price=" + price +
                ", cabinClass='" + cabinClass + '\'' +
                ", departureAirportCode='" + departureAirportCode + '\'' +
                ", destinationAirportCode='" + destinationAirportCode + '\'' +
                ", departureDate=" + departureDate +
                ", arrivalDate=" + arrivalDate +
                '}';
    }
}
