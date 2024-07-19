package com.twb.ecommerce.restcontrollers;

import com.twb.ecommerce.models.Product;
import com.twb.ecommerce.repositories.ProductRepository;
import com.twb.ecommerce.services.ProductService;
import com.twb.ecommerce.utils.CustomResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/products")
@RequiredArgsConstructor
public class ProductController {
    @Autowired
    private ProductService productService;

    @GetMapping
    public ResponseEntity<CustomResponse<List<Product>>> getAllProducts() {
        List<Product> products = productService.getAllProducts();
        CustomResponse<List<Product>> response = new CustomResponse<>("success", "Products retrieved successfully", products);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public Optional<Product> getProductById(@PathVariable Long id) {
        return productService.getProductById(id);
    }
    @PostMapping
    public Product createProduct(@Valid @RequestBody Product product) {

        return productService.createProduct(product);
    }
    @PutMapping("/{id}")
    public Product updateProduct(@PathVariable Long id,@RequestBody Product productDetails) {
        return productService.updateProduct(id, productDetails);
    }
    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable  Long id) {
        productService.deleteProduct(id);
    }}