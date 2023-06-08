package com.example.backend.dto;

import com.example.backend.enums.GenderEnum;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationPropertiesBinding;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class HorseDTO {

    private GenderEnum gender;

    private String horseName;

}
