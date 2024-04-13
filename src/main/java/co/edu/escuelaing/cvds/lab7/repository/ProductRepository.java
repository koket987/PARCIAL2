package co.edu.escuelaing.cvds.lab7.repository;
import co.edu.escuelaing.cvds.lab7.model.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
