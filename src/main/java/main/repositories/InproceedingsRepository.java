
package main.repositories;

import java.util.List;
import main.models.Inproceedings;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InproceedingsRepository extends JpaRepository<Inproceedings, String>{
    List<Inproceedings> findByTag(String tag);
}
