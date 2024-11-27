package dev.bengi.feedbackservice.presentation.dto.request;

import dev.bengi.feedbackservice.domain.model.Question;
import dev.bengi.feedbackservice.domain.model.enums.PrivacyLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Map;
import java.util.UUID;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SubmitFeedbackRequest {
    private UUID projectId;
    private String title;
    private String description;
    private String category;
    private PrivacyLevel privacyLevel;
    private Question question;
    private Map<UUID, String> answers;
    private Double rating;
}