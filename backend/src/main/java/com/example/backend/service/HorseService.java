package com.example.backend.service;

import com.example.backend.dto.HorseDTO;
import com.example.backend.entity.HorseEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface HorseService {

    Page<HorseDTO> getAll(Pageable pageable);

    void tryBook(Long horseId, Long dateId);

}
