package com.app.person.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

import java.io.Serializable;
import java.util.List;

@NoRepositoryBean
interface H2GenericRepository<T, ID extends Serializable> extends JpaRepository<T, ID> {
    //Override Iterable to List
    List<T> findAll();
}
