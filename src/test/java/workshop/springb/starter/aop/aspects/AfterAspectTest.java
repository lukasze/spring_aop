package workshop.springb.starter.aop.aspects;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.fail;
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
    void after_methodsStartWithGr_OK() throws Exception {
        fail();
    }

    @Test
    @WithMockUser
    void after_methodsStartWithGr_EXCEPTION() throws Exception {
        fail();
    }
}