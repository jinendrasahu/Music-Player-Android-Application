package com.e.spy;

public class Track {
    private String artist;
    private int image;
    private String title;

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title2) {
        this.title = title2;
    }

    public String getArtist() {
        return this.artist;
    }

    public void setArtist(String artist2) {
        this.artist = artist2;
    }

    public int getImage() {
        return this.image;
    }

    public void setImage(int image2) {
        this.image = image2;
    }

    public Track(String title2, String artist2, int image2) {
        this.title = title2;
        this.artist = artist2;
        this.image = image2;
    }
}
