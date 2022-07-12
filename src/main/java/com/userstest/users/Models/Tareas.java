package com.userstest.users.Models;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;

@Entity
@Table(name = "tareas")
public class Tareas {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter @Setter @Column(name = "id")
    private Long id;
    @Getter @Setter @Column(name = "actividad")
    private String actividad;
    @JsonFormat(pattern="yyyy-MM-dd")
    @Getter @Setter @Column(name = "fecha")
    private Date fecha;
}

