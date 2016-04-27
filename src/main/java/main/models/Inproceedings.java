
package main.models;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;
import main.services.BibTexGenerator;

@Entity
public class Inproceedings implements BibTexEntry, Serializable{
    private String author;
    private String title;
    private String booktitle;
    private int year;
    @Id
    private String id;
    private String tag;

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

    
    public String getTag(){
        return tag;
    }
    
    public void setTag(String tag){
        this.tag = tag;
    }
    
    @Override
    public String toBibTex() {
        return "@INPROCEEDINGS{" + BibTexGenerator.escape(id)
                + ", author={" + BibTexGenerator.escape(author) + "}"
                + ", title={" + BibTexGenerator.escape(title) + "}"
                + ", booktitle={" + BibTexGenerator.escape(booktitle) + "}"
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
