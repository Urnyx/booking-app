package org.cz.flightservice.entities.dtos;

public record FlightSaveDto(String flightNumber, String origin, String destination, String departureTime) {
}
