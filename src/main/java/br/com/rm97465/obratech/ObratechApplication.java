package br.com.rm97465.obratech;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(enableDefaultTransactions = false)
public class ObratechApplication {

    public static void main (String[] args) {
        SpringApplication.run(ObratechApplication.class, args);

    }
}
