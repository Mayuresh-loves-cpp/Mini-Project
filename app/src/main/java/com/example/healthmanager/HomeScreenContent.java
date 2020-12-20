package com.example.healthmanager;

public class HomeScreenContent {
    private String title, content;
    private boolean expandable;

    public HomeScreenContent(String title, String content) {
        this.title = title;
        this.content = content;
        this.expandable = false;
    }

    public boolean isExpandable() {
        return expandable;
    }

    public void setExpandable(boolean expandable) {
        this.expandable = expandable;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "HomeScreenContent{" +
                "title='" + title + '\'' +
                ", content='" + content + '\'' +
                '}';
    }
}
