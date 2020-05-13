package workshop.springb.starter.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import workshop.springb.starter.model.Response;
import workshop.springb.starter.service.GreetService;

@RestController
public class GreetController {

    private final GreetService greetService;

    public GreetController(GreetService greetService) {
        this.greetService = greetService;
    }

    @GetMapping("/greet")
    public Response greet(@RequestParam(required = false, defaultValue = "World") String name,
                          @RequestParam boolean isFormal) throws Exception {
        return greetService.greet(name, isFormal);
    }


    @ExceptionHandler(value = {Exception.class})
    protected ResponseEntity<String> handleRuntimeExceptionss() {
        return new ResponseEntity<>("Probably request's param 'name' has an 'ex' value :)", HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
