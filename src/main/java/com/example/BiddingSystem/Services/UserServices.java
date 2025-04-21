package com.example.BiddingSystem.Services;

import com.example.BiddingSystem.DOA.UserDAO;
import com.example.BiddingSystem.Model.Products;
import com.example.BiddingSystem.Model.User;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class UserServices {

    // Add methods to handle user-related operations
    // For example, createUser, getUser, updateUser, etc.
    // These methods will interact with the User repository to perform CRUD operations
    @Autowired
    UserDAO userDao;

    // Example method to create a new user
    public void createUser(User user) {
        // Logic to save the user to the database
        userDao.save(user);
    }

    // Example method to get a user by username
    public User getUser(String username) {
        // Logic to retrieve the user from the database
        return userDao.findByUserName(username); // Replace with actual implementation
    }

    public List<Products> getAllPostedProducts(String userName) {
        // Logic to retrieve all products posted by the user
        return userDao.getAllPostedProducts(userName); // Replace with actual implementation
    }

    public List<Products> getAllBids(String userName) {
        // Logic to retrieve all products posted by the user
        return userDao.getAllBids(userName); // Replace with actual implementation
    }
}
