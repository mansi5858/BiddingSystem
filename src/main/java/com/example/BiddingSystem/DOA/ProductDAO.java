package com.example.BiddingSystem.DOA;

import com.example.BiddingSystem.Model.Products;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface ProductDAO extends JpaRepository<Products, String> {

    Products findByProductId(String productId);

    Products findByProductName(String productName);

    List<Products> findByType(String type);

    List<Products> findByPostedDate(String postedDate);

    List<Products> findByIsSoldAndPostedDate(boolean isSold, LocalDate date);

    List<Products> getAllProductsByIsSoldFalse();

    List<Products> getAllProductsByIsSoldTrue();

    List<Products> findByIsSoldFalseAndType(String type);

    @Query("Select * from Products where postedDate < (current_date - 2) and isSold = false")
    List<Products> productsAddedMoreThan48HoursAndNotSold();

}
