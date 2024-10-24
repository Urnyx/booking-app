package org.cz.flightservice.services;

import org.cz.flightservice.entities.dtos.FlightDto;
import org.cz.flightservice.entities.dtos.FlightSaveDto;

import java.util.List;

public interface IFlightService {
    FlightDto getFlightById(Long flightId);
    List<FlightDto> getAllFlights();
    FlightDto createFlight(FlightSaveDto flightSaveDto);
    FlightDto updateFlight(Long flightId, FlightSaveDto flightSaveDto);
    void deleteFlight(Long flightId);
}
