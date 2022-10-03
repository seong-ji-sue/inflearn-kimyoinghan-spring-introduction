package hello.hellospring.service;

import hello.hellospring.domain.Person;
import hello.hellospring.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


public class PersonService {

    private final PersonRepository personRepository;

    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }


    /**
     * 회원가입
     * @param person
     * @return
     */
    public Long join(Person person) {
        validateDuplicatePerson(person);
        personRepository.save(person);
        return person.getId();
    }

    /**
     * 중복 회원 검증
     * person객체가 이미 있는지 확인
     * findByName으로 같은 Person 있는지 확인
     * 반환된 Optional 객체 값이 없다면 false
     * 있으면 이미 존제하는 회원 에러
     * @param person
     */
    private void validateDuplicatePerson(Person person) {
        personRepository.findByName(person.getName())
                        .ifPresent(m -> {
                            throw new IllegalStateException("이미 존재하는 회원입니다.");
                        });
    }

    /**
     * 전체 Person 조회
     */
    public List<Person> findPersons(){
        return personRepository.findAll();
    }

    /**
     * 특정 회원 조회
     */
    public Optional<Person> findOne(Long personId) {
        return personRepository.findByPerson(personId);
    }
}
