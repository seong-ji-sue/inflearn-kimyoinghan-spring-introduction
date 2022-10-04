package hello.hellospring.repository;

import hello.hellospring.domain.Person;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Optional;

public class JpaPersonRepository implements PersonRepository {
    private EntityManager em;

    public JpaPersonRepository(EntityManager em) {
        this.em = em;
    }

    @Override
    public Person save(Person person) {
        em.persist(person);
        return person;
    }

    @Override
    public Optional<Person> findByPerson(Long id) {
        Person person = em.find(Person.class, id);
        return Optional.ofNullable(person);
    }

    @Override
    public Optional<Person> findByName(String name) {
        String sql = "select p from Person p where p.name= :name";
        List<Person> result = em.createQuery(sql,Person.class)
                .setParameter("name",name).getResultList();
        return result.stream().findAny();

    }

    @Override
    public Optional<Person> findByAge(Integer age) {
        return Optional.empty();
    }

    @Override
    public List<Person> findAll() {
        String sql = "select p from Person p";
        return em.createQuery(sql, Person.class).getResultList();
    }
}
