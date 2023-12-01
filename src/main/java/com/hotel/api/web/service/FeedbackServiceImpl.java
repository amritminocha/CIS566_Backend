package com.hotel.api.web.service;

import com.hotel.api.web.model.Feedback;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class FeedbackServiceImpl implements FeedbackService {
    private List<Feedback> feedbacks;

    public FeedbackServiceImpl() {
        feedbacks = new ArrayList<Feedback>();
    }

    public List<Feedback> getAllFeedbacks() {
        return feedbacks;
    }

    public Feedback addFeedback(Feedback feedback) {
        feedbacks.add(feedback);
        return feedback;
    }

    public void deleteFeedback(String email) {
        for (int i = 0; i < feedbacks.size(); i++) {
            if (feedbacks.get(i).getEmail().equals(email)) {
                feedbacks.remove(i);
                break;
            }
        }
    }
}