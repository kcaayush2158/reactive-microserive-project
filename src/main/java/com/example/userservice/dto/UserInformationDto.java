package com.example.userservice.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserInformationDto {
    @PrimaryKey
    private UUID id;
    private int height;
    private int weight;

}
