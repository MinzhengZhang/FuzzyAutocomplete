package edu.upenn.cit594project.common;

public class SearchResultItem {
    private String text;
    private String link;

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public SearchResultItem() {
    }

    public SearchResultItem(String text, String link) {
        this.text = text;
        this.link = link;
    }
}
