package main.repositories;

import java.util.List;
import main.models.Article;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArticleRepository extends JpaRepository<Article, String>{
    List<Article> findByTag(String tag);
}
