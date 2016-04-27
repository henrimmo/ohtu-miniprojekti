package main.models;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;
import org.springframework.data.jpa.domain.AbstractPersistable;

@Entity
public class Article implements BibTexEntry, Serializable{
    private String author;
    private String title;
    private String journal;
    private int year;
    @Id
    private String id;
    private String tag;

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
    
    public String getTag(){
        return tag;
    }
    
    public void setTag(String tag){
        this.tag = tag;
    }


    public int getYear() {
        return year;
    }
    
    @Override
    public String toBibTex() {
        return "@ARTICLE{" + id + ",\n"
                + "    author = {" + author + "},\n"
                + "    title = {" + title + "},\n"
                + "    journal = {" + journal + "},\n"
                + "    year = {" + year + "},\n"
                + "}\n";
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
