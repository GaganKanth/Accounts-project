package com.restart.accounts.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document("Customer-Data")
public class Customer extends BaseEntity {

    @Id
    private Long customerId;

    private String name;

    private String email;

    private String mobileNumber;
}
