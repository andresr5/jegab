package com.jegab.controller;

import java.util.Map;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import com.jegab.bean.BeanProducto;
import com.jegab.servicesImpl.CategoriaServicesImpl;
import com.jegab.servicesImpl.ProductoServicesImpl;


@ManagedBean(name="productoController")
@ViewScoped
public class ProductoController {
	
	private static String categoriaSelectOneValue;
	private Map<String, String> categoriaList;

	
	

	
	public  String getCategoriaSelectOneValue() {
		return categoriaSelectOneValue;
	}

	public  void setCategoriaSelectOneValue(String categoriaSelectOneValue) {
		this.categoriaSelectOneValue = categoriaSelectOneValue;
	}

	public Map<String, String> getCategoriaList() {
		return categoriaList;
	}

	public void setCategoriaList(Map<String, String> categoriaList) {
		this.categoriaList = categoriaList;
	}
	
	@PostConstruct
	public void init(){
		categoriaList = CategoriaServicesImpl.getAllCategoriaMap();
	}
	
	
	public static String crearProducto(BeanProducto beanProducto){
		String idCategoria = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap()
				.get("j_idt6:productods_input");
		System.out.println(FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap());
		ProductoServicesImpl.crearProducto(beanProducto,idCategoria);
		return null;
	}
	
	
	
}
