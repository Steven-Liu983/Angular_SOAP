package com.example.demo.model

import jakarta.xml.bind.annotation.*

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = ["name", "email"])
@XmlRootElement(name = "ContactRequest", namespace="http://www.example.com/contact")
class ContactRequest {
    @XmlElement(name = "name", namespace = "http://www.example.com/contact", required = true)
    var name: String? = null

    @XmlElement(name = "email", namespace = "http://www.example.com/contact", required = true)
    var email: String? = null
}
