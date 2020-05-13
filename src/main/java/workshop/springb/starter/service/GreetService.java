package workshop.springb.starter.service;

import org.springframework.stereotype.Service;
import workshop.springb.starter.model.Response;
import workshop.springb.starter.repository.ResponseRepository;
import workshop.springb.starter.service.subservice.GreetSubservice;

@Service
public class GreetService {

    private final ResponseRepository repository;
    private final GreetSubservice subservice;

    public GreetService(ResponseRepository repository, GreetSubservice subservice) {
        this.repository = repository;
        this.subservice = subservice;
    }

    public Response greet(String name, boolean isFormal) throws Exception {
        Response response = subservice.greet(name, isFormal);
        return repository.save(response);
    }

}