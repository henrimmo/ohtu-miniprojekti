
package main.repositories;

import java.util.List;
import main.models.Inbook;
import org.springframework.data.jpa.repository.JpaRepository;


public interface InbookRepository extends JpaRepository<Inbook, String>{
    List<Inbook> findByTag(String tag);
}
