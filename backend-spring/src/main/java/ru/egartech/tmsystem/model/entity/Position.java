package ru.egartech.tmsystem.model.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor
@Getter
@Setter
@Table(name = "position")
@ToString(exclude = {"employees"})
@EqualsAndHashCode(exclude = {"employees"})
public class Position {

    @Id
    @TableGenerator( name = "Address_Gen", initialValue = 7)
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "Address_Gen")
    private Long id;

    @Column(name = "name", nullable = false, unique = true, length = 60)
    @Pattern(regexp = "[Я-аА-яa-zA-Z\\s]*$", message = "{name.only.letters}")
    @Pattern(regexp = "^\\S+(?: \\S+)*$", message = "{name.start.end.no.spaces}")
    @Size(min = 1, message = "Наименование должно быть не менее 1 символа")
    @Size(max = 60, message = "Наименование должно быть не более 60 символов")
    private String name;

    @ManyToOne
    private Department department;

    @OneToMany(mappedBy = "position", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @OrderBy("name ASC")
    private List<Employee> employees = new ArrayList<>();

    public Position(String name) {
        this.name = name;
    }

    public Position(String name, Department department) {
        this.name = name;
        this.department = department;
    }
}
