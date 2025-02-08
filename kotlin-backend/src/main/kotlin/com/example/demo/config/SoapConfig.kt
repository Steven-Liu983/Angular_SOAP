package com.example.demo.config

import org.springframework.boot.web.servlet.ServletRegistrationBean
import org.springframework.context.ApplicationContext
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.core.io.ClassPathResource
import org.springframework.ws.config.annotation.EnableWs
import org.springframework.ws.transport.http.MessageDispatcherServlet
import org.springframework.ws.wsdl.wsdl11.DefaultWsdl11Definition
import org.springframework.xml.xsd.SimpleXsdSchema
import org.springframework.xml.xsd.XsdSchema

@EnableWs
@Configuration
class SoapConfig {
    @Bean
    fun messageDispatcherServlet(context: ApplicationContext): ServletRegistrationBean<*> {
        val messageDispatcherServlet = MessageDispatcherServlet()
        messageDispatcherServlet.setApplicationContext(context)
        messageDispatcherServlet.setTransformWsdlLocations(true)

        return ServletRegistrationBean(messageDispatcherServlet, "/ws/*")
    }

    @Bean(name = ["contact"])
    fun defaultWsdl11Definition(contactSchema: XsdSchema?): DefaultWsdl11Definition? {
        val definition = DefaultWsdl11Definition()
        definition.setPortTypeName("ContactPort")
        definition.setTargetNamespace("http://www.example.com/contact")
        definition.setLocationUri("/ws")
        definition.setSchema(contactSchema)

        return definition
    }

    @Bean
    fun contactSchema(): XsdSchema {
        return SimpleXsdSchema(ClassPathResource("contact-data.xsd"))
    }
}
