package uy.com.canavesi.javaniceday;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class JavanicedayApplication {

    public static void main(String[] args) {
        SpringApplication.run(JavanicedayApplication.class, args);
    }

}
