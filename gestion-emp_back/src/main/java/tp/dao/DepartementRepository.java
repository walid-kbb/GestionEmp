package tp.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import tp.entity.Departement;
import tp.entity.Employe;
@Repository
public interface DepartementRepository extends JpaRepository <Departement,Long>
{
	
	
	@Query("select e from Employe e join Departement d on e.departement.idDepart=d.idDepart where d.departnom = ?1")
	List<Employe> findByDepname(String depnom);
	
	
}
