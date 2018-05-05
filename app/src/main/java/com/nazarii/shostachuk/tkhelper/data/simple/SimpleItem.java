package com.nazarii.shostachuk.tkhelper.data.simple;

public class SimpleItem {
    private String title;
    private String description;
    private String rightText;

    public SimpleItem(String title, String description, String rightText) {
        this.title = title;
        this.description = description;
        this.rightText = rightText;
    }

    public SimpleItem() {
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getRightText() {
        return rightText;
    }

    public void setRightText(String rightText) {
        this.rightText = rightText;
    }
}
