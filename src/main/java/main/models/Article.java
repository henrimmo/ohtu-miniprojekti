package main.models;

import javax.persistence.Entity;
import org.springframework.data.jpa.domain.AbstractPersistable;

@Entity
public class Article extends AbstractPersistable<Long>{
    private String author;
    private String title;
    private String journal;
    private int year;
    private int volume;

    public Article(){
    }
    
    public Article(String author, String title, String journal, int year, int volume){
        this.author = author;
        this.title = title;
        this.journal = journal;
        this.year = year;
        this.volume = volume;
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

    public void setVolume(int volume) {
        this.volume = volume;
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

    public int getVolume() {
        return volume;
    }

    public int getYear() {
        return year;
    }
}
