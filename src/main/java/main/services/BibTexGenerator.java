package main.services;

import java.util.HashSet;
import java.util.Map;
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

    public static String generateEntry(BibTexEntry bibTexEntry) {
        StringBuilder sb = new StringBuilder();
        sb.append("@").append(bibTexEntry.getType())
                .append("{").append(bibTexEntry.getId());
        for (Map.Entry<String, String> entry : bibTexEntry.getFields().entrySet()) {
            sb.append(",\n ").append(entry.getKey()).append(" = {")
                    .append(escape(entry.getValue())).append("}");
        }
        return sb.append("\n}").toString();
    }

    public String generate() {
        StringBuilder sb = new StringBuilder();
        for (BibTexEntry entry : entries) {
            sb.append(generateEntry(entry)).append("\n");
        }
        return sb.toString();
    }

}
