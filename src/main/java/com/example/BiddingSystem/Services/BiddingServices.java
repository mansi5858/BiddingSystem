package com.example.BiddingSystem.Services;

import com.example.BiddingSystem.DOA.BiddingDAO;
import com.example.BiddingSystem.DOA.ProductDAO;
import com.example.BiddingSystem.Model.Bid;
import com.example.BiddingSystem.Model.Products;
import com.example.BiddingSystem.Model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BiddingServices {

    // Autowire the DAO
    @Autowired
    ProductDAO productDAO;

    @Autowired
    BiddingDAO biddingDAO;

    @Autowired
    private JavaMailSender mailSender;

    public void addProduct(Products prod)
    {
        productDAO.save(prod);
    }

    public List<Products> getAllProducts()
    {
        return productDAO.getAllProductsByIsSoldFalse();
    }

    public List<Products> getProducts(String type)
    {
        return productDAO.findByIsSoldFalseAndType(type);
    }

    public Products getProductById(String productId)
    {
        return productDAO.findByProductId(productId);
    }

    public void addBid(Bid bid)
    {
        Products product = productDAO.findByProductId(bid.getProductId());
        if (product != null) {
            if (bid.getBiddedPrice() > product.getHighestPrice()) {
                product.setHighestPrice(bid.getBiddedPrice());
                productDAO.save(product);
            }
        }

        biddingDAO.save(bid);
    }


    public void updateBid(Bid updatedBid) {
        // Retrieve the product associated with the bid
        Products product = productDAO.findByProductId(updatedBid.getProductId());
        if (product != null) {
            // Check if the new bid price is higher than the current highest price
            if (updatedBid.getBiddedPrice() > product.getHighestPrice()) {
                product.setHighestPrice(updatedBid.getBiddedPrice());
                productDAO.save(product); // Update the product's highest price
            }
        }
        // Save the updated bid details
        biddingDAO.save(updatedBid);
    }



    public User calculateWinner(String productId) {
        Bid bid = biddingDAO.findProductWithHighestValue(productId);
        if(bid == null) {
            return null; // No bids found
        }
        User winner = bid.getUserName();
        if (winner != null) {
            sendNotification(winner, productId);
        }
        return winner;
    }

    private void sendNotification(User winner, String productId) {
        // Example: Sending an email notification
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(winner.getEmail()); // Assuming User has an `email` field
        message.setSubject("Congratulations! You won the bid");
        message.setText("Dear " + winner.getUserName() + ",\n\n" +
                "You have won the bid for the product with ID: " + productId + ".\n" +
                "Please proceed with the payment and further steps.\n\n" +
                "Thank you,\nBidding System Team");

        mailSender.send(message);
    }

    public List<Products> productsAddedMoreThan48HoursAndNotSold() {
        return productDAO.productsAddedMoreThan48HoursAndNotSold();
    }


}
