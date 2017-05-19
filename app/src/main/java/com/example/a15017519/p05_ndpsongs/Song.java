package com.example.a15017519.p05_ndpsongs;

/**
 * Created by 15017519 on 19/5/2017.
 */

public class Song {
    private int id;
    private String title;
    private String singer;
    private int year;
    private int stars;

    public Song(int id, String title, String singers, int year, int stars) {
        this.id = id;
        this.title = title;
        this.singer = singers;
        this.year = year;
        this.stars = stars;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getSinger() {
        return singer;
    }

    public int getYear() {
        return year;
    }

    public int getStars() {
        return stars;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public void setSinger(String singer) {
        this.singer = singer;
    }
    public void setYear(int year) {
        this.year = year;
    }
    public void setStars(int stars) {
        this.stars = stars;
    }
}
