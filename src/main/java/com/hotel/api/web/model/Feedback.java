package com.hotel.api.web.model;

public class Feedback {
    private String email;
    private float rating;
    private String comment;

    public Feedback(String email, int rating, String comment) {
        this.email = email;
        this.rating = rating;
        this.comment = comment;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public float getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}