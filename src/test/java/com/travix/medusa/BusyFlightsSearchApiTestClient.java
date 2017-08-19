package com.travix.medusa;
import com.travix.medusa.model.ToughJetResponse;
import org.springframework.web.client.RestTemplate;

 

public class BusyFlightsSearchApiTestClient {
 
    public static final String REST_SERVICE_URI = "http://localhost:8080/BusyFlights/flight";
    //http://localhost:8080/BusyFlights/flight/search/AMS

     
    /* GET */
    private static void getUser(){
        System.out.println("Testing getFindByDepartureAirportName----------");
        RestTemplate restTemplate = new RestTemplate();
        ToughJetResponse toughJetResponse = restTemplate.getForObject(REST_SERVICE_URI+"/search/AMS", ToughJetResponse.class);
        //TODO: fix the constructor of ToughJetResponse in order to test the functionality.
        System.out.println(toughJetResponse);
    }

 
    public static void main(String args[]) {
        getUser();
    }
}