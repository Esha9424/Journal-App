package net.engineeringdigest.journalApp.entity;

public class JournalEntry {
    private String id;
    private String tittle;
    private String content;



    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
    public String getTittle() {
        return tittle;
    }

    public void setTittle(String tittle) {
        this.tittle = tittle;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
