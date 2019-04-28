package com.example.ggfl.listsearch;

public class RecyclerListItem {
    private String title;
    private int id;
    private String content;

    public RecyclerListItem(String title, int id, String content){
        this.title = title;
        this.id = id;
        this.content = content;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
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
}
