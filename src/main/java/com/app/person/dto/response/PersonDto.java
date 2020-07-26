package com.app.person.dto.response;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@NoArgsConstructor
public class PersonDto {
    private UUID id;
    private String name;
    private int age;
    private String gender;
}
