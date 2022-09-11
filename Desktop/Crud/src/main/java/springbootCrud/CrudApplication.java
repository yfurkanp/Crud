package springbootCrud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
//@ComponentScan({"controller","service"}) // aradığını bulabilsin diye packageleri belirtiyorum.
//Temel olanlar bu şekilde (controller,service) .model gibiler alttaki gibi ;
//@EntityScan("model")
//@EnableJpaRepositories("repository")
public class CrudApplication {

	public static void main(String[] args) {
		SpringApplication.run(CrudApplication.class, args);
	}

}
