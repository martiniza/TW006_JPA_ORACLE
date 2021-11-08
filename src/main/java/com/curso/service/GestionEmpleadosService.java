package com.curso.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import com.curso.dao.EmpleadoDAO;
import com.curso.dao.EmpleadoJPADAO;
import com.curso.entidades.Empleado;
import com.curso.entidades.Trabajo;

public class GestionEmpleadosService {

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
		
		EntityTransaction tx = em.getTransaction();
		try {
			tx.begin();
			
			Trabajo trb = em.find(Trabajo.class, idJob);
			trb.getSalarioMin();
			

			// commit o rollback
			tx.commit();
		} catch (Exception e) {
			tx.rollback();
		}
		
		return;
		
	}
}
