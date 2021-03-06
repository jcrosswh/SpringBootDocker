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

import java.util.List;
import javax.transaction.Transactional;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import us.xwhite.dvd.domain.InventorySummary;

/**
 *
 * @author Joel Crosswhite <joel.crosswhite@ix.netcom.com>
 */
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
@ActiveProfiles("test")
public class InventorySummaryRepositoryTest {
    
    @Autowired
    private InventorySummaryRepository inventorySummaryRepository;
    
    @Test
    @Transactional
    public void findAllInStockAtStore() {
        List<InventorySummary> inventorySummary = inventorySummaryRepository.findAllInStockAtStore(1L);
        Assert.assertEquals(3, inventorySummary.size());
        Assert.assertEquals(1, inventorySummary.get(1).getCount().intValue());
        Assert.assertEquals(2, inventorySummary.get(2).getCount().intValue());
        Assert.assertEquals("ACE GOLDFINGER", inventorySummary.get(1).getFilmTitle());
        Assert.assertEquals("ADAPTATION HOLES", inventorySummary.get(2).getFilmTitle());
        Assert.assertEquals("Action", inventorySummary.get(2).getCategory());
    }
}
