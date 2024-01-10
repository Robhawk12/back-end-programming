package rjo.spring.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.CrossOrigin;
import rjo.spring.demo.entities.Excursion;

@CrossOrigin
public interface ExcursionRepository extends JpaRepository<Excursion,Long> {
}
