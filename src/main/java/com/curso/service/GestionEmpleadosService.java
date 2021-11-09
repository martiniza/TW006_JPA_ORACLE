package com.curso.service;

import java.util.Date;
import java.util.Calendar;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import org.apache.derby.impl.tools.ij.Main;

import com.curso.dao.EmpleadoDAO;
import com.curso.dao.EmpleadoJPADAO;
import com.curso.entidades.Empleado;
import com.curso.entidades.Trabajo;

public class GestionEmpleadosService  {

	public void incrementarSalario(List<Empleado> lista, double incremento) {

		// obtengo EntityManager

		EntityManager em = EmpleadoJPADAO.factory.createEntityManager();

		EmpleadoDAO dao = new EmpleadoJPADAO(em);

		// inicio transacción
		EntityTransaction tx = em.getTransaction();
		try {
			tx.begin();
			
			for(Empleado aux: lista){
				aux.setSalary(aux.getCommPct() +incremento);
				dao.modificar(aux);
			}

			// el código aqui
			// hago varios cambios de varios empleados

			// commit o rollback
			tx.commit();
		} catch (Exception e) {
			tx.rollback();
		}
	}

	public void altaEmpleado(String nombre, String apellido,
			String Telefono, String idJob) {
		EntityManager em = EmpleadoJPADAO.factory.createEntityManager();
		EmpleadoDAO dao = new EmpleadoJPADAO(em);
		
		EntityTransaction tx = em.getTransaction();
		try {
			tx.begin();
			
			Trabajo trb = em.find(Trabajo.class, idJob);
			
			double salario = trb.getSalarioMin();
			
			Calendar cal = Calendar.getInstance(); 
			//cal.set(2021,Calendar.NOVEMBER, 1);
			Date fecha2 = cal.getTime();
	

			Empleado e = new Empleado(nombre, apellido, "email", Telefono, fecha2, 
					idJob,salario, 0.3d, 200, 10);

			dao.crear(e);
			
			// commit o rollback
			tx.commit();
		} catch (Exception e) {
			tx.rollback();
		}
		
		return;
		
	}
	
	public List<Empleado> getAllEmpleadoPorDpto(int idDepartamento){
		//Vamos a preparar una query que pregunte por los empleados 
		//dentro del departamento
		
		EntityManager em= EmpleadoJPADAO.factory.createEntityManager();
		
	
		Query query = em.createNamedQuery("Empleado.findAllByIdDept");
		
		query.setParameter("id", idDepartamento);
		
		
		return query.getResultList() ;
	}
	
	public void informeEmpleados() {
		EntityManager em = EmpleadoJPADAO.factory.createEntityManager();
		EmpleadoDAO dao = new EmpleadoJPADAO(em);
		
		List<Empleado> lista = dao.getAll();
		System.out.println("cosas");
		for(Empleado e:lista) {
			System.out.println(". "+ e.getId() + " " + e.getFirstName());
		}
		
	
	}
	
	
	public List<Empleado> getEmpleadosParaListar(){
		EntityManager em= EmpleadoJPADAO.factory.createEntityManager();		
		Query query = em.createNamedQuery("Empleado.findAllDatosBasicos");
			
		return query.getResultList() ;
		
	}
	
	public static void main(String[] args) {
		
		GestionEmpleadosService service = new GestionEmpleadosService();
		service.informeEmpleados();
		
		List<Empleado> empleadosDptoAdm = service.getAllEmpleadoPorDpto(10);
		
		for(Empleado e: empleadosDptoAdm) {
			System.out.println(". "+ e.getId() + " " + e.getFirstName());
		}
		
		System.out.println("___ lista empleados ___");
		
		List<Empleado> lista = service.getEmpleadosParaListar();
		
		for(Empleado e: lista) {
			System.out.println(". "+ e.getId() + " " + e.getFirstName() 
			+ " " + e.getLastName());
		}
	}
}
