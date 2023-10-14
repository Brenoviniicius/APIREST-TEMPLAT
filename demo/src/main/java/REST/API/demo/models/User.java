package REST.API.demo.models;

import REST.API.demo.models.DTO.CreateUser;

import REST.API.demo.models.DTO.UpdateUser;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table (name = "user")
public class User {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column (name = "id")
    private long id;

    @Column(name = "username", length = 20, nullable = false, unique = true)
    @NotBlank (message = "This field cannot by empty", groups = CreateUser.class)
    @Size (min = 2, max = 20, groups = {CreateUser.class})
    private String username;

    @JsonProperty (access = JsonProperty.Access.WRITE_ONLY)
    @Column(name = "password", length = 15, nullable = false, unique = true)
    @NotBlank (message = "this field cannot by empty", groups = {CreateUser.class, UpdateUser.class})
    @Size (min = 2, max = 15, groups = {CreateUser.class, UpdateUser.class})
    private String password;

    @OneToMany (mappedBy = "user")
    private List<Task> tasks = new ArrayList<Task>();

}
