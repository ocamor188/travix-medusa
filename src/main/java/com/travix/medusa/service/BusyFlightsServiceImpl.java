package com.travix.medusa.service;


import com.travix.medusa.model.BusyFlightsResponse;
import com.travix.medusa.model.CrazyAirResponse;
import com.travix.medusa.model.ToughJetResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

@Service("busyFlightsService")
public class BusyFlightsServiceImpl implements BusyFlightsService{

    @Autowired
    CrazyAirService crazyAirService;

    @Autowired
    ToughJetService toughJetService;

    @Override
    public ResponseEntity<List<BusyFlightsResponse>> getFares(String origin, String destination, int numberOfPassengers) {
        List<CrazyAirResponse> crazyAirFares = crazyAirService.getCrazyAirFares(origin,destination, numberOfPassengers);
        List<ToughJetResponse> toughJetFares = toughJetService.getToughJetFares(origin,destination, numberOfPassengers);
        if (crazyAirFares.isEmpty() && toughJetFares.isEmpty()) {
            return new ResponseEntity(HttpStatus.NO_CONTENT);
            // You many decide to return HttpStatus.NOT_FOUND
        }
        List<BusyFlightsResponse> flightsFares = convertListToBusyFlightsResponseSortedByFare(crazyAirFares, toughJetFares);
        return new ResponseEntity<List<BusyFlightsResponse>>(flightsFares, HttpStatus.OK);
    }

    /**
     * This method get the list of fares by the suppliers
     * */
    @Override
    public List<BusyFlightsResponse> convertListToBusyFlightsResponseSortedByFare(List<CrazyAirResponse> crazyAirFares, List<ToughJetResponse> toughJetFares) {
        List<BusyFlightsResponse> flightsFares = new ArrayList<>();

        for(CrazyAirResponse crazyAirResponse : crazyAirFares){
            BusyFlightsResponse flightFare = new BusyFlightsResponse();
            flightFare.setAirline(crazyAirResponse.getAirline());
            flightFare.setSupplier("CrazyAir");
            flightFare.setFare(crazyAirResponse.getPrice());
            flightFare.setDepartureAirportCode(crazyAirResponse.getDepartureAirportCode());
            flightFare.setDestinationAirportCode(crazyAirResponse.getDestinationAirportCode());
            flightFare.setDepartureDate(crazyAirResponse.getDepartureDate());
            flightFare.setArrivalDate(crazyAirResponse.getArrivalDate());
            flightsFares.add(flightFare);
        }

        for(ToughJetResponse toughJetResponse : toughJetFares){
            BusyFlightsResponse flightFare = new BusyFlightsResponse();
            flightFare.setAirline(toughJetResponse.getCarrier());
            flightFare.setSupplier("ToughJet");
            flightFare.setFare(toughJetResponse.getBasePrice());
            flightFare.setDepartureAirportCode(toughJetResponse.getDepartureAirportName());
            flightFare.setDestinationAirportCode(toughJetResponse.getArrivalAirportName());
            flightFare.setDepartureDate(LocalDateTime.ofInstant(toughJetResponse.getInboundDateTime(), ZoneOffset.UTC));
            flightFare.setArrivalDate(LocalDateTime.ofInstant(toughJetResponse.getOutboundDateTime(), ZoneOffset.UTC));
            flightsFares.add(flightFare);
        }


        flightsFares.sort(new Comparator<BusyFlightsResponse>() {
            @Override
            public int compare(BusyFlightsResponse o1, BusyFlightsResponse o2) {
                return (int) (o2.getFare() - o1.getFare());
            }
        });

        Collections.reverse(flightsFares);
        return flightsFares;

    }
}
