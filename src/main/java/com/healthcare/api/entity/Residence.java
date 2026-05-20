package com.healthcare.api.entity;

import com.healthcare.api.enums.*;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Residence {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;

    private String zipCode;
    private String street;
    private String number;
    private String neighborhood;
    private String city;
    private String state;
    private String complement;
    private String referencePoint;
    private Integer microArea;

    @Enumerated (EnumType.STRING)
    private LocationZone locationZone;

    @Enumerated (EnumType.STRING)
    private HousingSituation housingSituation;

    @Enumerated (EnumType.STRING)
    private HousingType housingType;

    private Integer residentCount;
    private Integer RoomCount;
    private Boolean electricity;

    @Enumerated (EnumType.STRING)
    private WaterSupplyType waterSupply;

    @Enumerated (EnumType.STRING)
    private SewageType sewageType;

    @Enumerated (EnumType.STRING)
    private GarbageDisposalType garbageDisposal;

    @Enumerated (EnumType.STRING)
    private WaterTreatmentType waterTreatment;

    private Boolean animals;
    private Integer familyCount;
    private BigDecimal familyIncome;
}
