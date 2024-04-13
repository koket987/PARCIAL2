package co.edu.escuelaing.cvds.lab7.repository;




import co.edu.escuelaing.cvds.lab7.model.Session;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Session.Employee, Long> {
    //public List<Employee> findByPropiedad(String propiedad);

}
