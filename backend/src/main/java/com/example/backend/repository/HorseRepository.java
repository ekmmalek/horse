package com.example.backend.repository;

import com.example.backend.entity.HorseEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface HorseRepository extends JpaRepository<HorseEntity, Long> {

    Page<HorseEntity> findAll(Pageable pageable);

}
