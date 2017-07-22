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
package us.xwhite.dvd.service;

import java.util.Date;
import java.util.List;
import javax.transaction.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import us.xwhite.dvd.db.CustomerRepository;
import us.xwhite.dvd.db.FilmRepository;
import us.xwhite.dvd.db.RentalRepository;
import us.xwhite.dvd.db.StaffRepository;
import us.xwhite.dvd.db.StoreRepository;
import us.xwhite.dvd.domain.base.Customer;
import us.xwhite.dvd.domain.base.Inventory;
import us.xwhite.dvd.domain.base.Rental;
import us.xwhite.dvd.domain.base.Staff;

/**
 *
 * @author Joel Crosswhite <joel.crosswhite@ix.netcom.com>
 */
@Service
public class RentalService {
    
    private static final Logger LOGGER = LoggerFactory
            .getLogger(RentalService.class);

    private final StoreRepository storeRepository;
    private final FilmRepository filmRepository;
    private final CustomerRepository customerRepository;
    private final RentalRepository rentalRepository;

    private final Staff STAFF;

    @Autowired
    public RentalService(StoreRepository storeRepository, FilmRepository filmRepository, CustomerRepository customerRepository, StaffRepository staffRepository, RentalRepository rentalRepository) {

        this.storeRepository = storeRepository;
        this.filmRepository = filmRepository;
        this.customerRepository = customerRepository;
        this.rentalRepository = rentalRepository;
        
        // would probably want to create a "service" staff acount
        this.STAFF = staffRepository.findOneById((short) 1);
    }

    @Transactional
    public void rentMovies(Long storeId, List<String> filmTitles) {

        if (storeRepository.checkStore(storeId) != null) {

            Customer customer = customerRepository.findOneByAuthenticatedUser();

            if (customer != null) {
                for (String filmTitle : filmTitles) {

                    Inventory inventory = filmRepository.findFilmByStoreAndNameForRental(storeId, filmTitle);
                    LOGGER.debug("inventory:={}", inventory);

                    if (inventory != null) {

                        Rental rental = new Rental();
                        rental.setCustomerId(customer);
                        rental.setInventoryId(inventory);
                        rental.setRentalDate(new Date());
                        rental.setStaffId(STAFF);
                        rental.setLastUpdate(new Date());
                        rentalRepository.save(rental);
                    }
                }
            }
        }
    }
}
