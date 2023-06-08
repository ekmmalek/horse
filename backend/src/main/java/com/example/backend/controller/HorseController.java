package com.example.backend.controller;

import com.example.backend.dto.HorseDTO;
import com.example.backend.entity.HorseEntity;
import com.example.backend.service.HorseService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

// http://localhost:8080/api/v1/horse/get-all

// GET, POST, PUT, DELETE
// Controller -> Service -> Repository

@Slf4j
@RestController
@RequestMapping("/api/v1/horse")
@RequiredArgsConstructor
public class HorseController {

    private final HorseService horseService;

    @GetMapping("/get/{page}/{size}")
    public ResponseEntity<Page<HorseDTO>> getAll(@PathVariable int page, @PathVariable int size) {
        PageRequest pageRequest = PageRequest.of(page, size);
        log.info("Trying to get page with horses, page: {}, size: {}", page, size);
        return ResponseEntity.status(HttpStatus.OK).body(horseService.getAll(pageRequest));
    }

    @PutMapping("/{horseId}/book/{dateId}")
    public ResponseEntity<Void> tryBook(@PathVariable Long horseId, @PathVariable Long dateId) {
        horseService.tryBook(horseId, dateId);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

}
