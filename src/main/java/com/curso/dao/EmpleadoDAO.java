package com.curso.dao;

import com.curso.entidades.Empleado;

/**
 * Implementa las operaciones CRUD
 * 
 * create
 * read
 * update
 * delete
 * 
 * @author Cuack
 *
 *
 *RECUERDA: 
 *Todos los metodos son public y abstract en la interfaz
 */

public interface EmpleadoDAO  {
	
	Empleado crear(Empleado e);
	//que te entregue el ID del empleado, que se consigue de la BD
	
	void modificar(Empleado e);
	
	void borrar(int id);	

	Empleado getById(int id);
	
	// List<Empleado> getAll();
	//Este falta. 
}
