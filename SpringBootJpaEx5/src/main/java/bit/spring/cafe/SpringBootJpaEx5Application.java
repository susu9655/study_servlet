package bit.spring.cafe;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan({"*.controller","cafe.data"})

@EntityScan("cafe.data")
@EnableJpaRepositories("cafe.data")
public class SpringBootJpaEx5Application {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootJpaEx5Application.class, args);
	}

}
