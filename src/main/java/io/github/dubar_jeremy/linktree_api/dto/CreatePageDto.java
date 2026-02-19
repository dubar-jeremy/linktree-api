package io.github.dubar_jeremy.linktree_api.dto;

import jakarta.validation.constraints.NotBlank;
import org.hibernate.validator.constraints.Length;

/**
 * IntelliJ suggests to use record for this kind of DTO.
 * And it seems to be ok to call a record "DTO"
 */
public record CreatePageDto(
        @NotBlank @Length(min = 5, max = 100) String title,
        @NotBlank @Length(min = 100, max = 1500) String description
) {}
