package hello.hellospring.repository;

import hello.hellospring.domain.Person;
import org.springframework.stereotype.Repository;

import java.util.*;


public class MemoryPersonRepository implements PersonRepository {
    //저장소(가상 테이블)
    //Person 데이터 하나씩 저장
    //데이터 중복 방지를 위해 Map 사용
    private static Map<Long, Person> store = new HashMap<>();

    //테이블에 primary key
    private static long sequence = 0L;

    /**
     * Person 등록
     * @param person
     * @return
     */
    @Override
    public Person save(Person person) {
        person.setId(++sequence); //데이터 추가시 자동으로 증가
        store.put(person.getId(), person); //person 객체 id를 key, Person 객체를 value로 store(테이블에 저장)
        return person;
    }

    /**
     * 특정 Person 조회
     * @param id
     * @return
     */
    @Override
    public Optional<Person> findByPerson(Long id) {
        return Optional.ofNullable(store.get(id)); //id로 person 객체 반환 null 도 허용
    }

    /**
     * 이름에 해당하는 Person만 조회
     * @param name
     * @return
     */
    @Override
    public Optional<Person> findByName(String name) {
        //Person 데이터들 중에서 name이 같은 Person 하나만 리턴
        return store.values().stream()
                .filter(person -> person.getName().equals(name))
                .findAny();
    }

    /**
     * 나이에 해당하는 Person 만 조회
     * @param age
     * @return
     */
    @Override
    public Optional<Person> findByAge(Integer age) {
        return store.values().stream()
                .filter(person -> person.getAge().equals(age))
                .findAny();
    }

    /**
     * 데이터 전체 조회
     * @return
     */
    @Override
    public List<Person> findAll() {
        return new ArrayList<>(store.values()); // 모든 Person 데이터를 가져와서 List로 정렬함
    }

    /**
     * 테이블 초기화
     */
    public void clearStore() {
        store.clear();
    }
}
