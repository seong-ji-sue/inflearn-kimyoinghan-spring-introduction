package hello.hellospring.controller;

import hello.hellospring.domain.Person;
import hello.hellospring.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller //빈생성
public class PersonController {
    private  final PersonService personService;

    @Autowired //의존성 주입
    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @PostMapping( "/person/new")
    @ResponseBody
    public Person create(@RequestParam("name") String name,@RequestParam("age") Integer age) {
        Person person = new Person();
        person.setName(name);
        person.setAge(age);
        personService.join(person);

        return person;
    }

    @GetMapping("/persons")
    @ResponseBody
    public List list() {
        List<Person> persons = personService.findPersons();
        return persons;
    }


}
