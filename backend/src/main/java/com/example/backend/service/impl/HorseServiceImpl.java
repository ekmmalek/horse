package com.example.backend.service.impl;

import com.example.backend.dto.HorseDTO;
import com.example.backend.entity.HorseEntity;
import com.example.backend.enums.GenderEnum;
import com.example.backend.mapper.HorseMapper;
import com.example.backend.repository.HorseRepository;
import com.example.backend.service.HorseService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
public class HorseServiceImpl implements HorseService {

    private final HorseRepository horseRepository;

    @Override
    public Page<HorseDTO> getAll(Pageable pageable) {
        List<HorseDTO> mappedHorses = horseRepository.findAll(pageable).stream()
                .map(HorseMapper::mapHorseEntityToDto)
                .collect(Collectors.toList());
        return new PageImpl<>(mappedHorses, pageable, mappedHorses.size());
    }

    @Override
    public void tryBook(Long horseId, Long dateId) {
        HorseEntity horseEntity = horseRepository.findById(horseId).orElseThrow(
                () -> new RuntimeException("Not found horse with id: " + horseId)
        );



    }

    //    @EventListener(ApplicationReadyEvent.class)
//    public void run() {
//        horseRepository.save(HorseEntity.builder().horseName("horse 1").gender(GenderEnum.MALE).build());
//        horseRepository.save(HorseEntity.builder().horseName("horse 2").gender(GenderEnum.FEMALE).build());
//        horseRepository.save(HorseEntity.builder().horseName("horse 3").gender(GenderEnum.MALE).build());
//    }

}
