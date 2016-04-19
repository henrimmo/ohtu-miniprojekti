
package main.models;

import javax.persistence.Entity;
import org.springframework.data.jpa.domain.AbstractPersistable;

@Entity
public class Inproceedings extends AbstractPersistable<Long> implements BibTexEntry {
    private String author;
    private String title;
    private String booktitle;
    private int year;

    public Inproceedings(){
        
    }
    
    public Inproceedings(String author, String title, String booktitle, int year){
        this.author = author;
        this.title = title;
        this.booktitle = booktitle;
        this.year = year;
    }
    public void setAuthor(String author) {
        this.author = author;
    }

    public void setBooktitle(String booktitle) {
        this.booktitle = booktitle;
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

    public String getBooktitle() {
        return booktitle;
    }

    public String getTitle() {
        return title;
    }

    public int getYear() {
        return year;
    }

    @Override
    public String toBibTex() {
        return "@INPROCEEDINGS{" + this.author + this.year
                + ", author={" + this.author + "}"
                + ", title={" + this.title + "}"
                + ", booktitle={" + this.booktitle + "}"
                + ", year={" + this.year + "}"
                + ",}";
    }
}
