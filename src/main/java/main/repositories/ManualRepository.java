package main.repositories;

import java.util.List;
import main.models.Manual;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ManualRepository extends JpaRepository<Manual, String>{
    List<Manual> findByTag(String tag);
}