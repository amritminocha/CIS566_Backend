package com.hotel.api.web.controller;

import com.hotel.api.web.model.ApiResponse;
import com.hotel.api.web.model.Feedback;
import com.hotel.api.web.service.FeedbackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@RestController
@RequestMapping("/api/feedback")
@CrossOrigin(origins = "*")
public class FeedbackController {

    @Autowired
    private FeedbackService feedbackService;

    @PostMapping("/addFeedback")
    public ResponseEntity<ApiResponse<Object>> bookRoom(@RequestBody Feedback feedback) {
        ApiResponse<Object> response = new ApiResponse<>();
        feedbackService.addFeedback(feedback);
        response.setSuccess(true);
        response.setMessage("Feedback added");
        return ResponseEntity.ok().body(response);
    }

    @GetMapping("/getAllFeedbacks")
    public ResponseEntity<List<Feedback>> getAllFeedbacks() {
        List<Feedback> feedbacks = feedbackService.getAllFeedbacks();
        return ResponseEntity.ok(feedbacks);

    }

    @DeleteMapping("/deleteFeedback/{email}")
    public ResponseEntity<ApiResponse<Object>> deleteFeedback(@PathVariable String email) {
        ApiResponse<Object> response = new ApiResponse<>();
        feedbackService.deleteFeedback(email);
        response.setSuccess(true);
        response.setMessage("Feedback removed");
        return ResponseEntity.ok().body(response);
    }

}