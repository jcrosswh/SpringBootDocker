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
package us.xwhite.dvd.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import us.xwhite.dvd.db.CustomerRepository;
import us.xwhite.dvd.domain.CustomerSummary;

/**
 *
 * @author Joel Crosswhite <joel.crosswhite@ix.netcom.com>
 */
@RestController
@RequestMapping("/api/customers")
public class CustomerController {
    
    private static final Logger logger = LoggerFactory
            .getLogger(CustomerController.class);
    
    @Autowired
    private CustomerRepository customerRepository;
    
    @CrossOrigin(origins = "http://localhost:4200")
    @RequestMapping(value = {"/current"}, method = RequestMethod.GET)
    public CustomerSummary getLoggedInDetails() {
        logger.debug("In getLoggedInDetails...");
        return customerRepository.findOneSummaryByAuthenticatedUser();
    }
    
}
