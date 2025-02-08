package com.example.demo.service

import com.example.demo.model.Contact
import com.example.demo.repository.ContactRepository
import org.springframework.stereotype.Service

@Service
class ContactService(private val repository: ContactRepository) {
    fun save(contact: Contact) = repository.save(contact)
}
