package com.hotel.api.web.service;

import com.hotel.api.web.model.Feedback;

import java.util.List;


public interface FeedbackService {

    List<Feedback> getAllFeedbacks();
    Feedback addFeedback(Feedback feedback);
    void deleteFeedback(String email);
}
