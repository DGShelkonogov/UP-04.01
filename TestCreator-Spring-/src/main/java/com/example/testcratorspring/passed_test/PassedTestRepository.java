package com.example.testcratorspring.passed_test;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PassedTestRepository extends CrudRepository<PassedTest, Long> {
}
