package com.example.testcratorspring.group_test;

import com.example.testcratorspring.test.Test;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GroupTestRepository extends CrudRepository<GroupTest, Long> {
    List<GroupTest> findByTest(Test test);
}
