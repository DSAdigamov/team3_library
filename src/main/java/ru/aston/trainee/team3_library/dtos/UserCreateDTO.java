package ru.aston.trainee.team3_library.dtos;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Date;

@Getter
@Setter
public class UserCreateDTO {
    private String username;
    private String email;
    private String password;



    public UserCreateDTO(String username, String email, String password, String firstName, String lastName, LocalDate birthDate, LocalDate registrationDate) {
        this.username = username;
        this.email = email;
        this.password = password;
    }
}
