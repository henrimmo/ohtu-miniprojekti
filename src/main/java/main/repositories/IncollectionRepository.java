
package main.repositories;

import java.util.List;
import main.models.Incollection;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IncollectionRepository extends JpaRepository<Incollection, String>{
    List<Incollection> findByTag(String tag);
}
