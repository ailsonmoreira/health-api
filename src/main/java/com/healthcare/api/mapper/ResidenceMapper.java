package com.healthcare.api.mapper;

import com.healthcare.api.dto.ResidenceCreateDTO;
import com.healthcare.api.dto.ResidenceResponseDTO;
import com.healthcare.api.entity.Residence;
import org.springframework.stereotype.Component;

@Component
public class ResidenceMapper {
    public Residence toEntity(ResidenceCreateDTO dto) {

        Residence r = new Residence();

        r.setLocationZone(dto.locationZone());
        r.setHousingSituation(dto.housingSituation());
        r.setHousingType(dto.housingType());

        r.setResidentCount(dto.residentCount());
        r.setRoomCount(dto.roomCount());
        r.setElectricity(dto.electricity());

        r.setWaterSupply(dto.waterSupply());
        r.setSewageType(dto.sewageType());
        r.setGarbageDisposal(dto.garbageDisposal());
        r.setWaterTreatment(dto.waterTreatment());

        r.setAnimals(dto.animals());
        r.setFamilyCount(dto.familyCount());
        r.setFamilyIncome(dto.familyIncome());

        r.setCpfResponsible(dto.cpfResponsible());

        return r;
    }

    public ResidenceResponseDTO toDTO(Residence r) {

        return new ResidenceResponseDTO(

                r.getId(),

                r.getLocationZone(),
                r.getHousingSituation(),
                r.getHousingType(),

                r.getResidentCount(),
                r.getRoomCount(),
                r.getElectricity(),

                r.getWaterSupply(),
                r.getSewageType(),
                r.getGarbageDisposal(),
                r.getWaterTreatment(),

                r.getAnimals(),
                r.getFamilyCount(),
                r.getFamilyIncome(),

                r.getCpfResponsible(),

                r.getResponsible() != null ? r.getResponsible().getId() : null,
                r.getResponsible() != null ? r.getResponsible().getName() : null
        );
    }
}
