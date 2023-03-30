package edu.miu.Lab6.Person;

import edu.miu.Lab6.Person.Person;
import org.springframework.data.mongodb.repository.Tailable;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Repository
public interface PersonRepository extends ReactiveCrudRepository<Person, Integer> {

    @Tailable
    Flux<Person> findAllByName(String name);
    @Tailable
    Flux<Person> findPersonByJob(String job);
    //Mono<Person> save(Person person);
    Mono<Person> findPersonById(Integer id);
    Mono<Person> deletePersonById(Integer id);


}
