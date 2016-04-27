package main.models;

import java.util.Map;

public interface BibTexEntry {

    public String getId();

    public String getType();

    public Map<String, String> getFields();
}
