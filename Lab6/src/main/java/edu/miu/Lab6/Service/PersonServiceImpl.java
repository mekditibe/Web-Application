package edu.miu.Lab6.Service;

import edu.miu.Lab6.Person.Person;
import edu.miu.Lab6.Person.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class PersonServiceImpl implements PersonService{

    @Autowired
    private PersonRepository personRepository;

    @Override
    public Flux<Person> findAllByName(String name) {
        return personRepository.findAllByName(name);
    }

    @Override
    public Flux<Person> findAllPerson() {
        return personRepository.findAll();
    }

    @Override
    public Mono<Person> save(Person person) {
        return personRepository.save(person);
    }

    @Override
    public Mono<Person> findPersonById(Integer id) {
        return personRepository.findPersonById(id);
    }

    @Override
    public Mono<Person> deletePersonById(Integer id) {
        return personRepository.deletePersonById(id);
    }
}
