package com.curso.entidades;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.curso.dao.EmpleadoDAO;


@Entity
@Table(name="EMPLOYEES")

@NamedQueries({
    @NamedQuery(name = "Empleado.findAll",  // convenio para localizar la query
        query = "SELECT e FROM Empleado e"),
    
    @NamedQuery(name = "Empleado.findAllByIdDept", 
    	query = "SELECT e FROM Empleado e WHERE e.depId = :id")
    , 
    @NamedQuery(name = "Empleado.findAllDatosBasicos", 
		query = "SELECT new com.curso.entidades.Empleado (e.id, e.firstName, e.lastName)"
    + "FROM Empleado e ") 

})
// :id es un parámetro
//ORDER BY id


public class Empleado implements  Serializable {
	
	//Atributos
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "CUST_SEQ")
	@SequenceGenerator(sequenceName = "EMPLOYEES_SEQ", 
	name = "CUST_SEQ", allocationSize=1)
	@Column(name = "EMPLOYEE_ID")
	
	private Long id;
	
	@Column(name = "FIRST_NAME")
	private String firstName;
	
	
	@Column(name = "LAST_NAME")
	private String lastName;
	
	@Column(name = "EMAIL")
	private String email;
	
	@Column(name = "PHONE_NUMBER")
	private String pNumber;
	
	@Column(name = "HIRE_DATE")
	private Date hireDate;
	
	@Column(name = "JOB_ID")
	private String jobId;
	
	@Column(name = "SALARY")
	private Double salary;
	
	@Column(name = "COMMISSION_PCT")
	private Double commPct;
	
	@Column(name = "MANAGER_ID")
	private Long mngId;
	
	@Column(name = "DEPARTMENT_ID")
	private Long depId;
	
	
	
	
	//CONSTRUCTORES


	public Empleado( String firstName, String lastName, String email, String pNumber, Date hireDate,
			String jobId, Double salary, Double commPct, Long mngId, Long depId) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.pNumber = pNumber;
		this.hireDate = hireDate;
		this.jobId = jobId;
		this.salary = salary;
		this.commPct = commPct;
		this.mngId = mngId;
		this.depId = depId;
	}
	
	
	

	public Empleado(Long id, String firstName, String lastName) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
	}




	public Empleado() {
		super();
	}
	
	// METODOS

	public Empleado crear(Empleado e) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public void moidificar(Empleado e) {
		// TODO Auto-generated method stub
		
	}

	public void borrar(int id) {
		// TODO Auto-generated method stub
		
	}

	public void getById(int id) {
		// TODO Auto-generated method stub
		
	}


	//getters y setters
	
	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getFirstName() {
		return firstName;
	}


	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}


	public String getLastName() {
		return lastName;
	}


	public void setLastName(String lastName) {
		this.lastName = lastName;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getpNumber() {
		return pNumber;
	}


	public void setpNumber(String pNumber) {
		this.pNumber = pNumber;
	}


	public Date getHireDate() {
		return hireDate;
	}


	public void setHireDate(Date hireDate) {
		this.hireDate = hireDate;
	}


	public String getJobId() {
		return jobId;
	}


	public void setJobId(String jobId) {
		this.jobId = jobId;
	}


	public Double getSalary() {
		return salary;
	}


	public void setSalary(Double salary) {
		this.salary = salary;
	}


	public Double getCommPct() {
		return commPct;
	}


	public void setCommPct(Double commPct) {
		this.commPct = commPct;
	}


	public Long getMngId() {
		return mngId;
	}


	public void setMngId(Long mngId) {
		this.mngId = mngId;
	}


	public Long getDepId() {
		return depId;
	}


	public void setDepId(Long depId) {
		this.depId = depId;
	}
	
	
	
	

}
