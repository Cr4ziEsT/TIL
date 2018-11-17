package examples.boot.malljpa.repository;

import examples.boot.malljpa.domain.Event;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EventRepository extends JpaRepository<Event, Long> {
}
