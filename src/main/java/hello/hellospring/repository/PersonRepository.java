package hello.hellospring.repository;

import hello.hellospring.domain.Person;

import java.util.List;
import java.util.Optional;

public interface PersonRepository {

    Person save(Person person);
    Optional<Person> findByPerson(Long id);
    Optional<Person> findByName(String name);
    Optional<Person> findByAge(Integer age);
    List<Person> findAll();
}
