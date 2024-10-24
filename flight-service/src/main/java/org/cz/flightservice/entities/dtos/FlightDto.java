package org.cz.flightservice.entities.dtos;

public record FlightDto(Long id, String flightNumber, String origin, String destination, String departureTime){
}
