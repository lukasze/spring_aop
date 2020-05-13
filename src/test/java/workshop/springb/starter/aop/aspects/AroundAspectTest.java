package workshop.springb.starter.aop.aspects;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static workshop.springb.starter.aop.Constans.AROUND;


@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles(AROUND)
class AroundAspectTest {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    @Autowired
    private MockMvc mockMvc;

    @BeforeEach
    void setOut() {
        System.setOut(new PrintStream(outContent));
    }

    @Test
    @WithMockUser
    @DisplayName("@Around(\"workshop.springb.starter.aop.pointcuts.AppPointcuts.methodsInServicePackage()\") OK")
    void around_methodsInServicePackage_OK() throws Exception {

        String expectedOut = AroundAspect.AROUND_BEFORE_MSG
                + System.lineSeparator()
                + AroundAspect.AROUND_AFTER_MSG
                + System.lineSeparator();

        mockMvc.perform(MockMvcRequestBuilders.get("/greet")
                .contentType("application/json")
                .param("name", "X")
                .param("isFormal", "true"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.greeting").value("Hello, X!"));

        assertEquals(expectedOut, outContent.toString());
    }

    @Test
    @WithMockUser
    @DisplayName("@Around(\"workshop.springb.starter.aop.pointcuts.AppPointcuts.methodsInServicePackage()\") EXCEPTION")
    void around_methodsInServicePackage_EXCEPTION() throws Exception {

        String expectedOut = AroundAspect.AROUND_BEFORE_MSG
                + System.lineSeparator()
                + AroundAspect.AROUND_AFTER_MSG
                + " "
                + Exception.class.getSimpleName()
                + System.lineSeparator();

        mockMvc.perform(MockMvcRequestBuilders.get("/greet")
                .contentType("application/json")
                .param("name", "ex")
                .param("isFormal", "true"))
                .andExpect(status().is5xxServerError())
                .andExpect(jsonPath("$.err").value("Probably request's param 'name' has an 'ex' value :)"));

        assertEquals(expectedOut, outContent.toString());
    }

}

