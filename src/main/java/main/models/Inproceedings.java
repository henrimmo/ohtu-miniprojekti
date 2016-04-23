
package main.models;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;
import org.springframework.data.jpa.domain.AbstractPersistable;

@Entity
public class Inproceedings implements BibTexEntry, Serializable {
    private String author;
    private String title;
    private String booktitle;
    private int year;
    @Id
    private String id;

    public Inproceedings(){
        
    }
    
    public Inproceedings(String id, String author, String title, String booktitle, int year){
        this.id = id;
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
        return "@INPROCEEDINGS{" + id
                + ", author={" + author + "}"
                + ", title={" + title + "}"
                + ", booktitle={" + booktitle + "}"
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
