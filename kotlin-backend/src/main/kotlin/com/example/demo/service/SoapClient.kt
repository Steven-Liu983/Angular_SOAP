package com.example.demo.service

import com.example.demo.model.Contact
import com.example.demo.model.ContactRequest
import com.example.demo.model.ContactResponse
import org.springframework.ws.server.endpoint.annotation.Endpoint
import org.springframework.ws.server.endpoint.annotation.PayloadRoot
import org.springframework.ws.server.endpoint.annotation.RequestPayload
import org.springframework.ws.server.endpoint.annotation.ResponsePayload

@Endpoint
class SoapClient(private val contactService: ContactService) {

    @PayloadRoot(namespace = "http://www.example.com/contact", localPart = "ContactRequest")
    @ResponsePayload
    fun callSoapService(@RequestPayload request: ContactRequest): ContactResponse {
        val newContact = Contact(name = request.name.toString(), email = request.email.toString())
        contactService.save(newContact)
        val response = ContactResponse()
        response.message = "Welcome " + request.name
        return response
    }
}
