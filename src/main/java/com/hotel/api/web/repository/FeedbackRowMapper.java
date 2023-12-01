package com.hotel.api.web.repository;
import com.hotel.api.web.model.Feedback;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class FeedbackRowMapper implements RowMapper<Feedback> {
    public Feedback mapRow(ResultSet rs, int rowNum) throws SQLException {
        Feedback feedback = new Feedback(rs.getString("email"), rs.getInt("rating"), rs.getString("comment"));
        return feedback;
    }
}
