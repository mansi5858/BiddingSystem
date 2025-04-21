package com.example.BiddingSystem.Model;

import java.time.LocalDate;

public class Bid {

    String productId;
    User userName;
    String comments;
    long biddedPrice;
    LocalDate biddedDate;

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public User getUserName() {
        return userName;
    }

    public void setUserName(User userName) {
        this.userName = userName;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public long getBiddedPrice() {
        return biddedPrice;
    }

    public void setBiddedPrice(long biddedPrice) {
        this.biddedPrice = biddedPrice;
    }

    public LocalDate getBiddedDate() {
        return biddedDate;
    }

    public void setBiddedDate(LocalDate biddedDate) {
        this.biddedDate = biddedDate;
    }
}
