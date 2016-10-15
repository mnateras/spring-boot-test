package mag.exam.config;

import java.util.concurrent.Executor;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

@Configuration
public class ThreadPoolsConfig {

	@Bean
	public Executor brainKidTaskExecutor() {
		return new ThreadPoolTaskExecutor();
	}

	@Bean
	public Executor runnerKidTaskExecutor() {
		return new ThreadPoolTaskExecutor();
	}

}
