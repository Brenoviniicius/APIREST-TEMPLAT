package REST.API.demo.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
@Entity
@Table( name = Task.TABLE_NAME)
public class Task {
    public static final String TABLE_NAME = "task";


    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column (name = "id", unique= true)
    private long id;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false, updatable = false)
    private User user;

    @Column(name = "description", length = 256, nullable = false)
    @NotBlank
    @Size (min = 1, max = 256)
    private long description;
}
