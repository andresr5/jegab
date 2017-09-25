package com.jegab.servicesImpl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.jegab.bean.BeanCategoria;
import com.jegab.persistenceDAO.CategoriaDAO;
import com.jegab.persistenceEntities.Categoria;

public class CategoriaServicesImpl {

	public static void crearCategoria(BeanCategoria beanCategoria) {
		CategoriaDAO categoriaDAO = new CategoriaDAO();
		int idCategoria = categoriaDAO.getLastIdCategoria();
		Categoria categoriaPersistence = new Categoria();
		categoriaPersistence.setIdCategoria(idCategoria + 1);
		categoriaPersistence.setNombre(beanCategoria.getNombre());
		categoriaPersistence.setDescripcion(beanCategoria.getDescripcion());
		categoriaDAO.persist(categoriaPersistence);
	}

	public static List<BeanCategoria> getAllCategoria() {
		CategoriaDAO categoriaDAO = new CategoriaDAO();

		List<BeanCategoria> listaCategorias = new ArrayList<BeanCategoria>();
		List<Categoria> categoriaPersistenceList = new ArrayList<Categoria>();
		categoriaPersistenceList = categoriaDAO.getAllcategoria();
		for (Iterator iterator = categoriaPersistenceList.iterator(); iterator.hasNext();) {
			BeanCategoria beanCategoria = null;
			Categoria categoria = (Categoria) iterator.next();
			beanCategoria = new BeanCategoria();
			beanCategoria.setIdCategoria(categoria.getIdCategoria());
			beanCategoria.setNombre(categoria.getNombre());
			beanCategoria.setDescripcion(categoria.getDescripcion());
			listaCategorias.add(beanCategoria);

		}
		return listaCategorias;
	}
	
	
	public static void updateCategoria(BeanCategoria categoria) {
		CategoriaDAO categoriaDAO = new CategoriaDAO();
		Categoria categoriaPersistence = new Categoria();
		categoriaPersistence.setIdCategoria(categoria.getIdCategoria());
		categoriaPersistence.setNombre(categoria.getNombre());
		categoriaPersistence.setDescripcion(categoria.getDescripcion());
		categoriaDAO.attachDirty(categoriaPersistence);
		
	}
}
