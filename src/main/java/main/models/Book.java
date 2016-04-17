
package main.models;

import javax.persistence.Entity;
import org.springframework.data.jpa.domain.AbstractPersistable;

@Entity
public class Book extends AbstractPersistable<Long> implements BibTexEntry {
    private String author;
    private String title;
    private String publisher;
    private int year;

    public Book(){
    }
    
    public Book(String author, String title, String publisher, int year){
        this.author = author;
        this.title = title;
        this.publisher = publisher;
        this.year = year;
    }
    public void setAuthor(String author) {
        this.author = author;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
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

    public String getPublisher() {
        return publisher;
    }

    public String getTitle() {
        return title;
    }
    
    public int getYear() {
        return year;
    }

    @Override
    public String toBibTex() {
        return "@BOOK{" + this.author + this.year
                + ", author={" + this.author + "}"
                + ", title={" + this.title + "}"
                + ", publisher={" + this.publisher + "}"
                + ", year={" + this.year + "}"
                + ",}";
    }
}
