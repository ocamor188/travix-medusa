package com.travix.medusa.service;

import java.util.List;
import com.travix.medusa.model.ToughJetResponse;

public interface ToughJetService {

    ToughJetResponse findByDepartureAirportName(String departureAirportName);

    List<ToughJetResponse> getToughJetFares(String departureAirportName, String arrivalAirportName, int numberOfPassengers);
}
