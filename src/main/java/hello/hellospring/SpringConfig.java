package hello.hellospring;
import hello.hellospring.repository.*;
import hello.hellospring.service.PersonService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import javax.persistence.EntityManager;
import javax.sql.DataSource;
@Configuration
public class SpringConfig {
    @Bean
    public PersonService personService() {
        return new PersonService(personRepository());
    }

    @Bean
    public PersonRepository personRepository(){
        return new MemoryPersonRepository();
    }
}
