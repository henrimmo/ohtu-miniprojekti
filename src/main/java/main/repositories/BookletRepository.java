package main.repositories;

import main.models.Booklet;
import org.springframework.data.jpa.repository.JpaRepository;


public interface BookletRepository extends JpaRepository<Booklet, String>{
    
}