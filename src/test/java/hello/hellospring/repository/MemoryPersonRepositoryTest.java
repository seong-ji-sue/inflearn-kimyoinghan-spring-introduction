package hello.hellospring.repository;

import hello.hellospring.domain.Person;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Test 코드는 given when then 형식으로 작성한다.
 */
class MemoryPersonRepositoryTest {
    MemoryPersonRepository repository = new MemoryPersonRepository();

    @AfterEach
    public void afterEach() {
        repository.clearStore();
    }

    @Test
    void save() {
        //given - person 객체 생성
        Person person = new Person();
        person.setName("JS");
        person.setAge(20);

        //when - 테이블에 Person 데이터 저장
        repository.save(person);

        //then - 생성한 Person 객체와 데이터에 넣은 Person 객체가 같은지 체크
        Person result = repository.findByPerson(person.getId()).get();
        Assertions.assertThat(result).isEqualTo(person);

    }

    @Test
    void findByPerson() {

    }

    @Test
    void findByName() {
        //given
        Person person1 = new Person();
        person1.setName("JS");
        person1.setAge(20);
        repository.save(person1);

        Person person2 = new Person();
        person2.setName("JS");
        person2.setAge(43);
        repository.save(person2);

        //when
        Person result = repository.findByName("JS").get();

        //then
        Assertions.assertThat(result).isEqualTo(person1);
    }

    @Test
    void findByAge() {
    }

    @Test
    void findAll() {
        Person person1 = new Person();
        person1.setName("JS");
        person1.setAge(20);
        repository.save(person1);

        Person person2 = new Person();
        person2.setName("JS");
        person2.setAge(43);
        repository.save(person2);

        List<Person> result = repository.findAll();

        Assertions.assertThat(result.size()).isEqualTo(2);
    }
}