package danak.springframework.springdemo.services;

import danak.springframework.springdemo.domain.Product;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.*;

@Service
public class ProductServiceImpl implements ProductService {

    private Map<Integer,Product> products;

    public ProductServiceImpl() {
        loadProducts();
    }

    @Override
    public List<Product> listAllProducts() {

        return new ArrayList<>(products.values());
    }

    @Override
    public void deleteProduct(Integer id) {
        products.remove(id);
    }

    @Override
    public Product getProductById(Integer id) {
        return products.get(id);
    }

    @Override
    public Product saveOrUpdateProduct(Product product) {
        if (product != null){
            if (product.getId() == null){
                product.setId(getNextKey());
            }
            products.put(product.getId(), product);

            return product;
        } else {
            throw new RuntimeException("Product Can't be null");
        }
    }

    private Integer getNextKey(){
        return Collections.max(products.keySet()) + 1;
    }

    public void loadProducts()
    {
        products = new HashMap<>();

        Product product1 = new Product();
        product1.setId(1);
        product1.setDescription("Product 1");
        product1.setPrice(new BigDecimal("11.11"));
        product1.setImageUrl("httt://example.com/product1");

        products.put(1,product1);

        Product product2 = new Product();
        product2.setId(2);
        product2.setDescription("Product 2");
        product2.setPrice(new BigDecimal("22.22"));
        product2.setImageUrl("httt://example.com/product2");

        products.put(2,product2);

    }
}
