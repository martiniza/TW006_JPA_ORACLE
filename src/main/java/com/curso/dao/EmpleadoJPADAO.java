package com.curso.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.curso.entidades.Empleado;

public class EmpleadoJPADAO implements EmpleadoDAO
{
	public static EntityManagerFactory factory;
	private EntityManager em; // Este no se puede hacer estatico
	
	
	static {
		factory= Persistence.createEntityManagerFactory("OracleHRPU");
	}
	
	
	public EmpleadoJPADAO(EntityManager em) {
		this.em = em;
	}
	

	public Empleado crear(Empleado e) {
	
		em.persist(e);
		return e; //devuelvo e con el nuevo id autogenerado
	}

	public void modificar(Empleado e) {
		Empleado eBD = em.find(Empleado.class, e.getId());
		em.merge(e);
	if (eBD == null) {
		throw new RuntimeException("Empleado no existe");
	}
	}

	public void borrar(int id) {
		Empleado eBD = em.find(Empleado.class, id);
		em.remove(eBD);
	 //DELETE
	if (eBD == null) {
		throw new RuntimeException("Empleado no existe");
	}
		
	}

	public Empleado getById(int id) {
		Empleado eBD = em.find(Empleado.class, id);
		if (eBD == null) {
			throw new RuntimeException("Empleado no existe");
		}else {	return eBD;}

	}


	public List<Empleado> getAll(){
		//consulta
//		String consulta = "SELECT e from Empleado e";
//		Query query = em.createQuery(consulta);
		
		Query query = em.createNamedQuery("Empleado.findAll");
		return query.getResultList(); 

		
		//DEVUELVE UNA COLECCION DE EMPLEADOS
		//SI NO HAY DEVUELVE UNA COLECCION VACIA
	}
	
	

}
