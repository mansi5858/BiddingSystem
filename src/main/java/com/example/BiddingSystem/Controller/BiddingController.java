package com.example.BiddingSystem.Controller;

import com.example.BiddingSystem.Model.Bid;
import com.example.BiddingSystem.Model.Products;
import com.example.BiddingSystem.Model.User;
import com.example.BiddingSystem.Services.BiddingServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BiddingController {

    @Autowired
    BiddingServices biddingServices;

    @PostMapping("addProduct")
    String addProduct(@RequestBody Products prod)
    {
        biddingServices.addProduct(prod);

        return "Product added successfully";
    }

    @GetMapping("/getAll")
    List<Products> getAllProducts()
    {
        return biddingServices.getAllProducts();
    }

    @GetMapping("/get")
    List<Products> getAllProducts(@RequestParam String type)
    {
        return biddingServices.getProducts(type);
    }

    @GetMapping("/getProductById")
    Products getProductById(@RequestParam String Id)
    {
        return biddingServices.getProductById(Id);
    }

    @PostMapping("addBid")
    String bid(@RequestBody Bid bid)
    {
        biddingServices.addBid(bid);
        return "Bid added successfully";
    }

    @PutMapping("updateBid")
    String updateBid(@RequestBody Bid bid)
    {
        biddingServices.updateBid(bid);
        return "Bid updated successfully";
    }

    @GetMapping("/result")
    String winner(String productId)
    {
        User user = biddingServices.calculateWinner(productId);
        if(user == null)
            return "No buyer for product : " + productId;
        return "Winner for " + productId +" : " + user.getUserName()+" notified successfully";
    }

}
