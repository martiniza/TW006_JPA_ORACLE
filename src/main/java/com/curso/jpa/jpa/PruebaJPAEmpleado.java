package com.curso.jpa.jpa;

import java.util.Calendar;
import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.curso.dao.EmpleadoDAO;
import com.curso.entidades.Empleado;

public class PruebaJPAEmpleado implements EmpleadoDAO {

	private static EntityManagerFactory factory;

	public static void main(String[] args) {

//		EntityManagerFactory factory = 
//				Persistence.createEntityManagerFactory("OracleHRPU");
//	
//	
//		em = factory.createEntityManager();
//		
//		Empleado empleado = em.find(Empleado.class, "EMPLOYEE");
		
		
		//java util Date
		//2021 - 1900 // 0-11 //
		Date fecha = new Date(121,10,1); //fecha contratacion
		
		//Calendar
		
		Calendar cal = Calendar.getInstance(); 
		cal.set(2021,Calendar.NOVEMBER, 1);
		Date fecha2 = cal.getTime();
		
	}
}
