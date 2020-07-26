package com.app.person.validator;

import com.app.person.constants.enums.PersonColumns;
import com.app.person.dto.exception.RequestValidationException;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class PersonRequestValidator {

    private List<String> columns = new ArrayList<>();

    @PostConstruct
    private void postConstruct(){
        columns.addAll(Arrays.asList(PersonColumns.values()).stream().map(col -> col.toString()).collect(Collectors.toList()));
    }

    public void validateColumn(String column){
        if(StringUtils.isEmpty(column)) throw new RequestValidationException("Validation Error: Invalid column.");
        if(columns.indexOf(column.toUpperCase()) == -1) throw new RequestValidationException("Validation Error: Invalid param value.");
    }
}
