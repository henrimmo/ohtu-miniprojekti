
package main.models;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Inbook implements BibTexEntry, Serializable{
    
    private String author;
    private String title;
    private String chapter;
    private String publisher;
    private int year;
    @Id
    private String id;
    private String tag;
    

    public Inbook(){
    }
    
    public Inbook(String id, String author, String title, String chapter, String publisher, int year){
        this.author = author;
        this.title = title;
        this.chapter = chapter;
        this.publisher = publisher;
        this.year = year;
        this.id = id;
    }

    public void setId(String id) {
        this.id = id;
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
    
    public void setChapter(String chapter) {
        this.chapter = chapter;
    }
    

    public void setYear(int year) {
        this.year = year;
    }
    
    @Override
    public String getId() {
        return id;
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
    
    public String getChapter() {
        return chapter;
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
    public String getType() {
        return "inbook";
    }
    
    @Override
    public Map<String, String> getFields() {
        return new HashMap<String, String>() {{
            put("author", author);
            put("title", title);
            put("chapter", chapter);
            put("publisher", publisher);
            put("year", Integer.toString(year));
        }};
    }
}
