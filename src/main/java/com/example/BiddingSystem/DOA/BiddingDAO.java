package com.example.BiddingSystem.DOA;


import com.example.BiddingSystem.Model.Bid;
import com.example.BiddingSystem.Model.Products;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BiddingDAO extends JpaRepository<Bid, String> {

    Bid findByBidId(String bidId);

    List<Bid> findByProductId(String productId);

    @Query("Select * from Bid where productId = ?1 orderBy biddedPrice desc Limit 1")
    Bid findProductWithHighestValue(String productId);



}
