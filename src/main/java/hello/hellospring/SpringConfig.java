package hello.hellospring;
import hello.hellospring.repository.*;
import hello.hellospring.service.PersonService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import javax.sql.DataSource;
@Configuration
public class SpringConfig {

    private final DataSource dataSource;

    public SpringConfig(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Bean
    public PersonService personService() {
        return new PersonService(personRepository());
    }

    @Bean
    public PersonRepository personRepository(){
        //return new MemoryPersonRepository();
        return new JdbcTemplatePersonRepository(dataSource);
    }
}
