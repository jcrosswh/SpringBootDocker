/*
 * Copyright 2017
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package us.xwhite.dvd;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.ws.config.annotation.WsConfigurerAdapter;
import org.springframework.ws.wsdl.wsdl11.DefaultWsdl11Definition;
import org.springframework.xml.xsd.SimpleXsdSchema;
import org.springframework.xml.xsd.XsdSchema;

/**
 *
 * @author Joel Crosswhite <joel.crosswhite@ix.netcom.com>
 */
@Configuration
public class WebServiceConfiguration extends WsConfigurerAdapter {

	@Bean(name = "rental")
	public DefaultWsdl11Definition defaultWsdl11Definition(XsdSchema rentalSchema) {
		DefaultWsdl11Definition wsdl = new DefaultWsdl11Definition();
		wsdl.setPortTypeName("Rental");
		wsdl.setLocationUri("/rentalService/");
		wsdl.setTargetNamespace("http://xwhite.us/sakila/definitions");
		wsdl.setSchema(rentalSchema);
		return wsdl;
	}

	@Bean
	public XsdSchema rentalSchema() {
		return new SimpleXsdSchema(new ClassPathResource("META-INF/schemas/rental.xsd"));
	}

}