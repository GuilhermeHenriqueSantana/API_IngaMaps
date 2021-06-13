package com.tourism.tourism.person;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person, Long> {
    Person getByUserLoginId(Long userLogin);
}
