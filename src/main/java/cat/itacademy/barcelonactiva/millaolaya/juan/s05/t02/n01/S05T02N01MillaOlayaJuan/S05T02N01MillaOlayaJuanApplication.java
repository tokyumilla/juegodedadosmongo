package cat.itacademy.barcelonactiva.millaolaya.juan.s05.t02.n01.S05T02N01MillaOlayaJuan;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableMongoRepositories
public class S05T02N01MillaOlayaJuanApplication {

	public static void main(String[] args) {
		SpringApplication.run(S05T02N01MillaOlayaJuanApplication.class, args);
	}

}
