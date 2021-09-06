package com.hihasan.music.model;

public class SongModel {
    public long ID;
    public String songTitle;
    public String songArtist;
    public String path;
    public String genre;

    public SongModel(long ID, String songTitle, String songArtist, String path, String genre) {
        this.ID = ID;
        this.songTitle = songTitle;
        this.songArtist = songArtist;
        this.path = path;
        this.genre = genre;
    }

    public SongModel() {
    }

    public long getID() {
        return ID;
    }

    public void setID(long ID) {
        this.ID = ID;
    }

    public String getSongTitle() {
        return songTitle;
    }

    public void setSongTitle(String songTitle) {
        this.songTitle = songTitle;
    }

    public String getSongArtist() {
        return songArtist;
    }

    public void setSongArtist(String songArtist) {
        this.songArtist = songArtist;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }
}
