package main.services;

import java.util.HashSet;
import java.util.Set;
import main.models.BibTexEntry;

public class BibTexGenerator {
    private final Set<BibTexEntry> entries;
    
    public static String escape(String text) {
        return text.replace("å", "{\\aa}")
                .replace("Å", "{\\AA}")
                .replace("ä", "\\\"{a}")
                .replace("Ä", "\\\"{A}")
                .replace("ö", "\\\"{o}")
                .replace("Ö", "\\\"{O}");
    }

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
