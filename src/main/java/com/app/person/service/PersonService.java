package com.app.person.service;

import com.app.person.dto.exception.ServiceException;
import com.app.person.dto.request.PersonRequest;
import com.app.person.entity.Person;

import java.util.List;

public interface PersonService {
    List<Person> getAllPersons();
    List<Person> getAllPersonsSorted(PersonRequest personRequest) throws ServiceException;
}
