package com.travix.medusa.controller;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.*;

import com.travix.medusa.model.BusyFlightsResponse;
import com.travix.medusa.model.CrazyAirResponse;
import com.travix.medusa.model.ToughJetResponse;
import com.travix.medusa.service.CrazyAirService;
import com.travix.medusa.service.ToughJetService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.travix.medusa.util.CustomErrorType;

@RestController
@RequestMapping("/flight")
public class BusyFlightsApiController {

	public static final Logger logger = LoggerFactory.getLogger(BusyFlightsApiController.class);

	@Autowired
	CrazyAirService crazyAirService;

	@Autowired
	ToughJetService toughJetService;

	/*TODO: missing departureDate and returnDate to be implemented, but was not describe as required.

	 */
	@RequestMapping(value = "/search/{origin}/{destination}/{numberOfPass}"/*/{departureDate}/{returnDate}/{numberOfPass}"*/, method = RequestMethod.GET)
	public ResponseEntity<List<BusyFlightsResponse>> getFlights(@PathVariable("origin") String origin, @PathVariable("destination") String destination/*,
																@PathVariable("departureDate") Date departureDate, @PathVariable("returnDate") String returnDate,
																*/,@PathVariable("numberOfPass") int numberOfPass) {

		if(numberOfPass>4){
			//in this case the maximum is for 4 we are not going to show any content.
			return new ResponseEntity(HttpStatus.NO_CONTENT);
		}
		List<CrazyAirResponse> crazyAirFares = crazyAirService.getCrazyAirFares(origin,destination, numberOfPass);
		List<ToughJetResponse> toughJetFares = toughJetService.getToughJetFares(origin,destination, numberOfPass);
		if (crazyAirFares.isEmpty() && toughJetFares.isEmpty()) {
			return new ResponseEntity(HttpStatus.NO_CONTENT);
			// You many decide to return HttpStatus.NOT_FOUND
		}
		List<BusyFlightsResponse> flightsFares = convertListToBusyFlightsResponseSortedByFare(crazyAirFares, toughJetFares);
		return new ResponseEntity<List<BusyFlightsResponse>>(flightsFares, HttpStatus.OK);
	}

	public List<BusyFlightsResponse>  convertListToBusyFlightsResponseSortedByFare(List<CrazyAirResponse> crazyAirFares, List<ToughJetResponse> toughJetFares){
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


	@RequestMapping(value = "/search/{departureAirportName}", method = RequestMethod.GET)
	public ResponseEntity<?> getToughJetFareByDepartureAirportName(@PathVariable("departureAirportName") String departureAirportName) {
		logger.info("Fetching fare with departureAirportName {}", departureAirportName);
		ToughJetResponse toughJetFares = toughJetService.findByDepartureAirportName(departureAirportName);
		if (toughJetFares == null) {
			logger.error("Fare with departureAirportName {} not found.", departureAirportName);
			return new ResponseEntity(new CustomErrorType("Fare with departureAirportName " + departureAirportName
					+ " not found"), HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<ToughJetResponse>(toughJetFares, HttpStatus.OK);
	}
}