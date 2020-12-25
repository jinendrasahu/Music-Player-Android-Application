package com.e.spy;

public class MusicFiles {
    private String album;
    private long albumId;
    private String artist;
    private String duration;
    private long id;
    private String path;
    private String title;

    public MusicFiles() {
    }

    public MusicFiles(String path2, String title2, String artist2, String album2, String duration2, long id2, long albumId2) {
        this.path = path2;
        this.title = title2;
        this.artist = artist2;
        this.album = album2;
        this.duration = duration2;
        this.id = id2;
        this.albumId = albumId2;
    }

    public String getPath() {
        return this.path;
    }

    public void setPath(String path2) {
        this.path = path2;
    }

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

    public String getAlbum() {
        return this.album;
    }

    public void setAlbum(String album2) {
        this.album = album2;
    }

    public String getDuration() {
        return this.duration;
    }

    public void setDuration(String duration2) {
        this.duration = duration2;
    }

    public long getId() {
        return this.id;
    }

    public void setId(long id2) {
        this.id = id2;
    }

    public long getAlbumId() {
        return this.albumId;
    }

    public void setAlbumId(long albumId2) {
        this.albumId = albumId2;
    }
}
