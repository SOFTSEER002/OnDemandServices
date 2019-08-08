package com.example.ondemandapp.modelclass;

public class Reviewmodel {
    String name,rating,location,date,review;

    public Reviewmodel(String name, String rating, String location, String date, String review) {
      this.setName(name);
      this.setRating(rating);
      this.setLocation(location);
      this.setDate(date);
      this.setReview(review);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getReview() {
        return review;
    }

    public void setReview(String review) {
        this.review = review;
    }
}
