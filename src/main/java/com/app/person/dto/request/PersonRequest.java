package com.app.person.dto.request;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class PersonRequest {
    private String clientName;
    private String clientKey;
    private String column;
    private String personId;
    private int age;
    private String gender;
    private String name;
    private int page;


}
