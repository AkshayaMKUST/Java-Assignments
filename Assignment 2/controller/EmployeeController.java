package com.employee.Employee.controller;

import com.employee.Employee.entity.Employee;
import com.employee.Employee.exception.EmployeeAlreadyExists;
import com.employee.Employee.exception.EmployeeNotFound;
import com.employee.Employee.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping
public class EmployeeController {

    @Autowired
    EmployeeRepository employeeRepository;

    @PostMapping()
    public ResponseEntity<Employee> createEmployee(@RequestBody Employee employee) throws EmployeeAlreadyExists {
        Optional<Employee> op = employeeRepository.findById(employee.getEmployeeId());
        if(op.isEmpty()){
        return ResponseEntity.status(HttpStatus.CREATED).body(employeeRepository.save(employee));
        }
        throw new EmployeeAlreadyExists("Employee already exists with the given id");
    }

    @GetMapping
    public ResponseEntity<List<Employee>> fetchEmployees(){
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(employeeRepository.findAll());
    }

    @GetMapping("{employeeId}")
    public ResponseEntity<Employee> fetchEmployeeById(@PathVariable Integer employeeId) throws EmployeeNotFound {
        Optional<Employee> op = employeeRepository.findById(employeeId);
        if(op.isEmpty()){
            throw new EmployeeNotFound("Employee with the given id does not exist");
        }
        return ResponseEntity.ok(op.get());
    }

    @PutMapping()
    public ResponseEntity<?> updateEmployee(@RequestBody Employee employee) {
        try {
            Optional<Employee> op = employeeRepository.findById(employee.getEmployeeId());
            if (op.isPresent()) {
                Employee temp = op.get();
                temp.setEmployeeName(employee.getEmployeeName());
                temp.setEmployeeDepartment(employee.getEmployeeDepartment());
                temp.setEmployeeSalary(employee.getEmployeeSalary());
                employeeRepository.save(temp);
                return ResponseEntity.status(HttpStatus.ACCEPTED).body(temp);
            } else {
                throw new EmployeeNotFound("Employee with the given id does not exist");
            }
        } catch (EmployeeNotFound ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
        }
    }


    @DeleteMapping("{employeeId}")
    public String deleteEmployee(@PathVariable Integer employeeId){
        employeeRepository.deleteById(employeeId);
        return "Employee deleted successfully";
    }

}
