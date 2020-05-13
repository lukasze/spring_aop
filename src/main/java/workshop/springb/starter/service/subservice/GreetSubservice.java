package workshop.springb.starter.service.subservice;

import org.springframework.stereotype.Component;
import workshop.springb.starter.aop.anotations.Loggable;
import workshop.springb.starter.model.Response;

import java.time.LocalDateTime;

@Component
@Loggable
public class GreetSubservice {

    public Response greet(String name, boolean isFormal) throws Exception {
        if (name.equals("ex")) {
            throw new Exception("ex passed as name param!");
        }
        return new Response(String.format("%s, %s!", greetCalculation(isFormal), name), LocalDateTime.now());
    }

    private String greetCalculation(boolean isFormal) {
        return isFormal ? "Hello" : "Hi";
    }
}
