package com.example.demo.controller

import com.example.demo.model.Contact
import com.example.demo.service.ContactService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/")
@CrossOrigin(origins = ["http://localhost:4200"], maxAge = 3600)
class ContactController(private val contactService: ContactService) {
    @PostMapping("/contact")
    fun createContact(@RequestBody contact: Contact): ResponseEntity<Contact> {
        val savedContact = contactService.save(contact)
        return ResponseEntity.ok(savedContact)
    }
}
