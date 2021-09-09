package com.example.microserviceemail.repository;

import com.example.microserviceemail.model.Email;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmailRepository extends JpaRepository<Email, Long> {

}
