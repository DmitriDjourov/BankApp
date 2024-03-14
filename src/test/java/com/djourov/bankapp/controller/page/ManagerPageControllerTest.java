package com.djourov.bankapp.controller.page;

import com.djourov.bankapp.entity.Manager;
import com.djourov.bankapp.service.impl.ManagerServiceImpl;
import com.djourov.bankapp.util.EntityCreator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.boot.autoconfigure.security.servlet.UserDetailsServiceAutoConfiguration;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@AutoConfigureMockMvc
@RunWith(SpringRunner.class)
@WebMvcTest(controllers = ManagerPageController.class,
        excludeAutoConfiguration = {
                UserDetailsServiceAutoConfiguration.class, SecurityAutoConfiguration.class
        })
@DisplayName("ManagerPageController test class")
class ManagerPageControllerTest {
    @Autowired
    ManagerPageController managerPageController;

    @MockBean
    private ManagerServiceImpl managerService;

    @Autowired
    private MockMvc mockMvc;

    @Test
    @WithMockUser(username = "admin", password = "111", roles = {"ADMIN"})
    void getAllManagersPageTest() throws Exception {
        List<Manager> managers = new ArrayList<>();
        managers.add(EntityCreator.getManager());
        when(managerService.getAllManagers()).thenReturn(managers);
        mockMvc.perform(get("/pages/manager/managers"))
                .andExpect(status().isOk()) // 200
                .andExpect(view().name("managers"))
                .andExpect(model().attributeExists("managersForModel"))
                .andExpect(model().attribute("managersForModel", managers));
    }

    @Test
    @WithMockUser(username = "admin", password = "111", roles = {"ADMIN"})
    void getManagerByIdPageTest() throws Exception {
        Manager manager = EntityCreator.getManager();
        when(managerService.getManagerById(manager.getId())).thenReturn(manager);
        mockMvc.perform(get("/pages/manager/" + manager.getId()))
                .andExpect(status().isOk())
                .andExpect(view().name("manager"))
                .andExpect(model().attributeExists("managerByIdForModel"))
                .andExpect(model().attribute("managerByIdForModel", manager));
    }
}
