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

/*
    TODO 6 Test dla naszgo aspektu, zprzyjaźnijmuy się z znim, przechodząc po kolejnych punktach
 */

// 1 Klasyczna konfiguracja testu - podnisiemy kontekst Springa
@SpringBootTest
// Spring dostarczy instancji MockMvc
@AutoConfigureMockMvc
/*
     2
     Uruchomienie w profilu around (klasa ArroundAspect ma @Profile(AROUND))

     Uruchomienie aplikacji z profilem, alternatywne sposoby:
     application.properties: spring.profiles.active=around
     Konfiguracja Intellij:
     - przekaż flagę do JVM, 'VM options:' -Dspring.profiles.active=around
     - użyj opcji 'Active profiles:'  IntelliJ Ultimate
  */
@ActiveProfiles(AROUND)
class AroundAspectTest {

    // 3 Poniższa linia i metoda setOut pozwoli nam na odczytwyanie, co zalogowano do konsoli
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    @Autowired
    private MockMvc mockMvc;

    @BeforeEach
    void setOut() {
        System.setOut(new PrintStream(outContent));
    }

    /*
        4
        Junit: @Test, @DisplayName
        Spring: @WithMockUser - mamy spring-security w zależnościach (domyślnie włączone)
     */
    @Test
    @WithMockUser
    @DisplayName("@Around(\"workshop.springb.starter.aop.pointcuts.AppPointcuts.methodsInServicePackage()\")")
    void around_methodsInServicePackage() throws Exception {

        /*
            5 Czego oczekujemy w System.out, z profilem 'around'
         */
        String expectedOut = AroundAspect.AROUND_BEFORE_MSG
                + System.lineSeparator()
                + AroundAspect.AROUND_AFTER_MSG
                + System.lineSeparator();

        /*
            6 Wywołaj endpoint
         */
        mockMvc.perform(MockMvcRequestBuilders.get("/greet")
                .contentType("application/json")
                .param("name", "X")
                .param("isFormal", "true"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.greeting").value("Hello, X!"));

        // 7 Sprawdzamy, czy aspekt zadziałał
        assertEquals(expectedOut, outContent.toString());
    }

    /*
        TODO 7 Za Tobą spora porcja informacj i koniec tego kroku! ._.)/\(._.

        W aop_step2_exercise_pl będziemy ćwiczyć, pisząc własne apsekty.

        W aop_step3_bugs_pl będziemy ćwiczyć, rozwiązując błędy w aplikacji.
     */
}

