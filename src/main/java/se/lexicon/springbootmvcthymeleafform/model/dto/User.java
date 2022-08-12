package se.lexicon.springbootmvcthymeleafform.model.dto;

import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDate;


@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString

public class User {
    @NotEmpty(message = "Product Name should not be empty")
    @Size(min =2, max = 50,message = "Name length should be between 2 to 50 character")
    private String name;
    @NotNull
    private String email;
    @NotNull
    private String password;
    private String gender;
    private String note;
    private boolean married;

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    @NotNull
    private LocalDate birthdate;
    private String purpose;


}
