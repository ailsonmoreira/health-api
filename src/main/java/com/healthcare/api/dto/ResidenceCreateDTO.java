package com.healthcare.api.dto;

import com.healthcare.api.enums.*;

import java.math.BigDecimal;

public record ResidenceCreateDTO(

        LocationZone locationZone,
        HousingSituation housingSituation,
        HousingType housingType,
        Integer microArea,

        Integer residentCount,
        Integer roomCount,
        Boolean electricity,

        WaterSupplyType waterSupply,
        SewageType sewageType,
        GarbageDisposalType garbageDisposal,
        WaterTreatmentType waterTreatment,

        Boolean animals,
        Integer familyCount,
        BigDecimal familyIncome,

        String cpfResponsible
) {
}
