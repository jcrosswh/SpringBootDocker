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

import java.util.ArrayList;
import java.util.List;
import static org.hamcrest.Matchers.hasSize;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import us.xwhite.dvd.domain.InventorySummary;
import us.xwhite.dvd.service.InventoryService;

/**
 *
 * @author Joel Crosswhite <joel.crosswhite@ix.netcom.com>
 */
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK)
@ActiveProfiles("test")
public class InventoryControllerTest {

    @Autowired
    InventoryController controller;

    MockMvc mockMvc;

    @Before
    public void setUp() {
        controller.setInventoryService(mock(InventoryService.class));

        mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
    }

    @Test
    public void getAllInStockVideos() throws Exception {

        List<InventorySummary> expectedResult = new ArrayList<>();
        InventorySummary inventory1 = new InventorySummary("ALL THE ROSES", "Drama", 4L);
        expectedResult.add(inventory1);

        when(controller.getInventoryService().getInStockInventory(1L)).thenReturn(expectedResult);

        mockMvc.perform(MockMvcRequestBuilders.get("/api/inventory?store=1").accept(MediaType.APPLICATION_JSON))
                // .andDo(print())
                .andExpect(status().isOk()).andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(jsonPath("$", hasSize(1)));

        verify(controller.getInventoryService(), atLeast(1)).getInStockInventory(1L);
    }
}
