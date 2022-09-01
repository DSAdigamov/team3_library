package ru.aston.trainee.team3_library.dtos;

import lombok.Data;

@Data
public class TransactionDto {

    private Long userId;

    private Double totalCost;

    private String type;

}
