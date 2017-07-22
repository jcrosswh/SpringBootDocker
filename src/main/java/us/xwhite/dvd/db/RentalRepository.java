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

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;
import us.xwhite.dvd.domain.base.Rental;

/**
 *
 * @author Joel Crosswhite <joel.crosswhite@ix.netcom.com>
 */
@Repository
public class RentalRepository {

    private static final String INSERT_RENTAL = "insert into rental "
            + "(rental_date, inventory_id, customer_id, staff_id, last_update) "
            + "values (:rental_date, :inventory_id, :customer_id, :staff_id, :last_update)";

    @Autowired
    private NamedParameterJdbcTemplate jdbcTemplate;

    public Rental save(Rental rental) {
        int rentalId = insertRentalAndReturnId(rental);
        return new Rental(rentalId, rental.getRentalDate(), rental.getReturnDate(), rental.getLastUpdate(), rental.getCustomerId(), rental.getInventoryId(), rental.getStaffId());
    }

    private int insertRentalAndReturnId(Rental rental) {
        KeyHolder keyHolder = new GeneratedKeyHolder();
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("rental_date", new Date());
        paramMap.put("inventory_id", rental.getInventoryId().getInventoryId());
        paramMap.put("customer_id", rental.getCustomerId().getCustomerId());
        paramMap.put("staff_id", rental.getStaffId().getStaffId());
        paramMap.put("last_update", new Date());
        jdbcTemplate.update(INSERT_RENTAL, new MapSqlParameterSource(paramMap), keyHolder);
        return keyHolder.getKey().intValue();
    }
}
