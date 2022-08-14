package se.lexicon.springbootmvcthymeleafform.model.entity;
import lombok.*;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode

@Entity
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;

    private String email;

    private String password;
    private String gender;
    private String note;
    private boolean married;
    private LocalDate birthdate;
    private String purpose;


    public UserEntity(String name, String email, String password, String gender, String gender1, boolean married, String note, String purpose) {

    }

    public UserEntity(String name) {

    }
}
