package com.scalearn.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document
public class ScalearnUser {
    @Id
    private String id;
    private String userName;

    @Indexed(unique = true)
    private String emailId;
    private String password;
}
