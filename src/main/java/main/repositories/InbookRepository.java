
package main.repositories;

import main.models.Inbook;
import org.springframework.data.jpa.repository.JpaRepository;


public interface InbookRepository extends JpaRepository<Inbook, String>{
    
}
