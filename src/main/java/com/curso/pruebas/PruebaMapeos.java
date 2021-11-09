package com.curso.pruebas;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import com.curso.dao.EmpleadoJPADAO;
import com.curso.entidades.Customer;
import com.curso.entidades.Orders;
import com.curso.entidades.Record;

public class PruebaMapeos {
	
	public static void main(String[] args) {
	
		
		EntityManager em = EmpleadoJPADAO.factory.createEntityManager();
		
		EntityTransaction tx =em.getTransaction();
		
//		tx.begin();
		
//		//CREAR UN NUEVO REGISTRO (con un persist)
//		
//		Record rec = new Record();
//		
//		rec.setRecordName("Registro 1");
//		
//		em.persist(rec); //Persistir el registro. 
		
		// CREAR UN NUEVO CLIENTE CON EL REGISTRO ANTERIOR
			// hay que arreglar lo de la fecha
//		
//		Customer cliente = new Customer();
//		cliente.setCustomerName("Raul Salinas");
//		cliente.setRecord(rec);
//		
//		em.persist(cliente); //Persistir el cliente
//		
//		tx.commit();
		
	
		//BUSCAR LA ID DEL CLIENTE EN LA BD
		
		Customer cliente2 = em.find(Customer.class, 4);
		if (cliente2 == null) {
			System.out.println("no existe");
			
		}else {
			System.out.println("Cliente: " + cliente2.getCustomerName() + 
					" record: " + cliente2.getRecord().getRecordName());
		}
		
		Record r = em.find(Record.class, 3);
		
		if (r!= null) {
			System.out.println("record " + r.getRecordName());
			System.out.println("Cliente " + r.getCliente().getCustomerName());
			
		}
		
		/**
		 * EJEMPLO DE MAPEO ONE TO MANY/MANY TO ONE
		 */
		
		//Crear dos pedidos para el Cliente id 4
		
		tx.begin();
		
		Customer c4 = em.find(Customer.class, 4);
		
//		if (c4 != null) {
//			//hago pedido
//			Orders o1= new Orders();
//			
//			o1.setCustomer(c4);
//			o1.setDescription("Pedido zapatos");
//			em.persist(o1);
//			
//			Orders o2= new Orders();
//			
//			o2.setCustomer(c4);
//			o2.setDescription("Pedido libros");
//			em.persist(o2);
//		}
		
		for(Orders e: c4.getOrdersCollection()) {
			
			System.out.println("pedido: " + e.getDescription());
		}
		
		tx.commit();
		
		
		
		//---------------------------------------------------------------
		
//		Customer cliente = em.find(Customer.class, 1);
//		if (cliente == null) {
//			System.out.println("no existe");
//			
//		}
		
		
		
	}

}
