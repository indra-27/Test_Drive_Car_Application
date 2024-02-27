package com.training.testdriveapp.rating;

public class RatingDto {
    private String customerEmailId;
    private Integer ratingId;
    private Integer ratingStars;
    private String comments;
    private String carModelName;

    public RatingDto(String customerEmailId, Integer ratingId, Integer ratingStars, String comments, String carModelName) {
        this.customerEmailId = customerEmailId;
        this.ratingId = ratingId;
        this.ratingStars = ratingStars;
        this.comments = comments;
        this.carModelName = carModelName;
    }

    public String getCustomerEmailId() {
        return customerEmailId;
    }

    public void setCustomerEmailId(String customerEmailId) {
        this.customerEmailId = customerEmailId;
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

    public String getCarModelName() {
        return carModelName;
    }

    public void setCarModelName(String carModelName) {
        this.carModelName = carModelName;
    }
}
