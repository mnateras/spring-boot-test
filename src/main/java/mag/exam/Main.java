package mag.exam;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableAsync
public class Main {

	public static void main(final String[] args) {
		SpringApplication.run(Main.class, args);
	}

}