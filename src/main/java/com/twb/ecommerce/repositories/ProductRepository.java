package com.twb.ecommerce.repositories;

import com.twb.ecommerce.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product,Long> {
    @Query(value = "SELECT * FROM products Limit 1", nativeQuery = true)
    List<Product> customQuery();
}
