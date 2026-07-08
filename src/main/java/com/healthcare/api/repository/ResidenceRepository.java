package com.healthcare.api.repository;

import com.healthcare.api.entity.Residence;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ResidenceRepository extends JpaRepository <Residence, Long> {

    Optional<Residence> findByCpfResponsible(String cpf);
}
