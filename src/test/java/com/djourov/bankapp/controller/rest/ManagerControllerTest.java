package com.djourov.bankapp.controller.rest;

import com.djourov.bankapp.dto.ManagerDTO;
import com.djourov.bankapp.entity.Manager;
import com.djourov.bankapp.entity.enums.ManagerStatus;
import com.djourov.bankapp.service.impl.ManagerServiceImpl;
import com.djourov.bankapp.util.DtoCreator;
import com.djourov.bankapp.util.EntityCreator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@AutoConfigureMockMvc
@RunWith(SpringRunner.class)
@WebMvcTest(ManagerController.class)
@DisplayName("ManagerController test class")
class ManagerControllerTest {

    @Autowired
    ManagerController managerController;

    @MockBean
    private ManagerServiceImpl managerService;

//    @Autowired
//    private ObjectMapper objectMapper;

    @Autowired
    private MockMvc mockMvc;

    //    @Mock
//    private ManagerRepository managerRepository = Mockito.mock(ManagerRepository.class);
    private final Manager manager = EntityCreator.getManager();

    @Test
    void getAllManagersTest() throws Exception {
        List<Manager> managers = new ArrayList<>();
        managers.add(manager);
        when(managerService.getAllManagers()).thenReturn(managers);
        mockMvc.perform(get("/app/manager/managers"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(1)))
                .andExpect(jsonPath("$[0].id").value(manager.getId().toString()))
                .andExpect(jsonPath("$[0].firstName").value(manager.getFirstName()))
                .andExpect(jsonPath("$[0].lastName").value(manager.getLastName()))
                .andExpect(jsonPath("$[0].status").value(manager.getStatus().toString()))
                .andExpect(jsonPath("$[0].createdAt").value(manager.getCreatedAt().toString()))
                .andExpect(jsonPath("$[0].updatedAt").value(manager.getUpdatedAt().toString()));
    }

    @Test
    void getManagerByIdFirstLastNameTest() throws Exception {
        ManagerDTO managerDTO = DtoCreator.getManagerDTO();
        when(managerService.getManagerByIdFirstLastName(manager.getId())).thenReturn(managerDTO);
        mockMvc.perform(get("/app/manager/first_last_name/{id}", manager.getId()))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.firstName", is(managerDTO.getFirstName())))
                .andExpect(jsonPath("$.lastName", is(managerDTO.getLastName())))
                .andExpect(jsonPath("$.createdAt", is(managerDTO.getCreatedAt().toString())))
                .andExpect(jsonPath("$.status", is(managerDTO.getStatus().toString())))
                .andExpect(jsonPath("$.clients", hasSize(managerDTO.getClients().size())));
    }

    @Test
    void getManagerByIdTest() throws Exception {
        when(managerService.getManagerById(manager.getId())).thenReturn(manager);
        mockMvc.perform(get("/app/manager/{id}", manager.getId()))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id", is(manager.getId().toString())))
                .andExpect(jsonPath("$.firstName", is(manager.getFirstName())))
                .andExpect(jsonPath("$.lastName", is(manager.getLastName())))
                .andExpect(jsonPath("$.status", is(manager.getStatus().toString())))
                .andExpect(jsonPath("$.createdAt", is(manager.getCreatedAt().toString())))
                .andExpect(jsonPath("$.updatedAt", is(manager.getUpdatedAt().toString())));
    }

    @Test
    void postCreateManagerTest() throws Exception {
        Manager newManager = new Manager();
        newManager.setFirstName("Patrik");
        newManager.setLastName("Krolikoff");
        newManager.setStatus(ManagerStatus.SENIOR_MANAGER);
        System.out.println("=====================" + newManager);

/**
 * {
 *     "timestamp": "2024-02-27T19:34:42.031+00:00",
 *     "status": 415,
 *     "error": "Unsupported Media Type",
 *     "trace": "org.springframework.web.HttpMediaTypeNotSupportedException: Content-Type 'application/json;charset=UTF-8' is not supported\r\n\tat org.springframework.web.servlet.mvc.method.annotation.AbstractMessageConverterMethodArgumentResolver.readWithMessageConverters(AbstractMessageConverterMethodArgumentResolver.java:213)\r\n\tat org.springframework.web.servlet.mvc.method.annotation.RequestResponseBodyMethodProcessor.readWithMessageConverters(RequestResponseBodyMethodProcessor.java:159)\r\n\tat org.springframework.web.servlet.mvc.method.annotation.RequestResponseBodyMethodProcessor.resolveArgument(RequestResponseBodyMethodProcessor.java:134)\r\n\tat org.springframework.web.method.support.HandlerMethodArgumentResolverComposite.resolveArgument(HandlerMethodArgumentResolverComposite.java:122)\r\n\tat org.springframework.web.method.support.InvocableHandlerMethod.getMethodArgumentValues(InvocableHandlerMethod.java:218)\r\n\tat org.springframework.web.method.support.InvocableHandlerMethod.invokeForRequest(InvocableHandlerMethod.java:171)\r\n\tat org.springframework.web.servlet.mvc.method.annotation.ServletInvocableHandlerMethod.invokeAndHandle(ServletInvocableHandlerMethod.java:118)\r\n\tat org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter.invokeHandlerMethod(RequestMappingHandlerAdapter.java:917)\r\n\tat org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter.handleInternal(RequestMappingHandlerAdapter.java:829)\r\n\tat org.springframework.web.servlet.mvc.method.AbstractHandlerMethodAdapter.handle(AbstractHandlerMethodAdapter.java:87)\r\n\tat org.springframework.web.servlet.DispatcherServlet.doDispatch(DispatcherServlet.java:1089)\r\n\tat org.springframework.web.servlet.DispatcherServlet.doService(DispatcherServlet.java:979)\r\n\tat org.springframework.web.servlet.FrameworkServlet.processRequest(FrameworkServlet.java:1014)\r\n\tat org.springframework.web.servlet.FrameworkServlet.doPost(FrameworkServlet.java:914)\r\n\tat jakarta.servlet.http.HttpServlet.service(HttpServlet.java:590)\r\n\tat org.springframework.web.servlet.FrameworkServlet.service(FrameworkServlet.java:885)\r\n\tat jakarta.servlet.http.HttpServlet.service(HttpServlet.java:658)\r\n\tat org.apache.catalina.core.ApplicationFilterChain.internalDoFilter(ApplicationFilterChain.java:205)\r\n\tat org.apache.catalina.core.ApplicationFilterChain.doFilter(ApplicationFilterChain.java:149)\r\n\tat org.apache.tomcat.websocket.server.WsFilter.doFilter(WsFilter.java:51)\r\n\tat org.apache.catalina.core.ApplicationFilterChain.internalDoFilter(ApplicationFilterChain.java:174)\r\n\tat org.apache.catalina.core.ApplicationFilterChain.doFilter(ApplicationFilterChain.java:149)\r\n\tat org.springframework.web.filter.RequestContextFilter.doFilterInternal(RequestContextFilter.java:100)\r\n\tat org.springframework.web.filter.OncePerRequestFilter.doFilter(OncePerRequestFilter.java:116)\r\n\tat org.apache.catalina.core.ApplicationFilterChain.internalDoFilter(ApplicationFilterChain.java:174)\r\n\tat org.apache.catalina.core.ApplicationFilterChain.doFilter(ApplicationFilterChain.java:149)\r\n\tat org.springframework.web.filter.FormContentFilter.doFilterInternal(FormContentFilter.java:93)\r\n\tat org.springframework.web.filter.OncePerRequestFilter.doFilter(OncePerRequestFilter.java:116)\r\n\tat org.apache.catalina.core.ApplicationFilterChain.internalDoFilter(ApplicationFilterChain.java:174)\r\n\tat org.apache.catalina.core.ApplicationFilterChain.doFilter(ApplicationFilterChain.java:149)\r\n\tat org.springframework.web.filter.CharacterEncodingFilter.doFilterInternal(CharacterEncodingFilter.java:201)\r\n\tat org.springframework.web.filter.OncePerRequestFilter.doFilter(OncePerRequestFilter.java:116)\r\n\tat org.apache.catalina.core.ApplicationFilterChain.internalDoFilter(ApplicationFilterChain.java:174)\r\n\tat org.apache.catalina.core.ApplicationFilterChain.doFilter(ApplicationFilterChain.java:149)\r\n\tat org.apache.catalina.core.StandardWrapperValve.invoke(StandardWrapperValve.java:167)\r\n\tat org.apache.catalina.core.StandardContextValve.invoke(StandardContextValve.java:90)\r\n\tat org.apache.catalina.authenticator.AuthenticatorBase.invoke(AuthenticatorBase.java:482)\r\n\tat org.apache.catalina.core.StandardHostValve.invoke(StandardHostValve.java:115)\r\n\tat org.apache.catalina.valves.ErrorReportValve.invoke(ErrorReportValve.java:93)\r\n\tat org.apache.catalina.core.StandardEngineValve.invoke(StandardEngineValve.java:74)\r\n\tat org.apache.catalina.connector.CoyoteAdapter.service(CoyoteAdapter.java:340)\r\n\tat org.apache.coyote.http11.Http11Processor.service(Http11Processor.java:391)\r\n\tat org.apache.coyote.AbstractProcessorLight.process(AbstractProcessorLight.java:63)\r\n\tat org.apache.coyote.AbstractProtocol$ConnectionHandler.process(AbstractProtocol.java:896)\r\n\tat org.apache.tomcat.util.net.NioEndpoint$SocketProcessor.doRun(NioEndpoint.java:1744)\r\n\tat org.apache.tomcat.util.net.SocketProcessorBase.run(SocketProcessorBase.java:52)\r\n\tat org.apache.tomcat.util.threads.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:1191)\r\n\tat org.apache.tomcat.util.threads.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:659)\r\n\tat org.apache.tomcat.util.threads.TaskThread$WrappingRunnable.run(TaskThread.java:61)\r\n\tat java.base/java.lang.Thread.run(Thread.java:1623)\r\n",
 *     "message": "Content-Type 'application/json;charset=UTF-8' is not supported.",
 *     "path": "/app/manager/createManager"
 * }
 */
//        when(managerRepository.save(any(Manager.class))).thenReturn(manager);
//        Manager newManager = managerService.postCreateManager(manager);
//        Assertions.assertNotNull(newManager.getId());

//        String jsonBody = objectMapper.writeValueAsString(manager);
//        mockMvc.perform(post("/app/manager/createManager")
//                                .contentType(MediaType.APPLICATION_JSON)
//                                .content(jsonBody));


//        Manager manager = new Manager();
//        manager.setFirstName("Patrik");
//        manager.setLastName("Krolikoff");
//        manager.setStatus(ManagerStatus.CREDIT_MANAGER);
//
//        Manager createdManager = new Manager();
//        createdManager.setId(UUID.randomUUID());
//        createdManager.setFirstName("Patrik");
//        createdManager.setLastName("Krolikoff");
//        createdManager.setStatus(ManagerStatus.CREDIT_MANAGER);

//       when(managerService.postCreateManager(any(Manager.class))).thenReturn(createdManager);
//        mockMvc.perform(MockMvcRequestBuilders.post("/app/manager/createManager")
//                .contentType(MediaType.APPLICATION_JSON)
//                .content(objectMapper.writeValueAsString(manager)))
//                .andExpect(MockMvcResultMatchers.status().isOk());
//                .andExpect(MockMvcResultMatchers.jsonPath("$.id").exists())
//                .andExpect(MockMvcResultMatchers.jsonPath("$.firstName").value("Patrik"))
//                .andExpect(MockMvcResultMatchers.jsonPath("$.lastName").value("Krolikoff"))
//                .andExpect(MockMvcResultMatchers.jsonPath("$.status").value("CREDIT_MANAGER"));
    }

    @Test
    void deleteManagerByIdTest() throws Exception {
        when(managerService.deleteById(manager.getId())).thenReturn(manager);
        mockMvc.perform(delete("/app/manager/del/{id}", manager.getId()))
                .andExpect(status().isOk());
    }

    @Test
    void updateManagerStatusSeniorByIdTest() throws Exception {
        when(managerService.updateManagerStatusSeniorById(manager.getId())).thenReturn(manager);
        mockMvc.perform(put("/app/manager/upd/manager_status_senior/{id}", manager.getId()))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id", is(manager.getId().toString())))
                .andExpect(jsonPath("$.status", is(manager.getStatus().toString())));
    }
}