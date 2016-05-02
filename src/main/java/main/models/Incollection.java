package main.models;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Incollection implements BibTexEntry, Serializable {

    private String author;
    private String title;
    private String booktitle;
    private String publisher;
    private int year;
    @Id
    private String id;
    private String tag;

    public Incollection() {

    }

    public Incollection(String id, String author, String title, String booktitle, String publisher, int year) {
        this.id = id;
        this.author = author;
        this.title = title;
        this.booktitle = booktitle;
        this.publisher = publisher;
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

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getPublisher() {
        return publisher;
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

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    @Override
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String getType() {
        return "incollection";
    }

    @Override
    public Map<String, String> getFields() {
        return new HashMap<String, String>() {
            {
                put("author", author);
                put("title", title);
                put("booktitle", booktitle);
                put("publisher", publisher);
                put("year", Integer.toString(year));
            }
        };
    }
}
