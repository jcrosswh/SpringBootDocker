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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import us.xwhite.dvd.domain.InventorySummary;
import us.xwhite.dvd.service.InventoryService;

/**
 *
 * @author Joel Crosswhite <joel.crosswhite@ix.netcom.com>
 */
@RestController
@RequestMapping("/api/inventory")
public class InventoryController {

    @Autowired
    InventoryService inventoryService;

    @RequestMapping(method = RequestMethod.GET)
    public List<InventorySummary> getAllArticles(
            @RequestParam(value = "store", required = true) Long storeId) {
        return inventoryService.getInStockInventory(storeId);
    }

    public InventoryService getInventoryService() {
        return inventoryService;
    }

    public void setInventoryService(InventoryService inventoryService) {
        this.inventoryService = inventoryService;
    }
}