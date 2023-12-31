package ru.egartech.tmsystem.model.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalTime;

@Setter
@Getter
@NoArgsConstructor
@Entity
@Table(name = "rest")
public class Rest {

    @Id
    @TableGenerator( name = "Address_Gen", initialValue = 121)
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "Address_Gen")
    private Long id;

    @Temporal(TemporalType.DATE)
    @Column(name = "date", nullable = false)
    private LocalDate date;

    @Temporal(TemporalType.TIME)
    @Column(name = "start_rest")
    private LocalTime startRest;

    @Temporal(TemporalType.TIME)
    @Column(name = "end_rest")
    private LocalTime endRest;

    @Column(name = "rest_time")
    private long restTime;

    @ManyToOne
    private Employee employee;
}
