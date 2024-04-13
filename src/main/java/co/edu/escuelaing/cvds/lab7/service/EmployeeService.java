package co.edu.escuelaing.cvds.lab7.service;

import co.edu.escuelaing.cvds.lab7.model.Session;
import co.edu.escuelaing.cvds.lab7.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {
    private final EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public void createEmployee(Long id, String name,String lastname,String role,String salary){
        Session.Employee employee = new Session.Employee(id, name, lastname, role, salary);
        employeeRepository.save(employee);
    }

    public List<Session.Employee> getAll(){
        return employeeRepository.findAll();
    }

    public void updateEmployee(Long id, String name, String lastname, String role, String salary) {
        Session.Employee employee = employeeRepository.findById(id).orElse(null);
        if (employee != null) {
            employee.setFirstName(!name.isEmpty() ? name : employee.getFirstName());
            employee.setLastName(!lastname.isEmpty() ? lastname : employee.getLastName());
            employee.setRole(!role.isEmpty() ? role : employee.getRole());
            employee.setSalary(!salary.isEmpty() ? salary : employee.getSalary());

            employeeRepository.save(employee);
        }
    }
    public Session.Employee getEmployeeById(Long employeeId) {
        return employeeRepository.findById(employeeId).orElse(null);
    }


    public void deleteEmployee(Long id) {
        employeeRepository.deleteById(id);
    }




}