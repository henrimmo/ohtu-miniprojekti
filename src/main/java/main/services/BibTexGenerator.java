package main.services;

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
            sb.append(convert(entry.toBibTex())).append("\n");
        }
        return sb.toString();
    }

    public String convert(String str) {
        str = str.replace("ä", "\\\"{a}");
        str = str.replace("Ä", "\\\"{A}");
        str = str.replace("ö", "\\\"{o}");
        str = str.replace("Ö", "\\\"{O}");
        str = str.replace("å", "\\aa");
        str = str.replace("Å", "\\AA");

        return str;
    }
}
