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

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;
import org.springframework.data.repository.query.Param;
import us.xwhite.dvd.domain.base.Film;
import us.xwhite.dvd.domain.base.Inventory;

/**
 *
 * @author Joel Crosswhite <joel.crosswhite@ix.netcom.com>
 */
public interface FilmRepository extends Repository<Film, Short> {

    @Query("select f from Film f where f.title = :title")
    public Film findOneByName(@Param("title") String title);

    @Query("select min(i) "
            + "from Inventory i join i.filmId f left join i.rentalCollection r with r.returnDate is null "
            + "where i.storeId.storeId = :storeId and r.inventoryId is null and f.title = :filmTitle")
    public Inventory findFilmByStoreAndNameForRental(@Param("storeId") Long storeId, @Param("filmTitle") String filmTitle);
}
