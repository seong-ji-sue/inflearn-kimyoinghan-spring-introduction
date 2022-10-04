package hello.hellospring;
import hello.hellospring.repository.*;
import hello.hellospring.service.PersonService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.persistence.EntityManager;
import javax.sql.DataSource;
@Configuration
public class SpringConfig {

    private final DataSource dataSource;
    private final EntityManager em;

    public SpringConfig(DataSource dataSource, EntityManager em) {
        this.dataSource = dataSource;
        this.em = em;
    }

    @Bean
    public PersonService personService() {
        return new PersonService(personRepository());
    }

    @Bean
    public PersonRepository personRepository(){
        //return new MemoryPersonRepository();
        //return new JdbcTemplatePersonRepository(dataSource);
        return new JpaPersonRepository(em);
    }
}
