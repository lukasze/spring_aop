package workshop.springb.starter.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import workshop.springb.starter.model.Response;

public interface ResponseRepository extends JpaRepository<Response, Long> {
}