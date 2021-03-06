package main.models;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Manual implements BibTexEntry, Serializable {

    private String title;
    @Id
    private String id;
    private String tag;

    public Manual() {
    }

    public Manual(String id, String title) {
        this.id = id;
        this.title = title;

    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
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
        return "manual";
    }

    @Override
    public Map<String, String> getFields() {
        return new HashMap<String, String>() {
            {
                put("title", title);
            }
        };
    }
}
