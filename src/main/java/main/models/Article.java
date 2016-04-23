package main.models;

import javax.persistence.Entity;
import javax.persistence.Id;
import org.springframework.data.jpa.domain.AbstractPersistable;

@Entity
public class Article implements BibTexEntry {
    private String author;
    private String title;
    private String journal;
    private int year;
    @Id
    private String id;

    public Article(){
    }
    
    public Article(String id, String author, String title, String journal, int year){
        this.id = id;
        this.author = author;
        this.title = title;
        this.journal = journal;
        this.year = year;
    }
    public void setAuthor(String author) {
        this.author = author;
    }

    public void setJournal(String journal) {
        this.journal = journal;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getAuthor() {
        return author;
    }

    public String getJournal() {
        return journal;
    }

    public String getTitle() {
        return title;
    }


    public int getYear() {
        return year;
    }
    
    @Override
    public String toBibTex() {
        return "@ARTICLE{" + id
                + ", author={" + author + "}"
                + ", title={" + title + "}"
                + ", journal={" + journal + "}"
                + ", year={" + year + "}"
                + ",}";
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
