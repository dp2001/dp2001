package com.example.curriculumdesign.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
private String   uid ;
private String   hm ;
private Integer role;
private String  name;
}
