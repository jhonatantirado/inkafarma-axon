package pe.edu.unmsm.upg.inkafarma;

import java.util.concurrent.Executors;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import reactor.core.scheduler.Scheduler;
import reactor.core.scheduler.Schedulers;

@SpringBootApplication
public class InkafarmaAxonApplication {
	@Value("${spring.datasource.maximum-pool-size}")
	private int connectionPoolSize;
	
	public static void main(String[] args) {
		SpringApplication.run(InkafarmaAxonApplication.class, args);
	}
	
	@Bean
	public Scheduler jdbcScheduler() {
		return Schedulers.fromExecutor(Executors.newFixedThreadPool(connectionPoolSize));
	}

}