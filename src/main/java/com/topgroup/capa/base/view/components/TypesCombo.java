package com.topgroup.capa.base.view.components;

import java.util.List;

import com.topgroup.capa.base.business.service.PracticeServiceMockImpl;
import com.topgroup.capa.base.domain.model.TipoProducto;
import com.vaadin.data.util.BeanItemContainer;
import com.vaadin.ui.ComboBox;

public class TypesCombo extends ComboBox {

	private static final long serialVersionUID = 1L;

	public TypesCombo() {

		PracticeServiceMockImpl practiceService = new PracticeServiceMockImpl();

		List<TipoProducto> type = practiceService.findAllTipoProductos();

		BeanItemContainer<TipoProducto> cont = new BeanItemContainer<TipoProducto>(TipoProducto.class);
		cont.addAll(type);

		this.setContainerDataSource(cont);

		this.setItemCaptionPropertyId("descripcion");

	}

}
