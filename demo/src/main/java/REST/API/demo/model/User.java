package REST.API.demo.model;

import REST.API.demo.interfaces.CreateUser;

import REST.API.demo.interfaces.UpdateUser;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Entity
@Table (name = "user")
@EqualsAndHashCode
public class User {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column (name = "id")
    @Getter
    @Setter
    @EqualsAndHashCode.Include
    private long id;

    @Column(name = "username", length = 20, nullable = false, unique = true)
    @Getter
    @Setter
    @NotBlank (message = "This field cannot by empty", groups = CreateUser.class)
    @Size (min = 2, max = 20, groups = {CreateUser.class})
    @EqualsAndHashCode.Include
    private String username;

    @JsonProperty (access = JsonProperty.Access.WRITE_ONLY)
    @Column(name = "password", length = 15, nullable = false, unique = true)
    @Getter
    @Setter
    @NotBlank (message = "this field cannot by empty", groups = {CreateUser.class, UpdateUser.class})
    @Size (min = 2, max = 15, groups = {CreateUser.class, UpdateUser.class})
    @EqualsAndHashCode.Include
    private String password;


}
