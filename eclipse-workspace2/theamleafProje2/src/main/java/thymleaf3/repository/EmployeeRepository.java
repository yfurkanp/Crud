package thymleaf3.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import thymleaf3.model.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

}
