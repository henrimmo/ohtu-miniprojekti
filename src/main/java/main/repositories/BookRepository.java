
package main.repositories;

import java.util.List;
import main.models.Book;
import org.springframework.data.jpa.repository.JpaRepository;


public interface BookRepository extends JpaRepository<Book, String>{
    List<Book> findByTag(String tag);
}
