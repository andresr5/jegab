package com.jegab.servicesImpl;

import javax.faces.bean.ApplicationScoped;

import com.jegab.bean.BeanCategoria;
import com.jegab.bean.BeanProducto;
import com.jegab.persistenceDAO.CategoriaDAO;
import com.jegab.persistenceDAO.ProductoDAO;
import com.jegab.persistenceEntities.Categoria;
import com.jegab.persistenceEntities.Producto;

@ApplicationScoped
public class ProductoServicesImpl {
     
	private static ProductoDAO productoDAO =null;
	private static CategoriaDAO categoriaDAO = null;

	
	
	public static void crearProducto(BeanProducto beanProducto, String idCategoria){
		if(productoDAO == null) {
			productoDAO =  new ProductoDAO();				
		}
		
		if(categoriaDAO == null) {
			categoriaDAO =  new CategoriaDAO();				
		}

		System.out.println(" idcategoria ------> "+idCategoria);
		Categoria categoriaPersistence = categoriaDAO.findById(Integer.parseInt(idCategoria));
		
		Producto productoPersistence = new Producto();
		int idProducto = productoDAO.getLastIdProducto(); 
		productoPersistence.setIdProducto(idProducto);
		productoPersistence.setNombre(beanProducto.getNombre());
		productoPersistence.setDescripcion(beanProducto.getNombre());
		productoPersistence.setPrecio(beanProducto.getPrecio());
		productoPersistence.setCategoria(categoriaPersistence);
		productoDAO.persist(productoPersistence);
	}
}
