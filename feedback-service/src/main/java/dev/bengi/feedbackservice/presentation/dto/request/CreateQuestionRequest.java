package dev.bengi.feedbackservice.presentation.dto.request;

import dev.bengi.feedbackservice.domain.model.enums.QuestionSentiment;
import lombok.Data;

@Data
public class CreateQuestionRequest {
    private String text;
    private String type;
    private String category;
    private QuestionSentiment sentiment;
}