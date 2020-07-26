package com.app.person.dao;

import com.app.person.entity.Person;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonDao extends H2GenericRepository<Person, String> {}
