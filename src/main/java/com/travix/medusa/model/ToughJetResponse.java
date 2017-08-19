package com.travix.medusa.model;

import java.time.Instant;
import java.util.Date;

public class ToughJetResponse {

    private String carrier;

    private double basePrice;

    private double tax;

    private double discount;

    private String departureAirportName;

    private String arrivalAirportName;

    private Instant outboundDateTime;

    private Instant inboundDateTime;

    public ToughJetResponse() {
    }

    public ToughJetResponse(String carrier, double basePrice, double tax, double discount,
                            String departureAirportName, String arrivalAirportName, Instant outboundDateTime, Instant inboundDateTime) {
        this.carrier = carrier;
        this.basePrice = basePrice;
        this.tax = tax;
        this.discount = discount;
        this.departureAirportName = departureAirportName;
        this.arrivalAirportName = arrivalAirportName;
        this.outboundDateTime = outboundDateTime;
        this.inboundDateTime = inboundDateTime;
    }

    public String getCarrier() {
        return carrier;
    }

    public void setCarrier(String carrier) {
        this.carrier = carrier;
    }

    public double getBasePrice() {
        return basePrice;
    }

    public void setBasePrice(double basePrice) {
        this.basePrice = basePrice;
    }

    public double getTax() {
        return tax;
    }

    public void setTax(double tax) {
        this.tax = tax;
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    public String getDepartureAirportName() {
        return departureAirportName;
    }

    public void setDepartureAirportName(String departureAirportName) {
        this.departureAirportName = departureAirportName;
    }

    public String getArrivalAirportName() {
        return arrivalAirportName;
    }

    public void setArrivalAirportName(String arrivalAirportName) {
        this.arrivalAirportName = arrivalAirportName;
    }

    public Instant getOutboundDateTime() {
        return outboundDateTime;
    }

    public void setOutboundDateTime(Instant outboundDateTime) {
        this.outboundDateTime = outboundDateTime;
    }

    public Instant getInboundDateTime() {
        return inboundDateTime;
    }

    public void setInboundDateTime(Instant inboundDateTime) {
        this.inboundDateTime = inboundDateTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ToughJetResponse)) return false;

        ToughJetResponse that = (ToughJetResponse) o;

        if (Double.compare(that.getBasePrice(), getBasePrice()) != 0) return false;
        if (Double.compare(that.getTax(), getTax()) != 0) return false;
        if (Double.compare(that.getDiscount(), getDiscount()) != 0) return false;
        if (getCarrier() != null ? !getCarrier().equals(that.getCarrier()) : that.getCarrier() != null) return false;
        if (getDepartureAirportName() != null ? !getDepartureAirportName().equals(that.getDepartureAirportName()) : that.getDepartureAirportName() != null)
            return false;
        if (getArrivalAirportName() != null ? !getArrivalAirportName().equals(that.getArrivalAirportName()) : that.getArrivalAirportName() != null)
            return false;
        if (getOutboundDateTime() != null ? !getOutboundDateTime().equals(that.getOutboundDateTime()) : that.getOutboundDateTime() != null)
            return false;
        return getInboundDateTime() != null ? getInboundDateTime().equals(that.getInboundDateTime()) : that.getInboundDateTime() == null;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = getCarrier() != null ? getCarrier().hashCode() : 0;
        temp = Double.doubleToLongBits(getBasePrice());
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(getTax());
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(getDiscount());
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + (getDepartureAirportName() != null ? getDepartureAirportName().hashCode() : 0);
        result = 31 * result + (getArrivalAirportName() != null ? getArrivalAirportName().hashCode() : 0);
        result = 31 * result + (getOutboundDateTime() != null ? getOutboundDateTime().hashCode() : 0);
        result = 31 * result + (getInboundDateTime() != null ? getInboundDateTime().hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "ToughJetResponse{" +
                "carrier='" + carrier + '\'' +
                ", basePrice=" + basePrice +
                ", tax=" + tax +
                ", discount=" + discount +
                ", departureAirportName='" + departureAirportName + '\'' +
                ", arrivalAirportName='" + arrivalAirportName + '\'' +
                ", outboundDateTime=" + outboundDateTime +
                ", inboundDateTime=" + inboundDateTime +
                '}';
    }
}
