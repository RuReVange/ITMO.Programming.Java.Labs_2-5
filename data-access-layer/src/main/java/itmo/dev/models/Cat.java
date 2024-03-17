package itmo.dev.models;

import java.time.LocalDate;
import java.util.List;

public class Cat {

    private String name;
    private LocalDate birthDate;
    private Breed breed;
    private Color color;
    private Owner owner;
    private List<Cat> catFriedns;
}
