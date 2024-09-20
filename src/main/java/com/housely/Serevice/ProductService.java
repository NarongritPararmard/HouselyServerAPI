package com.housely.Serevice;

import com.housely.Model.Product.Product;
import com.housely.Repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> findAll() {
        return productRepository.findAll();
    }

    public Product save(Product product) {
        return productRepository.save(product);
    }

    public Product findById(String id) {
        return productRepository.findById(id).orElse(null);
    }

    public void deleteById(String id) {
        productRepository.deleteById(id);
    }

}
