package be.vansichen.raf.bcc.backend;

import org.springframework.data.jpa.repository.JpaRepository;

public interface RidesRepository extends JpaRepository<Ride, String> {}