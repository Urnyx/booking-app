package org.cz.flightservice;

import org.cz.flightservice.entities.dtos.FlightDto;
import org.cz.flightservice.entities.dtos.FlightSaveDto;
import org.cz.flightservice.services.IFlightService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/flights")
public class FlightController {


    private final IFlightService flightService;

    public FlightController(IFlightService flightService) {
        this.flightService = flightService;
    }

    @GetMapping
    public ResponseEntity<List<FlightDto>> getAllFlights() {
        List<FlightDto> flights = flightService.getAllFlights();
        return ResponseEntity.ok(flights);
    }

    @GetMapping("/{id}")
    public ResponseEntity<FlightDto> getFlightById(@PathVariable("id") Long id) {
        FlightDto flight = flightService.getFlightById(id);
        return ResponseEntity.ok(flight);
    }

    @PostMapping
    public ResponseEntity<FlightDto> createFlight(@RequestBody FlightSaveDto flight) {
        FlightDto newFlight = flightService.createFlight(flight);
        return ResponseEntity.ok(newFlight);
    }

    @PutMapping("/{id}")
    public ResponseEntity<FlightDto> updateFlight(@PathVariable("id") Long id, @RequestBody FlightSaveDto flight) {
        FlightDto updatedFlight = flightService.updateFlight(id, flight);
        return ResponseEntity.ok(updatedFlight);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteFlight(@PathVariable("id") Long id) {
        flightService.deleteFlight(id);
        return ResponseEntity.noContent().build();
    }
}
