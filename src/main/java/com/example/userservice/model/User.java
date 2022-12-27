package com.example.userservice.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.jetbrains.annotations.NotNull;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

import java.util.Date;
import java.util.UUID;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Table("user")
public class User {
    @PrimaryKey
    private UUID id;
    private String firstName;
    private String lastName;

    @NotNull
    private String email;
    private boolean isActive;
    @JsonIgnore
    private String password;
    private int maxAttempt;
    private boolean emailVerified;
    private boolean phoneNumberVerified;

    private int userInformation;

    private String username;
    @CreatedDate

    private Date createdDate;
    private String roles;

    private Date lastConnection;
    private String profilePhoto;
    private boolean premium;
    private Date activationDate;
    private Date expirationDate;
    private String phoneNumber;

    private Integer giftId;
    private String coin;
    private Date updatedAt;

}
