package com.example.demo.repository

import com.example.demo.model.Contact
import org.springframework.data.jpa.repository.JpaRepository

interface ContactRepository : JpaRepository<Contact, Long>
