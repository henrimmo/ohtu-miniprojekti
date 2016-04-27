package main.repositories;

import java.util.List;
import main.models.Booklet;
import org.springframework.data.jpa.repository.JpaRepository;


public interface BookletRepository extends JpaRepository<Booklet, String>{
    List<Booklet> findByTag(String tag);
}