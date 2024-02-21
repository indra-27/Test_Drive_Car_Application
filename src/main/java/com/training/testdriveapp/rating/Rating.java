package com.training.testdriveapp.rating;

import com.training.testdriveapp.customer.Customer;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

@Entity
public class Rating {
    @Id
    @GeneratedValue
    private Integer ratingId;
    private Integer ratingStars;
    private String comments;
    @OneToOne
    private Customer customer;

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Integer getRatingId() {
        return ratingId;
    }

    public void setRatingId(Integer ratingId) {
        this.ratingId = ratingId;
    }

    public Integer getRatingStars() {
        return ratingStars;
    }

    public void setRatingStars(Integer ratingStars) {
        this.ratingStars = ratingStars;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public Rating() {
    }

    public Rating(Integer ratingId, Integer ratingStars, String comments, Customer customer) {
        this.ratingId = ratingId;
        this.ratingStars = ratingStars;
        this.comments = comments;
        this.customer = customer;
    }

    public Rating(Integer ratingStars, String comments) {
        this.ratingStars = ratingStars;
        this.comments = comments;
    }
}
