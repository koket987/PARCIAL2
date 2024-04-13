package co.edu.escuelaing.cvds.lab7.model;
import jakarta.persistence.*;
import org.hibernate.annotations.Type;


@Entity
@Table(name = "PRODUCT")
public class Product {
    @Id
    @Column(name = "id")
    private Long id;
    @Column(name ="name")
    private String name;
    @Column(name = "description")
    private String description;
    @Column(name = "category")
    private Category category;
    @Column(name = "rating",columnDefinition = "SMALLINT")
    private Integer rating;
    @Column(name ="price")
    private int price;
    @Column(name="quantity")
    private int quantity;

    public Product(Long id , String name, String description, Category category, Integer rating, int price, int quantity ) {
        this.id = id;
        this.name = name;
        this.category=category;
        this.description = description;
        this.rating = rating;
        this.price = price;
        this.quantity = quantity;
    }

    public Product() {
    }

    public void setId(Long id){
        this.id = id;
    }
    public void setName(String name){
        this.name = name;
    }
    public void setDescription(String description){
        this.description = description;
    }

    public void setRating(Integer rating){
        this.rating = rating;
    }
    public void setPrice(int price){
        this.price = price;
    }
    public void setCategory(Category category){this.category=category;}

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    public Long getId(){
        return id;
    }
    public String getName(){
        return name;
    }
    public String getDescription(){
        return description;
    }
    public Category getCategory() {
        return category;
    }
    public Integer getRating(){
        return rating;
    }
    public int getPrice(){
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

}

