package com.hotel.api.web.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import javax.sql.DataSource;

@Configuration
public class DatabaseConfig {

    @Bean
    public JdbcTemplate jdbcTemplate(DataSource dataSource) {
        return new JdbcTemplate(dataSource);
    }
}

/* I tried to apply Singleton pattern without using the default @Bean method which by default marks it Singleton
* But there is an error in below approach that it needs a visible(public) constructor - needs to resolve!
* */

//package com.hotel.api.web.config;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.jdbc.core.JdbcTemplate;
//import org.springframework.jdbc.datasource.DriverManagerDataSource;
//
//import javax.sql.DataSource;
//import java.util.Objects;
//
//@Configuration
//public class DatabaseConfig {
//
//    private static final String DATABASE_URL = "jdbc:mysql://localhost:3306/hotel";
//    private static final String DATABASE_USERNAME = "root";
//    private static final String DATABASE_PASSWORD = "Humanity@123";
//
//    private static final DataSource dataSource = createDataSource();
//
//    // private constructor to prevent instantiation: Singleton step
//    private DatabaseConfig() {
//    }
//
//    @Bean
//    public static DataSource getDataSource() {
//        return dataSource;
//    }
//
//    @Bean
//    public static JdbcTemplate getJdbcTemplate() {
//        return new JdbcTemplate(getDataSource());
//    }
//
//    private static DataSource createDataSource() {
//        if (Objects.isNull(dataSource)) {
//            DriverManagerDataSource newDataSource = new DriverManagerDataSource();
//            newDataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
//            newDataSource.setUrl(DATABASE_URL);
//            newDataSource.setUsername(DATABASE_USERNAME);
//            newDataSource.setPassword(DATABASE_PASSWORD);
//            return newDataSource;
//        }
//        return dataSource;
//    }
//}
