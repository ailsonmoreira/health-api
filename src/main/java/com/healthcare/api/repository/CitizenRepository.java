package com.healthcare.api.repository;

import com.healthcare.api.entity.Citizen;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CitizenRepository extends JpaRepository<Citizen, Long> {
    boolean existsByCpf(String cpf);
}
