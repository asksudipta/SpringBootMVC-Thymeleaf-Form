package se.lexicon.springbootmvcthymeleafform.model.dto;

import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString

public class UserView {

    public String name;
    private String email;
    private String password;
    private String gender;
    private String note;
    private boolean married;
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate birthdate;
    private String purpose;



    public UserView(String name, String email, String password, String gender, String note, boolean married, LocalDate birthdate) {
    }
}
