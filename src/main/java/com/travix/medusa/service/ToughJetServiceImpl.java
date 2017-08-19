package com.travix.medusa.service;

import com.travix.medusa.model.ToughJetResponse;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service("toughJetService")
public class ToughJetServiceImpl implements ToughJetService{

    private static List<ToughJetResponse> toughJetResponses;

    static{
        toughJetResponses= populatedummyToughJetFares();
    }

    public List<ToughJetResponse> getToughJetFares(String departureAirportName, String arrivalAirportName, int numberOfPassengers){
        List<ToughJetResponse> toughJetResponsesList = new ArrayList<>();
        for(ToughJetResponse toughJetResponse : toughJetResponses){
            if(toughJetResponse.getDepartureAirportName().equalsIgnoreCase(departureAirportName)
                    && toughJetResponse.getArrivalAirportName().equalsIgnoreCase(arrivalAirportName)){
                if(numberOfPassengers>0){
                    double price = toughJetResponse.getBasePrice();
                    toughJetResponse.setBasePrice(price * numberOfPassengers);
                }
                 toughJetResponsesList.add(toughJetResponse);
            }
        }
        return toughJetResponsesList;
    }


    public ToughJetResponse findByDepartureAirportName(String departureAirportName) {
        for(ToughJetResponse toughJetResponse : toughJetResponses){
            if(toughJetResponse.getDepartureAirportName().equalsIgnoreCase(departureAirportName)){
                return toughJetResponse;
            }
        }
        return null;
    }


    private static List<ToughJetResponse> populatedummyToughJetFares(){
        List<ToughJetResponse> toughFares = new ArrayList<>();
        toughFares.add(new ToughJetResponse("KLM",101, 1,10,
                "AMS", "SJO", Instant.now(), Instant.now()));
        toughFares.add(new ToughJetResponse("DELTA",201, 2,20,
                "LHR", "AMS",Instant.now(), Instant.now()));
        toughFares.add(new ToughJetResponse("AVIANCA",301, 3,30,
                "AMS", "CCS",Instant.now(), Instant.now()));
        toughFares.add(new ToughJetResponse("EMIRATES",401, 4,40,
                "CCS", "AMS",Instant.now(), Instant.now()));
        return toughFares;
    }

}
