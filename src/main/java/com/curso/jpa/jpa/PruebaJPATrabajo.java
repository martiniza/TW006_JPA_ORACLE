package com.curso.jpa.jpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.curso.entidades.Trabajo;

public class PruebaJPATrabajo {
	
	private static EntityManager em;
	
	
	
	
	public static void main(String[] args) {
		
		//inicializamos el em. 
		
		EntityManagerFactory factory = 
				Persistence.createEntityManagerFactory("OracleHRPU");
		
		//Crear la factoria lleva mucho trabajo, solo se hace una vez
		//por aplicacion. 
		
		em = factory.createEntityManager(); //lee en persistence.xml
											//datos de conexion y entidades
		
		
		//Recuperar un Job para el id(llave primaria) 'AD PRES'
		
		Trabajo t = em.find(Trabajo.class, "AD_PRES");
		
		
		if(t != null) {System.out.println(t);}
		else
		{System.out.println("el trabajo con esa ID no existe.");}
		
		//devuelve un objeto Trabajo entero. 
		//find devuelve null si no lo encuentra. 
		
		
		//t esta anexadoa la tabla JOBS
		
		EntityTransaction tx = em.getTransaction(); // Esto hace que se anexe. 
		tx.begin();
		t.setTitulo("Presidente");
		tx.commit();
		
		//INSERTAR UN NUEVO TRABAJO
		
//		Trabajo tNew = new Trabajo("DES", "Desarrollo", 24000,50000);
//		
//		EntityTransaction tx = em.getTransaction();
//		tx.begin(); //Forzar el commit
//		em.persist(tNew);
//		
		
		tx.commit();
		
		
		// Ejemplo no anexado (no-attached)
		//20080, 40000
		
//		Trabajo presi = new Trabajo("AD_PRES","Presidente",0,0);
		
		//MODIFICAR DATOS
		//MODO 1
		
//		tx.begin();
//		
//		Trabajo tBD = em.find(Trabajo.class, presi.getIdTrabajo());
//		tBD.setSalarioMax(presi.getSalarioMax());
//		tBD.setSalarioMin(presi.getSalarioMin());
//		
//		tx.commit();
		
		//MODO 2
		// usando em.merge()
		
		tx.begin();
		
		//HR aun no esta anexado
		Trabajo hr = new Trabajo("HR_REP","Representante_RRHH",4500,10000);
		
		//
		
		Trabajo hrBD = em.merge(hr);
		/**
		 * Coge los datos asignados a hr y los vuelca
		 */

		
		hrBD.setSalarioMax(45000); //si sinc con la base de datos
		tx.commit();
		
		
		//BORRAR DATOS
		tx.begin();
		
		Trabajo tBorrar =new Trabajo("HR_REP","Representante_RRHH",4500,10000);
//			Trabajo tBorrar = em.find(Trabajo.class,"DES");
		em.remove(tBorrar);	
		
		tx.commit();
		
		
	}

}
