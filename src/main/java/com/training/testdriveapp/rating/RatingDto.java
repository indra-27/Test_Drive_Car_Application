package com.training.testdriveapp.rating;

import jakarta.validation.constraints.*;

public class RatingDto {
    @NotBlank(message = "Email can't be null")
    @Email(message = "Please provide valid email. e.g name@ford.com",regexp = "[a-z0-9._%+-]+@[a-z0-9.-]+\\.[a-z]{2,3}")
    private String customerEmailId;

    private Integer ratingId;
    @NotBlank(message = "Rating Stars can't be null")
    @Min(value = 0,message = "Minimum will be 0")
    @Max(value = 5,message = "Maximum will be 5")
    private Integer ratingStars;
    @NotBlank(message = "Comments can't be null")
    private String comments;
    @NotBlank(message = "Car ModelName cant be null")
    @Pattern(regexp = "[a-zA-Z0-9 ]{3,16}", message = "Car ModelName should contain min 3 & max 16 chars.")
    private String carModelName;

    public RatingDto(String customerEmailId, Integer ratingId, Integer ratingStars, String comments, String carModelName) {
        this.customerEmailId = customerEmailId;
        this.ratingId = ratingId;
        this.ratingStars = ratingStars;
        this.comments = comments;
        this.carModelName = carModelName;
    }

    public RatingDto() {
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
