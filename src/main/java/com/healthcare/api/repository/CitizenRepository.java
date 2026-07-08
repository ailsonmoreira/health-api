package com.healthcare.api.repository;

import com.healthcare.api.entity.Citizen;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.domain.Pageable;
import java.util.Optional;

public interface CitizenRepository extends JpaRepository<Citizen, Long> {
    boolean existsByCpf(String cpf);

    Optional<Citizen> findByCpf(String cpf);

    Page<Citizen> findAllByMicroArea(Integer microArea, Pageable pageable);
}
