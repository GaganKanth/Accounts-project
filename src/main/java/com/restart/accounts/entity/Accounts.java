package com.restart.accounts.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Document(collection = "Accounts-Data")
public class Accounts  extends BaseEntity{

    private String customerId;

    @Id
    private Long accountNumber;

    private String accountType;

    private String branchAddress;
}
