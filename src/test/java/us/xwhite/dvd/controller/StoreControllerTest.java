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

import static org.hamcrest.Matchers.hasSize;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import static org.mockito.BDDMockito.given;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.header;
import us.xwhite.dvd.domain.InventorySummary;
import us.xwhite.dvd.domain.StoreSummary;
import us.xwhite.dvd.service.InventoryService;
import us.xwhite.dvd.service.StoreService;

/**
 *
 * @author Joel Crosswhite <joel.crosswhite@ix.netcom.com>
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class StoreControllerTest {

    @Autowired
    MockMvc mockMvc;

    @MockBean
    private InventoryService inventoryService;

    @MockBean
    private StoreService storeService;

    @Test
    public void getAllStores() throws Exception {

        List<StoreSummary> expectedResult = new ArrayList<>();
        StoreSummary store1 = new StoreSummary();
        store1.setStoreId(1L);
        store1.setAddress("123 Main St");
        store1.setCity("Denver");
        store1.setDistrict("Colorado");
        store1.setCountry("USA");
        expectedResult.add(store1);

        given(storeService.getAllStoreSummary())
                .willReturn(expectedResult);

        mockMvc.perform(MockMvcRequestBuilders.get("/api/stores").accept(MediaType.APPLICATION_JSON))
                // .andDo(print())
                .andExpect(status().isOk()).andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(header().string(HttpHeaders.ETAG, "\"0b8112a05406407b3d2b9ab377e1c8e01\""))
                .andExpect(jsonPath("$", hasSize(1)));

        verify(storeService, atLeast(1)).getAllStoreSummary();
    }

    @Test
    public void getAllInStockVideos() throws Exception {

        List<InventorySummary> expectedResult = new ArrayList<>();
        InventorySummary inventory1 = new InventorySummary("ALL THE ROSES", "Drama", 4L);
        expectedResult.add(inventory1);

        given(inventoryService.getInStockInventory(1L))
                .willReturn(expectedResult);

        mockMvc.perform(MockMvcRequestBuilders.get("/api/stores/1/inventory").accept(MediaType.APPLICATION_JSON))
                // .andDo(print())
                .andExpect(status().isOk()).andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(header().string(HttpHeaders.ETAG, "\"029748d1cb4df1af20eb0ae62f85d91b1\""))
                .andExpect(jsonPath("$", hasSize(1)));

        verify(inventoryService, atLeast(1)).getInStockInventory(1L);
    }
}
