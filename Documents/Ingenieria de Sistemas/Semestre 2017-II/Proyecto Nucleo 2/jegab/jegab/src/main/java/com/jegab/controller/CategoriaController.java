package com.jegab.controller;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import com.jegab.bean.BeanCategoria;
import com.jegab.persistenceDAO.CategoriaDAO;
import com.jegab.persistenceEntities.Categoria;
import com.jegab.servicesImpl.CategoriaServicesImpl;

@ManagedBean(name="categoriaController")
@ViewScoped
public class CategoriaController {
	
	
	private static BeanCategoria categoria = new BeanCategoria();
	private List<BeanCategoria> categoriaList;
	
	
	public  BeanCategoria getCategoria() {
		return categoria;
	}

	public  void setCategoria(BeanCategoria categoria) {
		CategoriaController.categoria = categoria;
	}

	public List<BeanCategoria> getCategoriaList() {
		return categoriaList;
	}

	public void setCategoriaList(List<BeanCategoria> categoriaList) {
		this.categoriaList = categoriaList;
	}

	@PostConstruct
	public void init(){
		categoriaList = CategoriaServicesImpl.getAllCategoria();
	}
	
	public static String crearCategoria(BeanCategoria categoria) {
		CategoriaServicesImpl.crearCategoria(categoria);
		return "crearCategoria.xhtml?faces-redirect=true";
	}
	
	public static void updateCategoria(){
		CategoriaServicesImpl.updateCategoria(categoria);
	}
	
}
