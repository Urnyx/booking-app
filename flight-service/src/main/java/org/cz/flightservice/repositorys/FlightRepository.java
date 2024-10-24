package org.cz.flightservice.repositorys;

import org.cz.flightservice.entities.Flight;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FlightRepository extends JpaRepository<Flight, Long> {
}
