package dev.bengi.feedbackservice.domain.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "projects", uniqueConstraints = {
    @UniqueConstraint(name = "uk_project_name", columnNames = "name")
})
public class Project {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @NotBlank
    private String name;
    
    private String description;
    
    @NotNull
    private LocalDateTime feedbackStartDate;
    
    @NotNull
    private LocalDateTime feedbackEndDate;
    
    private boolean active;

    @NotNull
    private Integer totalEmployees;
    
    private Integer participatedEmployees;

    @ManyToMany
    @JoinTable(
        name = "project_questions",
        joinColumns = @JoinColumn(name = "project_id"),
        inverseJoinColumns = @JoinColumn(name = "question_id")
    )
    private List<Question> questions;
}