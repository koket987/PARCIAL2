package co.edu.escuelaing.cvds.lab7.service;
import co.edu.escuelaing.cvds.lab7.model.*;
import co.edu.escuelaing.cvds.lab7.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    private final ProductRepository productRepository;
    @Autowired
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public void createEmployee(Long id , String name, String description, Category category, Integer rating, int price, int quantity){
        Product product = new Product(id, name, description, category, rating,price,quantity);
        productRepository.save(product);
    }
    public void updateProduct(Long id , String name, String description, Category category, Integer rating, int price, int quantity) {
        Product product = productRepository.findById(id).orElse(null);
        if (product != null) {
            product.setName(!name.isEmpty() ? name : product.getName());
            product.setDescription(!description.isEmpty() ? description : product.getDescription());
            if(category == null){
                product.setCategory(product.getCategory());
            }else{
                product.setCategory(category);}
            product.setRating(rating!=null ? rating :product.getRating());
            product.setPrice(price > 0 ? price : product.getPrice());
            product.setQuantity(quantity > 0 ? quantity : product.getQuantity());
            productRepository.save(product);
        }
    }
    public Product getProductById(Long id) {
        return productRepository.findById(id).orElse(null);
    }
    public List<Product> getAll(){
        return productRepository.findAll();
    }
    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }



}
