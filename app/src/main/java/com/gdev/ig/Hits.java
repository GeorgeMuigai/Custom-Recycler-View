package com.gdev.ig;

public class Hits {
    String userImageURL;
    String user;
    String type;
    String largeImageURL;
    String likes;
    String comments;
    String views;

    public Hits(String userImageURL, String user, String type, String largeImageURL, String likes, String comments, String views) {
        this.userImageURL = userImageURL;
        this.user = user;
        this.type = type;
        this.largeImageURL = largeImageURL;
        this.likes = likes;
        this.comments = comments;
        this.views = views;
    }

    public String getUserImageURL() {
        return userImageURL;
    }

    public String getUser() {
        return user;
    }

    public String getType() {
        return type;
    }

    public String getLargeImageURL() {
        return largeImageURL;
    }

    public String getLikes() {
        return likes;
    }

    public String getComments() {
        return comments;
    }
    public String getViews() {
        return views;
    }
}
