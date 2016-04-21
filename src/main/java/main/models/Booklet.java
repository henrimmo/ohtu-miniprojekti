
package main.models;

import javax.persistence.Entity;
import org.springframework.data.jpa.domain.AbstractPersistable;

@Entity
public class Booklet extends AbstractPersistable<Long> implements BibTexEntry {
    private String cite;
    private String title;

    public Booklet(){
    }
    
    public Booklet(String cite, String title){
        this.cite = cite;
        this.title = title;

    }
    public void setCite(String cite) {
        this.cite = cite;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCite() {
        return cite;
    }

    public String getTitle() {
        return title;
    }

    @Override
    public String toBibTex() {
        return "@BOOKLET{" + this.cite
                + ", title={" + this.title + "}"
                + "}";
    }
}
