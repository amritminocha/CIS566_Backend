package com.hotel.api.web.repository;
import com.hotel.api.web.model.Feedback;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import java.util.List;

public class FeedbackRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public FeedbackRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Feedback> getAllFeedbacks() {
        return jdbcTemplate.query("select * from feedback", new FeedbackRowMapper());
    }

    public void addFeedback(Feedback feedback) {
        jdbcTemplate.update("insert into feedback values(?,?,?)", feedback.getEmail(), feedback.getRating(), feedback.getComment());
    }

    public void deleteFeedback(String email) {
        jdbcTemplate.update("delete from feedback where email=?", email);
    }
}