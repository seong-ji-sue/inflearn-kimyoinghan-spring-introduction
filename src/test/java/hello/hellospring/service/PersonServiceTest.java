package hello.hellospring.service;

import hello.hellospring.domain.Person;
import hello.hellospring.repository.MemoryPersonRepository;
import hello.hellospring.repository.PersonRepository;
import org.junit.jupiter.api.AfterEach;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class PersonServiceTest {

    PersonService personService;
    MemoryPersonRepository memoryPersonRepository;

    /**
     * 실행하기전에 repository service 객체 생성
     */
    @BeforeEach
    public void beforeEach() {
        memoryPersonRepository = new MemoryPersonRepository();
        personService = new PersonService(memoryPersonRepository);
    }

    /**
     * 실행 후 테이블 초기화
     */
    @AfterEach
    public void afterEach(){
        memoryPersonRepository.clearStore();
    }

    /**
     * 회원가입
     */
    @Test
    void join() {
        //given
        Person person = new Person();
        person.setName("JS");
        person.setAge(20);

        //when
        Long saveId = personService.join(person);

        //then
        Person findPerson = memoryPersonRepository.findByPerson(saveId).get();
        assertEquals(person.getName(),findPerson.getName());
    }

    /**
     * 중복회원
     */
    @Test
    public void 중복회원예외() {
        Person person1 = new Person();
        person1.setName("JS");
        person1.setAge(20);


        Person person2 = new Person();
        person2.setName("JS");
        person2.setAge(43);

        personService.join(person1);
        IllegalStateException e = assertThrows(IllegalStateException.class,
                () -> personService.join(person2));
        assertThat(e.getMessage()).isEqualTo("이미 존재하는 회원입니다.");


    }
}