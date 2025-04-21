package com.example.BiddingSystem.Services;

import com.example.BiddingSystem.DOA.BiddingDAO;
import com.example.BiddingSystem.Model.Products;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SchedulerService {




    @Autowired
    BiddingServices biddingServices;

    // This service will be used to schedule the bidding process
    // You can use Spring's @Scheduled annotation to create scheduled tasks
    // For example, you can schedule a task to check for bids every minute or hour

    // Example of a scheduled task
     @Scheduled(fixedRate = 60000) // Runs every minute
     public void checkBids() {
         // Logic to check for bids and notify users
            System.out.println("Checking for bids...");

        // You can call the bidding service to check for bids and notify users
        // For example, you can send emails to users who have placed bids
         List<Products> listOfProducts = biddingServices.productsAddedMoreThan48HoursAndNotSold();

         for(Products prod : listOfProducts)
         {
             biddingServices.calculateWinner(prod.getProductId());
         }


            // You can also perform other actions based on your requirements

            // For example, you can update the status of products or notify users
         System.out.println("Bids checked and users notified.");

     }
}
