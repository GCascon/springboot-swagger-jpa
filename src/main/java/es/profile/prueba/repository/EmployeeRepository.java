package es.profile.prueba.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
 
import es.profile.prueba.model.Employee;
 
@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Long>{
 
}