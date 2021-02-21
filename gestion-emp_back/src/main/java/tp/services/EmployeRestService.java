package tp.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import tp.dao.DepartementRepository;
import tp.dao.EmployeRepository;
import tp.entity.Departement;
import tp.entity.Employe;
@CrossOrigin(origins = "*")
@RestController
public class EmployeRestService {
	
	@Autowired
	EmployeRepository employeRepository;
	@Autowired
	DepartementRepository departRepository ;
	
	@GetMapping("/employeName/{nom}")
	public List<Employe> getEmployesByName(@PathVariable("nom") String nom){
		return employeRepository.findByName(nom.toLowerCase());
	}
	
	@GetMapping("/employeName_like/{nom}")
	public List<Employe> getEmployesByName2(@PathVariable("nom") String nom){
		return employeRepository.findByName2(nom.toLowerCase());
	}
	
	
	@GetMapping("/list")
	public List<Employe> getEmployezes(){
		return employeRepository.findAll();
	}
	
	@GetMapping("/employe/{id}")
	public Employe getEmployee(@PathVariable("id") long id){
		return employeRepository.findById(id).get();
	}
	
	
	
	
	
	@PutMapping("/update/{id}")
	public Employe updateEmploye(@PathVariable("id") long id, @RequestBody Employe emp){
		emp.setId(id);
		/*emp.setNom(emp.getNom().toLowerCase());
		emp.setPrenom(emp.getPrenom().toLowerCase());
		emp.setAdressMail(emp.getAdressMail().toLowerCase());*/
		return employeRepository.save(emp);
	}
	
	@PostMapping("/add")
	public Employe addEmploye(@RequestBody Employe emp){
		/*emp.setNom(emp.getNom().toLowerCase());
		emp.setPrenom(emp.getPrenom().toLowerCase());
		emp.setAdressMail(emp.getAdressMail().toLowerCase());*/
		return employeRepository.save(emp);
	}
	
	
	
	@PostMapping("/add_depart/{nbremp}/{nbrdep}")
	public void addDepart(@PathVariable("nbremp") int nbremp,@PathVariable("nbrdep") int nbrdep)
	{
		int k=0 ;
		int nbr=nbremp/nbrdep;
		for(int i=0;i<nbrdep;i++)
		{
			Departement depart = new Departement();
			depart.setDepartnom("depart"+i);
			departRepository.save(depart);
			for(int j=0 ; j<nbr;j++)
			{
				Employe emp= new Employe();
				emp.setNom("nome"+k);
				emp.setPrenom("prenom"+k);
				emp.setAdressMail("adress"+k);
				k++ ;
				emp.setDepartement(depart);
				employeRepository.save(emp);
			}
			
		}
		/*emp.setNom(emp.getNom().toLowerCase());
		emp.setPrenom(emp.getPrenom().toLowerCase());
		emp.setAdressMail(emp.getAdressMail().toLowerCase());*/
		
		
	}
	
	
	
	@GetMapping("/emp_depart/{depnom}")
	public List<Employe> getEmployesByDepname(@PathVariable("depnom") String depnom){
		return departRepository.findByDepname(depnom.toLowerCase());
	}
	
	
	
	
	@DeleteMapping("/delete/{id}")
	public void deleteEmploye(@PathVariable("id") long id){
		employeRepository.deleteById(id);
	}

	public static void main(String[] args) {
		
	}

}
