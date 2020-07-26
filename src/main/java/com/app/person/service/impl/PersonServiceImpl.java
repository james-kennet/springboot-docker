package com.app.person.service.impl;

import com.app.person.dao.PersonDao;
import com.app.person.constants.enums.PersonColumns;
import com.app.person.dto.exception.ServiceException;
import com.app.person.dto.request.PersonRequest;
import com.app.person.entity.Person;
import com.app.person.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PersonServiceImpl implements PersonService {

    @Autowired
    private PersonDao personDao;

    private List<String> columns = new ArrayList<>();

    @PostConstruct
    private void postConstruct(){
        columns.addAll(Arrays.asList(PersonColumns.values()).stream().map(col -> col.toString()).collect(Collectors.toList()));
    }

    public List<Person> getAllPersons(){
        return personDao.findAll();
    }

    public List<Person> getAllPersonsSorted(PersonRequest personRequest) throws ServiceException {
        return personDao.findAll(Sort.by(personRequest.getColumn().toLowerCase()));
    }
}
