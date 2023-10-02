package REST.API.demo.model;

import REST.API.demo.interfaces.CreateUser;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Entity
@Table (name = "user")
public class User {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column (name = "id")
    @Getter
    @Setter
    private long id;

    @Column(name = "username", length = 20, nullable = false, unique = true)
    @Getter
    @Setter
    @NotBlank (message = "This field cannot by empty", groups = CreateUser.class)
    @Size (min = 2, max = 20, groups = CreateUser.class)
    private String username;

    @Column(name = "password", length = 15, nullable = false, unique = true)
    @Getter
    @Setter
    @NotBlank (message = "this field cannot by empty", groups = CreateUser.class)
    @Size (min = 2, max = 15, groups = CreateUser.class)
    private String password;
}
