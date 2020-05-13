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

    /*
        TODO 1
      ------------------------------------------------------------------------------------------------------------------
        Pora na napisanie i test pierwszego, własnego aspektu! \( ﾟヮﾟ)/

        Zanim to zrobimy małe wyjaśnienie - handleRuntimeExceptions jest tu po to, żebyśmy mogli testować nasze
        aspekty przy użyciu MockMvc.

        W przypadku, gdy będą rzucone wyjątki zwrócony zostanie status 500.
        Wyjątek może być rzucony z metody GreetSubservice#greet - gdy przekazane name ma wartość "ex";

        Dla przypomnienia:

        Before / After - zadziała bez względu na to, czy jest rzucony wyjątek
        Around#before  - zadziała bez względu na to, czy jest rzucony wyjątek
        Around#after  - zadziała bez względu na to, czy jest rzucony wyjątek (wyjątek musi być złapany)
        AfterReturning - zadziała tylko, gdy będzie wyjątek
        AfterThrowing - zadziała tylko, gdy nie będzie wyjątku
      ------------------------------------------------------------------------------------------------------------------
                                                      \
                                                       \
                                                     |\/\/\/|
                                                     |      |
                                                     |      |
                                                     | (o)(o)
                                                     C      _)
                                                      | ,___|
                                                      |   /
                                                     /____\
                                                    /      \

    */
    @ExceptionHandler(value = {Exception.class})
    protected ResponseEntity<String> handleRuntimeExceptions() {
        return new ResponseEntity<>("{\"err\":\"Probably request's param 'name' has an 'ex' value :)\"}", HttpStatus.INTERNAL_SERVER_ERROR);
    }

}