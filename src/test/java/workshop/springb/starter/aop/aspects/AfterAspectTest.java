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
import static workshop.springb.starter.aop.Constans.AFTER;

@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles(AFTER)
class AfterAspectTest {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    @Autowired
    private MockMvc mockMvc;

    @BeforeEach
    void setOut() {
        System.setOut(new PrintStream(outContent));
    }

    @Test
    @WithMockUser
    @DisplayName("@After(\"workshop.springb.starter.aop.pointcuts.AppPointcuts.methodsStartWithGr()\") OK")
    void after_methodsStartWithGr_OK() throws Exception {
        var expectedJoinpointKind = "method-execution";

        String expectedOut = AFTER + " " + expectedJoinpointKind
                + System.lineSeparator()
                + AFTER + " " + expectedJoinpointKind
                + System.lineSeparator()
                + AFTER + " " + expectedJoinpointKind
                + System.lineSeparator();

        final var resultActions = mockMvc.perform(MockMvcRequestBuilders.get("/greet")
                .contentType("application/json")
                .param("name", "X")
                .param("isFormal", "true"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.greeting").value("Hello, X!"))
                .andReturn();

        assertEquals(expectedOut, outContent.toString());
    }

    @Test
    @WithMockUser
    @DisplayName("@After(\"workshop.springb.starter.aop.pointcuts.AppPointcuts.methodsStartWithGr()\") EXCEPTION")
    void after_methodsStartWithGr_EXCEPTION() throws Exception {
        var expectedJoinpointKind = "method-execution";

        String expectedOut = AFTER + " " + expectedJoinpointKind
                + System.lineSeparator()
                + AFTER + " " + expectedJoinpointKind
                + System.lineSeparator()
                + AFTER + " " + expectedJoinpointKind
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