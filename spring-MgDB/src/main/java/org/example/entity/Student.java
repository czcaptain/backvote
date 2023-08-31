package org.example.entity;


import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collation = "student")
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PRIVATE, force = true)
@ToString
public class Student {
    @Id
    private String id;
    private String name;
    private Student.Type type;

    public enum Type {
        LOW,MIDDLE,HIGH
    }
}
