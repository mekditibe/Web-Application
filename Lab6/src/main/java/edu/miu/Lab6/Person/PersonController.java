package edu.miu.Lab6.Person;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

@RestController
//@RequestMapping("/persons")
public class PersonController {

    private PersonRepository personRepository;
    private int x = 1;

    @Autowired
    public PersonController(PersonRepository personRepository){
        this.personRepository=personRepository;
    }

//    @GetMapping(value = "/persons", produces= MediaType.TEXT_EVENT_STREAM_VALUE)
//    public Flux<Person> getAllPersons() {
//        savePerson();
//        return personRepository.findAll();
//    }
//@GetMapping(value = "/persons/{job}", produces= MediaType.TEXT_EVENT_STREAM_VALUE)
//public Flux<Person> getAllPersonByName(@PathVariable String name) {
//    return personRepository.findAllByName(name);
//}

    @GetMapping(value = "/persons/{job}", produces= MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<Person> getAllPersonByJob(@PathVariable String job) {
        return personRepository.findPersonByJob(job);
    }
    @Scheduled(fixedRate = 10)
    private void savePerson() {
        personRepository.save(new Person(x, "Frank Brown "+x,"Java Developer")).block();
        x++;
    }
}
