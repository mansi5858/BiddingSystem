package com.example.BiddingSystem.DOA;

import com.example.BiddingSystem.Model.Products;
import com.example.BiddingSystem.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
//import org.springframework.data.repository.Repository;

import java.util.List;

@Repository

public interface UserDAO extends JpaRepository<User, String> {

    User findByUserName(String userName);

    @Query("Select * from products p where userName = ?1 order by datePosted desc")
    List<Products> getAllPostedProducts(String userName);

    @Query("SELECT p FROM Products p join Bid b on p.productId = b.productId WHERE b.userId = ?1")
    List<Products> getAllBids(String userId);


}
