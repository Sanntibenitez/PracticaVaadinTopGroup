package com.topgroup.capa.base.business.service;

import java.util.ArrayList;
import java.util.List;

import com.topgroup.capa.base.domain.model.Producto;
import com.topgroup.capa.base.domain.model.TipoProducto;
import com.topgroup.capa.base.persistence.filter.ProductoFilter;

public class PracticeServiceMockImpl implements PracticeService  {

	private List<Producto> productos = null;
	List<TipoProducto> tipos = null;

	@Override
	public List<Producto> filter(ProductoFilter filter) {
		ProductoFilter pFilter = (ProductoFilter) filter;
		List<Producto> allProductos = findAll();
		List<Producto> productos = new ArrayList<>();
		for (Producto p : allProductos) {
			if ((pFilter.getCodigo() == null || p.getCodigo().startsWith(
					pFilter.getCodigo()))
					&& (pFilter.getIdTipoProducto() == null || p
							.getTipoProducto().getId()
							.equals(pFilter.getIdTipoProducto()))) {
				productos.add(p);
			}
		}
		return productos;
	}

	@Override
	public List<Producto> findAll() {
		if (productos == null) {
			productos = new ArrayList<>();

			List<TipoProducto> tipos = findAllTipoProductos();

			for (long i = 1; i < 100; i++) {
				Producto prod = new Producto();
				prod.setId(i);
				prod.setCodigo("Prod" + i);
				prod.setDescripcion("Producto destinado " + i);
				prod.setTipoProducto(i % 2 == 0 ? tipos.get(0) : tipos.get(1));
				productos.add(prod);

			}
		}
		return productos;
	}

	@Override
	public List<TipoProducto> findAllTipoProductos() {
			tipos = new ArrayList<>();

			for (long i = 1; i < 10; i++) {
				TipoProducto tp1 = new TipoProducto();
				tp1.setId(i);
				tp1.setDescripcion("Tipo de producto " + i);
				tipos.add(tp1);

			}
		return tipos;
	}

	@Override
	public long count(ProductoFilter filter) {
		return filter(filter).size();
	}


	@Override
	public void save(Producto bean) {
		List<Producto> prod = findAll();
		if (!prod.contains(bean)) {
			prod.add(bean);
		}else{
			prod.remove(bean);
			prod.add(bean);
		}
	}

}
