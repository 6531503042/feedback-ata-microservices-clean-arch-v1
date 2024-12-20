package dev.bengi.feedbackservice.presentation.dto.response;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@Builder
public class ProjectResponse {
    private UUID id;
    private String name;
    private String description;
    private LocalDateTime feedbackStartDate;
    private LocalDateTime feedbackEndDate;
    private boolean active;
    private Integer totalEmployees;
    private Integer participatedEmployees;
}