package com.example.mongodb.exo.mongodbexo.dao;

import com.example.mongodb.exo.mongodbexo.model.Employee;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends MongoRepository<Employee, ObjectId> {

    @Query("{'salary':{$gt:?0}}")
    public List<Employee> findBySalaryGreaterThan(int salary);
}
