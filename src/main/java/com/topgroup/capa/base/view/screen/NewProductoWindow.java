package com.topgroup.capa.base.view.screen;

import com.topgroup.capa.base.business.service.PracticeServiceMockImpl;
import com.topgroup.capa.base.domain.model.Producto;
import com.topgroup.capa.base.domain.model.TipoProducto;
import com.topgroup.capa.base.view.components.TypesCombo;
import com.vaadin.data.Validator;
import com.vaadin.data.validator.RegexpValidator;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickListener;
import com.vaadin.ui.ComboBox;
import com.vaadin.ui.FormLayout;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.TextField;
import com.vaadin.ui.Window;

public class NewProductoWindow extends Window {

	private static final long serialVersionUID = 1L;

	private TextField codigo = new TextField("Codigo");
	private TextField descripcion  = new TextField("Descripcion");
	private ComboBox tipoProducto= new TypesCombo(); 
	private TextField productosPorPaquete= new TextField("Descripcion");

	@SuppressWarnings("serial")
	public NewProductoWindow(final PracticeServiceMockImpl practiceService) {
		super("Nuevo producto");
		setModal(true);
		this.setWidth("350px");
		this.setHeight("280px");

		FormLayout content = new FormLayout();

		codigo.setRequired(true);
		codigo.setRequiredError("Este campo es obligatorio");
		content.addComponent(codigo);

		descripcion.setRequired(true);
		descripcion.setRequiredError("Este campo es obligatorio");
		content.addComponent(descripcion);

		Validator pppValidator = new RegexpValidator("^[0-9]+", "Debe ser un numero");
		productosPorPaquete.addValidator(pppValidator);
		content.addComponent(productosPorPaquete);

		tipoProducto.setCaption("Tipo de producto");
		content.addComponent(tipoProducto);

		Button cancelar = new Button("Cancelar");
		cancelar.addListener(new ClickListener() {
			@Override
			public void buttonClick(com.vaadin.ui.Button.ClickEvent event) {
				close();
			}
		});

		Button aceptar = new Button("Aceptar");
		aceptar.addListener(new ClickListener() {
			@Override
			public void buttonClick(com.vaadin.ui.Button.ClickEvent event) {
				Producto nuevo = new Producto();
				nuevo.setCodigo(codigo.getValue().toString());
				nuevo.setDescripcion(descripcion.getValue().toString());
				nuevo.setTipoProducto((TipoProducto) tipoProducto.getValue());
				nuevo.setProductosPorPaquete(Short.valueOf(productosPorPaquete.getValue().toString()));
				practiceService.save(nuevo);
				close();
			}
		});

		HorizontalLayout botones = new HorizontalLayout();

		botones.addComponent(aceptar);
		botones.addComponent(cancelar);
		botones.setSpacing(true);
		botones.setHeight("30px");
		addComponent(content);
		addComponent(botones);
	}

}
