package model.diary;

public class Diary {
    private int id;
    private String content;
    private String date;

    public Diary(String content) {
        this.content = content;
    }

    public Diary(int id, String content) {
        this.id = id;
        this.content = content;
    }

    public Diary(int id, String content, String date) {
        this.id = id;
        this.content = content;
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
