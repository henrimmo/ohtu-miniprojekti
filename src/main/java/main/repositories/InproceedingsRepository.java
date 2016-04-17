
package main.repositories;

import main.models.Inproceedings;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InproceedingsRepository extends JpaRepository<Inproceedings, Long>{
    
}
