package com.twb.ecommerce.services;

import com.twb.ecommerce.interfaces.CRUDServiceInterface;
import com.twb.ecommerce.models.Product;
import com.twb.ecommerce.repositories.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@RequiredArgsConstructor
@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    public List<Product> getAllProducts() {
        return productRepository.customQuery();
    }

   public Optional<Product> getProductById(Long id) {
        return productRepository.findById(id);
   }
   public Product createProduct(Product product) {
        return productRepository.save(product);
   }
    public Product updateProduct(Long id, Product productDetails) {
        return productRepository.findById(id).map(product -> {
            product.setName(productDetails.getName());
            product.setPrice(productDetails.getPrice());
            return productRepository.save(product);
        }).orElseGet(() -> {
            productDetails.setId(id);
            return productRepository.save(productDetails);
        });
    }
   public void deleteProduct(Long id) {
        productRepository.deleteById(id);
   }
}
