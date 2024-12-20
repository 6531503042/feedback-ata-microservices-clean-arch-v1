package dev.bengi.feedbackservice.application.port.input;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import dev.bengi.feedbackservice.domain.model.Feedback;
import dev.bengi.feedbackservice.domain.model.enums.QuestionCategory;
import dev.bengi.feedbackservice.domain.model.enums.QuestionSentiment;
import dev.bengi.feedbackservice.presentation.dto.request.SubmitFeedbackRequest;
import dev.bengi.feedbackservice.presentation.dto.response.FeedbackAnalyticsResponse;
import dev.bengi.feedbackservice.presentation.dto.response.ProjectMetricsResponse;

public interface FeedbackUseCase {
    Feedback submitFeedback(UUID userId, SubmitFeedbackRequest request);

    List<Feedback> getFeedbacksByProject(UUID projectId);

    List<Feedback> getFeedbacksWithFilters(
        UUID projectId,
        QuestionCategory category,
        QuestionSentiment sentiment,
        String privacyLevel,
        String searchTerm
    );

    FeedbackAnalyticsResponse getProjectAnalytics(UUID projectId);

    ProjectMetricsResponse getProjectMetrics(UUID projectId);

    FeedbackAnalyticsResponse getYearlyAnalytics(int year);

    List<Feedback> getRecentFeedback(int limit);

    byte[] generateYearlyReport(int year);

    List<Feedback> findByProjectId(UUID projectId);
    
    List<Feedback> findWithFilters(
        UUID projectId,
        QuestionCategory category,
        QuestionSentiment sentiment,
        String privacyLevel,
        String searchTerm
    );
    
    Double getAverageRatingByProjectId(UUID projectId);
    
    Double getAverageRatingByProjectIdAndCategory(UUID projectId, QuestionCategory category);
    
    List<Feedback> findBySubmittedAtBetween(LocalDateTime startDate, LocalDateTime endDate);
    
    List<Feedback> findTopByOrderBySubmittedAtDesc(int limit);
}