package tp.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import tp.entity.Employe;

@Repository
public interface EmployeRepository extends JpaRepository <Employe,Long>{
	
	@Query("select e from Employe e where e.nom = ?1")
	List<Employe> findByName(String nom);
	
	@Query("Select e from Employe e where e.nom like %:nom%")
	List<Employe> findByName2(String nom);
	


	
}
