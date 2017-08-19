package com.travix.medusa.service;


import com.travix.medusa.model.BusyFlightsResponse;
import com.travix.medusa.model.CrazyAirResponse;
import com.travix.medusa.model.ToughJetResponse;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface BusyFlightsService {

    ResponseEntity<List<BusyFlightsResponse>> getFares(String origin, String destination, int numberOfPassengers);

    List<BusyFlightsResponse> convertListToBusyFlightsResponseSortedByFare(List<CrazyAirResponse> crazyAirFares, List<ToughJetResponse> toughJetFares);

}
