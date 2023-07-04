package br.edu.univas.si7.process.customer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import br.edu.univas.si7.topicos.process.entity.ProcessEntity;
import br.edu.univas.si7.topicos.process.repository.ProcessRepository;

@SpringBootApplication
public class ProcessApp implements CommandLineRunner {

	@Autowired
	private ProcessRepository repo;
	
	public static void main(String[] args) {
		SpringApplication.run(ProcessApp.class, args);
	}
	
	@Override
	public void run(String... args) throws Exception {
		ProcessEntity process01 = new ProcessEntity("1", "responsavel 01", "03-07-2023", 
				"90", "100", true);
		ProcessEntity process02 = new ProcessEntity("2", "responsavel 02", "30-06-2023", 
				"30", "50", true);
		repo.save(process01);
		repo.save(process02);
	}

}
