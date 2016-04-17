package main;

import java.util.HashSet;
import java.util.Set;
import main.models.BibTexEntry;

public class BibTexGenerator {
    private final Set<BibTexEntry> entries;

    public BibTexGenerator() {
        entries = new HashSet<BibTexEntry>();
    }
    
    public void addEntry(BibTexEntry entry) {
        entries.add(entry);
    }
    
    public String generate() {
        StringBuilder sb = new StringBuilder();
        for (BibTexEntry entry : entries) {
            sb.append(entry.toBibTex()).append("\n");
        }
        return sb.toString();
    }
    
}
