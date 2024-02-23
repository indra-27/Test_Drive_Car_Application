package com.training.testdriveapp.rating;

import com.training.testdriveapp.admin.Car;
import com.training.testdriveapp.customer.Customer;
import jakarta.persistence.*;

@Entity
public class Rating {
    @Id
    @GeneratedValue
    private Integer ratingId;
    private Integer ratingStars;
    private String comments;
    @OneToOne
    private Customer customer;
    @ManyToOne
    private Car car;

    public Rating(Integer ratingId, Integer ratingStars, String comments, Customer customer, Car car) {
        this.ratingId = ratingId;
        this.ratingStars = ratingStars;
        this.comments = comments;
        this.customer = customer;
        this.car = car;
    }

    public Rating() {

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

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }
}
