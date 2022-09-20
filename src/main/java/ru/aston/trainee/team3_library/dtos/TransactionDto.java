package ru.aston.trainee.team3_library.dtos;

import lombok.Data;
import ru.aston.trainee.team3_library.entities.User;

@Data
public class TransactionDto {
    private User user;

    private Double totalCost;

    private String type;
}
