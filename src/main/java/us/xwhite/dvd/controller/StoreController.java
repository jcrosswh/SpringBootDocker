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

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import us.xwhite.dvd.domain.InventorySummary;
import us.xwhite.dvd.domain.StoreSummary;
import us.xwhite.dvd.service.InventoryService;
import us.xwhite.dvd.service.StoreService;

/**
 *
 * @author Joel Crosswhite <joel.crosswhite@ix.netcom.com>
 */
@RestController
@RequestMapping("/api/stores")
public class StoreController {

    private static final Logger logger = LoggerFactory
            .getLogger(StoreController.class);

    @Autowired
    InventoryService inventoryService;

    @Autowired
    StoreService storeService;

    @CrossOrigin
    @RequestMapping(value = {"", "/"}, method = RequestMethod.GET)
    public List<StoreSummary> getAllStores() {
        logger.debug("In getAllStores...");
        return storeService.getAllStoreSummary();
    }

    @CrossOrigin
    @RequestMapping(value = "/{id}/inventory", method = RequestMethod.GET)
    public List<InventorySummary> getAllStoresInventory(@PathVariable("id") Long storeId) {
        logger.debug("In getAllStoresInventory...");
        logger.debug("id:={}", storeId);
        return inventoryService.getInStockInventory(storeId);
    }
}
