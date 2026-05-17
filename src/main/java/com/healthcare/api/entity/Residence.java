package com.healthcare.api.entity;

import com.healthcare.api.enums.*;
import jakarta.persistence.*;

import java.math.BigDecimal;
import java.text.DecimalFormat;

@Entity
public class Residence {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne (cascade = CascadeType.ALL)
    private Addres addres;

    @ManyToOne
    @JoinColumn(name = "micro_area_id")
    private MicroArea microArea;

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
    private SeawageType sewageType;

    @Enumerated (EnumType.STRING)
    private GarbageDisposalType garbageDisposal;

    @Enumerated (EnumType.STRING)
    private WaterTreatmentType waterTreatment;

    private Boolean animals;
    private Integer familyCount;
    private BigDecimal familyIncome;

}
