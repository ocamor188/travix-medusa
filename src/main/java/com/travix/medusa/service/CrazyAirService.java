package com.travix.medusa.service;


import com.travix.medusa.model.CrazyAirResponse;
import java.util.List;

public interface CrazyAirService {

    CrazyAirResponse findByDepartureAirportCode(String departureAirportCode);

    List<CrazyAirResponse> getCrazyAirFares(String departureAirportCode, String destinationAirportCode ,int numberOfPassengers);
}
