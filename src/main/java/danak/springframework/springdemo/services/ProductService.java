package danak.springframework.springdemo.services;

import danak.springframework.springdemo.domain.Product;

import java.util.List;

public interface ProductService
{
    List<Product> listAllProducts();

    Product getProductById(Integer id);

    Product saveOrUpdateProduct(Product product);

    void deleteProduct(Integer id);
}
