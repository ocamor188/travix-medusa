package com.travix.medusa.service;

import com.travix.medusa.model.CrazyAirResponse;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service("crazyService")
public class CrazyAirServiceImpl implements CrazyAirService{


    private static List<CrazyAirResponse> CrazyAirResponses;

    static{
        CrazyAirResponses= populatedummyCrazyAirFares();
    }

    public List<CrazyAirResponse> getCrazyAirFares(String departureAirportCode,String destinationAirportCode,
                                                   int numberOfPassengers){
        List<CrazyAirResponse> CrazyAirResponsesList = new ArrayList<>();
        for(CrazyAirResponse crazyAirResponse : CrazyAirResponses){
            if(crazyAirResponse.getDepartureAirportCode().equalsIgnoreCase(departureAirportCode)
                    && crazyAirResponse.getDestinationAirportCode().equalsIgnoreCase(destinationAirportCode)){
                if(numberOfPassengers>0){
                    double price = crazyAirResponse.getPrice();
                    crazyAirResponse.setPrice(price * numberOfPassengers);
                }
                CrazyAirResponsesList.add(crazyAirResponse);
            }
        }
        return CrazyAirResponsesList;
    }


    public CrazyAirResponse findByDepartureAirportCode(String departureAirportCode) {
        for(CrazyAirResponse CrazyAirResponse : CrazyAirResponses){
            if(CrazyAirResponse.getDepartureAirportCode().equalsIgnoreCase(departureAirportCode)){
                return CrazyAirResponse;
            }
        }
        return null;
    }


    private static List<CrazyAirResponse> populatedummyCrazyAirFares(){
        List<CrazyAirResponse> toughFares = new ArrayList<>();
        toughFares.add(new CrazyAirResponse("AMERICAN",100, "E",
                "AMS", "CCS", LocalDateTime.now(), LocalDateTime.now()));
        toughFares.add(new CrazyAirResponse("DELTA",200,"B",
                "LHR", "AMS",LocalDateTime.now(), LocalDateTime.now()));
        toughFares.add(new CrazyAirResponse("AVIANCA",300, "E",
                "AMS", "SJO",LocalDateTime.now(), LocalDateTime.now()));
        toughFares.add(new CrazyAirResponse("LocalDateTime",400, "B",
                "SJO", "AMS",LocalDateTime.now(), LocalDateTime.now()));
        return toughFares;
    }

}
