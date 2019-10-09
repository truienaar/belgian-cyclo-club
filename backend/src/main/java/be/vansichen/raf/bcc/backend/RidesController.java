package be.vansichen.raf.bcc.backend;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpStatusCodeException;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import static java.lang.String.format;

@RestController
@RequestMapping("/rides")
public class RidesController {

    private static final Logger LOGGER = LoggerFactory.getLogger(RidesController.class);

    @Autowired
    private RidesRepository ridesRepository;

    @GetMapping
    public List<Ride> getRides() {
        LOGGER.debug("GET Rides");
        return ridesRepository.findAll();
    }

    @GetMapping("/{id}")
    public Ride getRide(@PathVariable("id") String id) {
        LOGGER.debug("GET Ride ({})", id);
        return ridesRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public void postRide(@RequestBody Ride ride) {
        LOGGER.debug("POST Ride ({})", ride);
        ridesRepository.save(ride);
    }

    @PostMapping("/{id}/participants")
    public void postRideParticipant(@PathVariable("id") String rideId, @RequestBody Member member) {
        LOGGER.debug("POST Ride Participant (ride {}, participant {})", rideId, member);
        Ride ride = ridesRepository
                .findById(rideId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, format("Ride %s not found", rideId)));
        ride.getParticipants().add(member);
    }

}
