package com.eddelacruz.mvvm_example.Models;

public class FBPlayer {

    private String title;
    private String imageUrl;

    public FBPlayer(String imageUrl, String title) {
        this.title = title;
        this.imageUrl = imageUrl;
    }

    public FBPlayer() {
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

}
