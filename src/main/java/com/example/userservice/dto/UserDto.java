package com.example.userservice.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {
    private UUID id;
    private String firstName;
    private String lastName;

    private String email;
    private boolean isActive;
    @JsonIgnore
    private String password;
    private int maxAttempt;
    private boolean emailVerified;
    private boolean phoneNumberVerified;

    private int userInformation;

    private String username;
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
