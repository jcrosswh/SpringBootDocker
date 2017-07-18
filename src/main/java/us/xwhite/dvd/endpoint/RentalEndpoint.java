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
package us.xwhite.dvd.endpoint;

import java.util.ArrayList;
import java.util.List;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactoryConfigurationException;
import org.jdom2.Attribute;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.Namespace;
import org.jdom2.filter.Filters;
import org.jdom2.xpath.XPathExpression;
import org.jdom2.xpath.XPathFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import us.xwhite.dvd.service.RentalService;

/**
 *
 * @author Joel Crosswhite <joel.crosswhite@ix.netcom.com>
 */
@Endpoint
public class RentalEndpoint {

    private static final Logger logger = LoggerFactory
            .getLogger(RentalEndpoint.class);

    private static final String NAMESPACE_URI = "http://xwhite.us/sakila/schemas";

    private XPathExpression<Attribute> storeId;

    private XPathExpression<Attribute> filmTitles;

    private RentalService rentalService;

    public RentalEndpoint(RentalService rentalService)
            throws JDOMException, XPathFactoryConfigurationException,
            XPathExpressionException {
        this.rentalService = rentalService;
        Namespace namespace = Namespace.getNamespace("sakila", NAMESPACE_URI);
        XPathFactory xPathFactory = XPathFactory.instance();
        this.storeId = xPathFactory.compile("//@storeId",
                Filters.attribute(), null, namespace);
        this.filmTitles = xPathFactory.compile("//@title", Filters.attribute(),
                null, namespace);
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "RentalRequest")
    public void handleHolidayRequest(@RequestPayload Element rentalRequest)
            throws Exception {
        this.storeId.evaluateFirst(rentalRequest).getLongValue();
        List<Attribute> filmTitleAttributes = this.filmTitles.evaluate(rentalRequest);
        List<String> filmTitles = new ArrayList<>();
        for (Attribute attr : filmTitleAttributes) {
            filmTitles.add(attr.getValue());
        }
        
        this.rentalService.rentMovies(this.storeId.evaluateFirst(rentalRequest).getLongValue(), filmTitles);
    }
}
