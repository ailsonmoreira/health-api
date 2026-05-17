package com.healthcare.api.entity;
import com.healthcare.api.enums.EducationLevel;
import com.healthcare.api.enums.Gender;
import com.healthcare.api.enums.Race;
import jakarta.persistence.*;

@Entity
public class Person {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Column (nullable = false, unique = true, length = 11)
    private String cpf;

    @Column (unique = true)
    private String cns;

    @Enumerated (EnumType.STRING)
    private Gender gender;

    @Enumerated(EnumType.STRING)
    private EducationLevel educationLevel;

    @Enumerated(EnumType.STRING)
    private Race race;

    private String phone;
    private Boolean diabetes;
    private Boolean smoker;
    private Boolean alcoholUse;
    private Boolean heartDisease;
    private Boolean pregnant;

    @ManyToOne
    @JoinColumn(name = "residende_id")
    private Residence residence;
}
