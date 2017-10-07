package com.jegab.servicesImpl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import com.jegab.bean.BeanCategoria;
import com.jegab.persistenceDAO.CategoriaDAO;
import com.jegab.persistenceEntities.Categoria;

public class CategoriaServicesImpl {

	static CategoriaDAO categoriaDAO = null;
	
	
	
	public static void crearCategoria(BeanCategoria beanCategoria) {
		
			if(categoriaDAO == null) {
				categoriaDAO =  new CategoriaDAO();				
			}
		
		 
		int idCategoria = categoriaDAO.getLastIdCategoria();
		Categoria categoriaPersistence = new Categoria();
		categoriaPersistence.setIdCategoria(idCategoria + 1);
		categoriaPersistence.setNombre(beanCategoria.getNombre());
		categoriaPersistence.setDescripcion(beanCategoria.getDescripcion());
		categoriaDAO.persist(categoriaPersistence);
	}

	public static List<BeanCategoria> getAllCategoria() {

		if(categoriaDAO == null) {
			categoriaDAO =  new CategoriaDAO();				
		}
	

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
		if(categoriaDAO == null) {
			categoriaDAO =  new CategoriaDAO();				
		}
	
		Categoria categoriaPersistence = new Categoria();
		categoriaPersistence.setIdCategoria(categoria.getIdCategoria());
		categoriaPersistence.setNombre(categoria.getNombre());
		categoriaPersistence.setDescripcion(categoria.getDescripcion());
		categoriaDAO.attachDirty(categoriaPersistence);
		
	}
	
	
	public static Map<String,String> getAllCategoriaMap(){
		if(categoriaDAO == null) {
			categoriaDAO =  new CategoriaDAO();				
		}
	
		 Map<String,String> categoriaList = new HashMap<String,String>();
         List<Categoria> categoriaPersistenceList = new ArrayList<Categoria>();	 
		 categoriaPersistenceList = categoriaDAO.getAllcategoria();
		 for (Iterator iterator = categoriaPersistenceList.iterator(); iterator.hasNext();) {
			BeanCategoria beanCategoria = null;
			Categoria categoriaPersistence = (Categoria) iterator.next();
			beanCategoria = new BeanCategoria();
			beanCategoria.setIdCategoria(categoriaPersistence.getIdCategoria());
			beanCategoria.setNombre(categoriaPersistence.getNombre());
			beanCategoria.setDescripcion(categoriaPersistence.getDescripcion());
			System.out.println("this is categoria ------------------->  "+beanCategoria);
			categoriaList.put(beanCategoria.getNombre(),beanCategoria.getIdCategoria()+"");
		}
         return categoriaList;
	}
}
