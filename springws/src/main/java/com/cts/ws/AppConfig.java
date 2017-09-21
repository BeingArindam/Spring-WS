package com.cts.ws;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.ws.config.annotation.EnableWs;
import org.springframework.ws.config.annotation.WsConfigurerAdapter;
import org.springframework.ws.wsdl.wsdl11.DefaultWsdl11Definition;
import org.springframework.xml.xsd.SimpleXsdSchema;
import org.springframework.xml.xsd.XsdSchema;

@Configuration
@EnableWs
@ComponentScan("com.cts.ws")
public class AppConfig extends WsConfigurerAdapter {

	/*
	 * public static void main(String[] args) {
	 * SpringApplication.run(AppConfig.class, args); }
	 */

	@Bean(name = "bookService")
	public DefaultWsdl11Definition defaultWsdl11Definition(XsdSchema booksSchema) {
		final DefaultWsdl11Definition wsdl11Definition = new DefaultWsdl11Definition();
		wsdl11Definition.setPortTypeName("BookServicePort");
		wsdl11Definition.setLocationUri("/bookService");
		wsdl11Definition.setTargetNamespace("http://ws.cts.com/bookService");
		wsdl11Definition.setSchema(booksSchema);
		return wsdl11Definition;
	}

	@Bean
	public XsdSchema booksSchema() {
		return new SimpleXsdSchema(new ClassPathResource("BookService.xsd"));
	}

}
