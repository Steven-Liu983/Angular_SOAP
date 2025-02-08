package com.example.demo.model

import jakarta.xml.bind.annotation.*

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = ["message"])
@XmlRootElement(name = "ContactResponse", namespace="http://www.example.com/contact")
class ContactResponse {
    @XmlElement(name = "message", required = true)
    var message: String? = null
}
