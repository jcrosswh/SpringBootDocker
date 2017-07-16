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
package us.xwhite.dvd.db;

import javax.transaction.Transactional;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import us.xwhite.dvd.domain.CustomerSummary;

/**
 *
 * @author Joel Crosswhite <joel.crosswhite@ix.netcom.com>
 */
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ActiveProfiles("test")
public class CustomerRepositoryTest {

    @Autowired
    private CustomerRepository customerRepository;

    @Test
    @Transactional
    @WithMockUser(username = "joel.crosswhite@ix.netcom.com")
    public void findOneByAuthenticatedUser() {
        CustomerSummary customer = customerRepository.findOneByAuthenticatedUser();
        Assert.assertNotNull(customer);
        Assert.assertEquals("joel.crosswhite@ix.netcom.com", customer.getEmail());
        Assert.assertEquals("Joel", customer.getFirstName());
    }
    
    @Test
    @Transactional
    @WithMockUser(username = "jcrosswhite")
    public void findOneByAuthenticatedUser_noUser() {
        CustomerSummary customer = customerRepository.findOneByAuthenticatedUser();
        Assert.assertNull(customer);
    }
}
