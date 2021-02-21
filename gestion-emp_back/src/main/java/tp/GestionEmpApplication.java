package tp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import tp.dao.EmployeRepository;
import tp.entity.Employe;

@SpringBootApplication
public class GestionEmpApplication implements CommandLineRunner {

	@Autowired
	EmployeRepository employeRepository ;
	
	public static void main(String[] args) {
		SpringApplication.run(GestionEmpApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
	}
}
