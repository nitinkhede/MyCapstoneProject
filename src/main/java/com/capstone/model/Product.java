
package com.capstone.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import org.apache.commons.lang.builder.ToStringBuilder;

import java.util.ArrayList;
import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "PogId",
    "Supc",
    "Brand",
    "Description",
    "Size",
    "Category",
    "SubCategory",
    "Price",
    "Quantity",
    "Country",
    "SellerCode",
    "CreationTime",
    "Stock"

})
public class Product {

    @JsonProperty("PogId")
    private String pogId;

    @JsonProperty("Supc")
    private String supc;

    @JsonProperty("Brand")
    private String brand;

    @JsonProperty("Description")
    private String description;

    @JsonProperty("Size")
    private String size;

    @JsonProperty("Category")
    private String category;

    @JsonProperty("SubCategory")
    private String subCategory;

    @JsonProperty("Price")
    private Double price;

    @JsonProperty("Quantity")
    private Integer quantity;

    @JsonProperty("Country")
    private String country;

    @JsonProperty("SellerCode")
    private String sellerCode;

    @JsonProperty("CreationTime")
    private Long creationTime;

    @JsonProperty("Stock")
    private String stock;

    @JsonProperty("PogId")
    public String getPogId() {
        return pogId;
    }

    @JsonProperty("PogId")
    public void setPogId(String pogId) {
        this.pogId = pogId;
    }

    @JsonProperty("Supc")
    public String getSupc() {
        return supc;
    }

    @JsonProperty("Supc")
    public void setSupc(String supc) {
        this.supc = supc;
    }

    @JsonProperty("Brand")
    public String getBrand() {
        return brand;
    }

    @JsonProperty("Brand")
    public void setBrand(String brand) {
        this.brand = brand;
    }


    @JsonProperty("Description")
    public String getDescription() {
        return description;
    }

    @JsonProperty("Description")
    public void setDescription(String description) {
        this.description = description;
    }

    @JsonProperty("Size")
    public String getSize() {
        return size;
    }

    @JsonProperty("Size")
    public void setSize(String size) {
        this.size = size;
    }

    @JsonProperty("Category")
    public String getCategory() {
        return category;
    }

    @JsonProperty("Category")
    public void setCategory(String category) {
        this.category = category;
    }

    @JsonProperty("SubCategory")
    public String getSubCategory() {
        return subCategory;
    }

    @JsonProperty("SubCategory")
    public void setSubCategory(String subCategory) {
        this.subCategory = subCategory;
    }

    @JsonProperty("Price")
    public Double getPrice() {
        return price;
    }

    @JsonProperty("Price")
    public void setPrice(Double price) {
        this.price = price;
    }

    @JsonProperty("Quantity")
    public Integer getQuantity() {
        return quantity;
    }

    @JsonProperty("Quantity")
    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    @JsonProperty("Country")
    public String getCountry() {
        return country;
    }

    @JsonProperty("Country")
    public void setCountry(String country) {
        this.country = country;
    }

    @JsonProperty("SellerCode")
    public String getSellerCode() {
        return sellerCode;
    }

    @JsonProperty("SellerCode")
    public void setSellerCode(String sellerCode) {
        this.sellerCode = sellerCode;
    }

    @JsonProperty("CreationTime")
    public Long getCreationTime() {
        return creationTime;
    }

    @JsonProperty("CreationTime")
    public void setCreationTime(Long creationTime) {
        this.creationTime = creationTime;
    }

    @JsonProperty("Stock")
    public String getStock() {
        return stock;
    }


    @JsonProperty("Stock")
    public void setStock(String stock) {
        this.stock = stock;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("pogId", pogId).append("creationTime", creationTime).append("Price", price).append("Quantity", quantity).append("Stock", stock).toString();
    }

}
