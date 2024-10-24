package org.cz.flightservice.services;

import org.cz.flightservice.entities.Flight;
import org.cz.flightservice.entities.dtos.FlightDto;
import org.cz.flightservice.entities.dtos.FlightSaveDto;
import org.cz.flightservice.repositorys.FlightRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FlightService implements IFlightService {

    private final FlightRepository flightRepository;

    public FlightService(FlightRepository flightRepository) {
        this.flightRepository = flightRepository;
    }

    @Override
    public FlightDto getFlightById(Long flightId) {
        return flightToFlightDto(flightRepository.findById(flightId)
                .orElseThrow(() -> new RuntimeException("Flight Not Found")));
    }

    @Override
    public List<FlightDto> getAllFlights() {
        return flightRepository.findAll().stream().map(this::flightToFlightDto).toList();
    }

    @Override
    public FlightDto createFlight(FlightSaveDto flightSaveDto) {
        return flightToFlightDto(flightRepository.save(flightSaveDtoToFlight(flightSaveDto)));
    }

    @Override
    public FlightDto updateFlight(Long flightId, FlightSaveDto flightSaveDto) {
        if (getFlightById(flightId) != null) {
            Flight flightEntity = flightSaveDtoToFlight(flightSaveDto);
            flightEntity.setId(flightId);
            return flightToFlightDto(flightRepository.save(flightEntity));
        }else {
            throw new RuntimeException("Flight Not Found");
        }
    }

    @Override
    public void deleteFlight(Long flightId) {
        if(getFlightById(flightId) != null)
            flightRepository.deleteById(flightId);
    }

    private FlightDto flightToFlightDto(Flight flight) {
        return new FlightDto(
                flight.getId(),
                flight.getFlightNumber(),
                flight.getOrigin(),
                flight.getDestination(),
                flight.getDepartureTime()
        );
    }

    private Flight flightSaveDtoToFlight(FlightSaveDto flightSaveDto) {
        return new Flight(
                null,
                flightSaveDto.flightNumber(),
                flightSaveDto.origin(),
                flightSaveDto.destination(),
                flightSaveDto.departureTime()
        );
    }
}
