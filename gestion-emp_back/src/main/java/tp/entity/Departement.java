package tp.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Departement {
  
	@Id
	@GeneratedValue (strategy=GenerationType.AUTO)
	private long	idDepart ;
	private String departnom ;


	
	
	
	
	
	
	
	public Departement() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Departement(long idDepart, String departnom) {
		super();
		this.idDepart = idDepart;
		this.departnom = departnom;
	}
	public long getIdDepart() {
	return idDepart;
}
public void setIdDepart(long idDepart) {
	this.idDepart = idDepart;
}
public String getDepartnom() {
	return departnom;
}
public void setDepartnom(String departnom) {
	this.departnom = departnom;
}
@Override
public String toString() {
	return "Departement [idDepart=" + idDepart + ", departnom=" + departnom + "]";
}
  
  


	
}
