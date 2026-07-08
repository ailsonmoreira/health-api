package com.healthcare.api.entity;
import com.healthcare.api.enums.EducationLevel;
import com.healthcare.api.enums.Gender;
import com.healthcare.api.enums.Race;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@Table(name = "citizens")
@Entity
public class Citizen {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column (nullable = false, unique = true, length = 11)
    private String cpf;

    @Column (unique = true)
    private String cns;


    private LocalDate birthDate;

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
    private Boolean respiratoryDisease;
    private Integer microArea;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "family_responsible_id")
    private Citizen familyResponsible;

    private String cpfResponsibleFamily;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "residence_id")
    private Residence residence;

}
