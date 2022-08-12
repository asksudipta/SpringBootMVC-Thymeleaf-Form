package se.lexicon.springbootmvcthymeleafform.model.dto;

import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

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
}
