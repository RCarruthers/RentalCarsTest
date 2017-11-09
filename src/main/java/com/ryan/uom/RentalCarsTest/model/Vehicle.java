
package com.ryan.uom.RentalCarsTest.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "sipp",
        "name",
        "price",
        "supplier",
        "rating"
})
public class Vehicle implements Comparable<Vehicle> {

    @JsonProperty("sipp")
    private String sipp;
    @JsonProperty("name")
    private String name;
    @JsonProperty("price")
    private Double price;
    @JsonProperty("supplier")
    private String supplier;
    @JsonProperty("rating")
    private Double rating;
    private int score;

    @JsonProperty("sipp")
    public String getSipp() {
        return sipp;
    }

    @JsonProperty("sipp")
    public void setSipp(String sipp) {
        this.sipp = sipp;
    }

    @JsonProperty("name")
    public String getName() {
        return name;
    }

    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    @JsonProperty("price")
    public Double getPrice() {
        return price;
    }

    @JsonProperty("price")
    public void setPrice(Double price) {
        this.price = price;
    }

    @JsonProperty("supplier")
    public String getSupplier() {
        return supplier;
    }

    @JsonProperty("supplier")
    public void setSupplier(String supplier) {
        this.supplier = supplier;
    }

    @JsonProperty("rating")
    public Double getRating() {
        return rating;
    }

    @JsonProperty("rating")
    public void setRating(Double rating) {
        this.rating = rating;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    @Override
    public int compareTo(Vehicle o) {
        // usually toString should not be used,
        // instead one of the attributes or more in a comparator chain
        return price.compareTo(o.getPrice());
    }
}
