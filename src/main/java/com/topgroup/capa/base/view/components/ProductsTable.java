package com.topgroup.capa.base.view.components;

import java.util.List;

import com.topgroup.capa.base.business.service.PracticeServiceMockImpl;
import com.topgroup.capa.base.domain.model.Producto;
import com.vaadin.data.util.BeanItemContainer;
import com.vaadin.ui.Table;

public class ProductsTable extends Table{

	private static final long serialVersionUID = 1L;

	public ProductsTable() {

		PracticeServiceMockImpl ps = new PracticeServiceMockImpl();
		List<Producto> productos = ps.findAll();

		BeanItemContainer<Producto> p = new BeanItemContainer<Producto>(Producto.class);
		p.addNestedContainerProperty("tipoProducto.descripcion");
		p.addAll(productos);

		this.setContainerDataSource(p);
		this.setVisibleColumns(new String[] { "codigo", "descripcion","tipoProducto.descripcion" });
		this.setColumnHeaders(new String[] { "Codigo", "Descripcion", "Tipo de Producto" });
		this.setColumnCollapsingAllowed(true);
		this.setSelectable(true);
		this.setWidth("100%");
		this.setPageLength(10);
	}
}
