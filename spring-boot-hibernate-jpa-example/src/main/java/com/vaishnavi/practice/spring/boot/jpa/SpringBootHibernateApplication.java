package com.vaishnavi.practice.spring.boot.jpa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class SpringBootHibernateApplication
{
    public static void main( String[] args )
    {
        SpringApplication.run(SpringBootHibernateApplication.class, args);
    }
}
