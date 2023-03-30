package edu.miu.Lab6.Service;

import edu.miu.Lab6.Person.Person;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface PersonService {

    Flux<Person> findAllByName(String name);
    Flux<Person> findAllPerson();
    Mono<Person> save(Person person);
    Mono<Person> findPersonById(Integer id);
    Mono<Person> deletePersonById(Integer id);
}
