package com.example.backend.mapper;

import com.example.backend.dto.HorseDTO;
import com.example.backend.entity.HorseEntity;


public class HorseMapper {
    // objectMapper

    public static HorseDTO mapHorseEntityToDto(HorseEntity horseEntity) {
        return HorseDTO.builder()
                .horseName(horseEntity.getHorseName())
                .gender(horseEntity.getGender())
                .build();
    }

}
