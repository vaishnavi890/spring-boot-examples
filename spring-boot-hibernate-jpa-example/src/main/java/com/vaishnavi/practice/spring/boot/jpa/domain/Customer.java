package com.vaishnavi.practice.spring.boot.jpa.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@Entity(name = "Customer")
@ToString
@NoArgsConstructor
@EntityListeners(AuditingEntityListener.class)
public class Customer {

    @Id
    @ToString.Exclude
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @Column(name = "firstName")
    private String firstName;

    private String lastName;

    @ToString.Exclude
    private String email;

    @ToString.Exclude
    @CreatedDate
    @Column(updatable = false, nullable = false)
    private LocalDateTime createdTime;

    @Column(nullable = false)
    @CreatedDate
    @LastModifiedDate
    private LocalDateTime updatedTime;

    public Customer(String firstName, String lastName, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }

    public Customer() {
        
    }

    public Object getId() {
        return null;
    }

    public Object getFirstName() {
        return null;
    }

    public Object getLastName() {
        return null;
    }

    public Object getEmail() {
        return null;
    }

    public void setFirstName(Object firstName) {
    }

    public void setLastName(Object lastName) {
    }

    public void setEmail(Object email) {
    }
}

