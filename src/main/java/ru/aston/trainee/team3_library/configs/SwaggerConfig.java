package ru.aston.trainee.team3_library.configs;


import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.security.SecurityScheme;
import org.springframework.context.annotation.Configuration;

@Configuration
@OpenAPIDefinition(
        info = @Info(title = "Library")
)
@SecurityScheme(
        name = "Authentication",
        type = SecuritySchemeType.HTTP,
        scheme = "bearer"
)
public class SwaggerConfig {

}
