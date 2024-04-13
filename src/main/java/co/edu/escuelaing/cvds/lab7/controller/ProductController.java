package co.edu.escuelaing.cvds.lab7.controller;

import co.edu.escuelaing.cvds.lab7.model.*;
import co.edu.escuelaing.cvds.lab7.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class ProductController {
    @Autowired
    ProductService productService;

    @GetMapping("api/products")
    @ResponseBody
    public List<Product> productApi(Model model) {
        List<Product> employeeList = productService.getAll();
        //employeeService.createEmployee(id,name);

        model.addAttribute("employeeList", employeeList);
        return employeeList;
    }
    @GetMapping("api/product/{id}")
    @ResponseBody
    public Product productApi(@PathVariable Long id) {
        return productService.getProductById(id);
    }
    @PostMapping("api/product")
    @ResponseBody
    public List<Product> productApi(@RequestBody Product request){
        productService.createEmployee(request.getId(),request.getName(),request.getDescription(),request.getCategory(),
                request.getRating(),request.getPrice(),request.getQuantity());
        return productService.getAll();
    }
    @PutMapping("api/product/{id}")
    @ResponseBody
    public List<Product> productApi(@PathVariable Long id,@RequestBody Product request){
        productService.updateProduct(id,request.getName(),request.getDescription(),request.getCategory(),
                request.getRating(),request.getPrice(),request.getQuantity());
        return productService.getAll();
    }
    @DeleteMapping("/api/product/{id}")
    @ResponseBody
    public List<Product> deleteEmployee(@PathVariable Long id) {
        productService.deleteProduct(id);
        return productService.getAll();
    }
    @PatchMapping("/api/product/{id}")
    @ResponseBody
    public List<Product> patchProduct(@PathVariable Long id,@RequestBody Product request){
        productService.updateProduct(id,request.getName(),request.getDescription(),request.getCategory(),
                request.getRating(),request.getPrice(),request.getQuantity());
        return productService.getAll();
    }
}

