package itmo.dev.models;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "owners", schema = "public")
public class Owner {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    @Column(name = "birth_date")
    private LocalDate birthDate;
    @OneToMany(mappedBy = "owner")
    private List<Cat> catsList = new ArrayList<>();
}
