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

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import us.xwhite.dvd.db.InventorySummaryRepository;
import us.xwhite.dvd.domain.InventorySummary;

/**
 *
 * @author Joel Crosswhite <joel.crosswhite@ix.netcom.com>
 */
public class InventoryService {
 
    @Autowired
    private InventorySummaryRepository inventorySummaryRepository;
    
    public List<InventorySummary> getInStockInventory(Long storeId) {
        return inventorySummaryRepository.findAllInStockAtStore(storeId);
    }
}
