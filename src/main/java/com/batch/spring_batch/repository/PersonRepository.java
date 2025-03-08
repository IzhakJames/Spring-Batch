package com.batch.spring_batch.repository;

import com.batch.spring_batch.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person, Long> {
}
