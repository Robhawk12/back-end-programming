package rjo.spring.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;
import rjo.spring.demo.entities.Division;

import java.util.List;
import java.util.Set;

@CrossOrigin("http://localhost:4200")
@RepositoryRestResource(collectionResourceRel = "divisions", path = "divisions")
public interface DivisionRepository extends JpaRepository<Division,Long> {



}
