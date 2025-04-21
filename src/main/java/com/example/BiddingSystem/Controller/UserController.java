package com.example.BiddingSystem.Controller;

import com.example.BiddingSystem.Model.Products;
import com.example.BiddingSystem.Model.User;
import com.example.BiddingSystem.Services.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserServices userServices;

    @PostMapping("/addUser")
    String createUser(@RequestBody User user)
    {
        userServices.createUser(user);
        return "User created";
    }

    @GetMapping("/getUser")
    User getUser(@RequestParam String username)
    {
        return userServices.getUser(username);
        //return "User details for " + username;
    }

    @GetMapping("/getAllPostedProducts")
    List<Products> getAllPostedProducts(@RequestParam String userName)
    {
        // Logic to retrieve all products posted by the user
        return userServices.getAllPostedProducts(userName);
    }



    @GetMapping("/payment")
    String payment(@RequestParam String userName, @RequestParam String productId)
    {
        // Logic to process payment
        // For example, you can call a payment service or perform any necessary operations
        return "Payment successful for user: " + userName + " for product: " + productId;
    }
}
