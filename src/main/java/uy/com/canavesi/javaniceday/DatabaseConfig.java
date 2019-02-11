package uy.com.canavesi.javaniceday;

import com.zaxxer.hikari.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.*;
import javax.sql.DataSource;

/**
 *
 * @author Andres canavesi
 */
@Configuration
public class DatabaseConfig {

    @Value("${spring.datasource.url}")
    private String dbUrl;

    @Bean
    public DataSource dataSource() {
        HikariConfig config = new HikariConfig();
        config.setJdbcUrl(dbUrl);
        //config.setCatalog("");
        //config.setUsername("");
        return new HikariDataSource(config);
    }
}
