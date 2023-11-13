package com.example.mongodb.exo.mongodbexo.controller;

import com.example.mongodb.exo.mongodbexo.dao.EmployeeRepository;
import com.example.mongodb.exo.mongodbexo.model.Employee;
import jakarta.annotation.Resource;
import org.bson.types.ObjectId;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1")
public class EmployeeController {

    private static final Logger LOGGER = LoggerFactory.getLogger(EmployeeController.class);

    @Resource
    private EmployeeRepository myRepo;

    @GetMapping("/employees")
    public List<Employee> getAllEmployees() {
        return myRepo.findAll();
    }

    @GetMapping("/employees/{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable ObjectId id) {
        Employee e = myRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Employee not found with id {}"));
        LOGGER.info("Employee found : {}", e.getId());
        return ResponseEntity.ok().body(e);
    }

    @GetMapping("/employees/salary/{value}")
    public List<Employee> getSalaryGreaterThan(@PathVariable("value") int salary){
        return myRepo.findBySalaryGreaterThan(salary);
    }

    @PostMapping("/employees")
    public ResponseEntity<Employee> createEmployee(@RequestBody Employee employee) {
        Employee e = myRepo.save(employee);
        LOGGER.info("Employee created : " + e.getId());
        return new ResponseEntity<>(e, HttpStatus.CREATED);
    }

    @PutMapping("/employees")
    public ResponseEntity<Employee> updateEmployee(@RequestBody Employee employee) {
        Employee e = myRepo.save(employee);
        return new ResponseEntity<>(e, HttpStatus.OK);
    }

    @DeleteMapping("/employees/{id}")
    public Map<String, Boolean> deleteEmployee(@PathVariable ObjectId id) {
        Employee e = myRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Employee not found"));
        LOGGER.info("Employee delete by id : {}", id);
        myRepo.deleteById(id);
        Map<String, Boolean> response = new HashMap<>();
        response.put("Enployee has been deleted", Boolean.TRUE);
        return response;
    }




}
