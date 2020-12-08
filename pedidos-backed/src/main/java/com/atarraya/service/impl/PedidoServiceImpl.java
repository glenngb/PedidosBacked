package com.atarraya.service.impl;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;
import com.atarraya.dto.PedidoListaProductoDTO;
import com.atarraya.dto.PedidoResumenDTO;
import com.atarraya.model.Pedido;
import com.atarraya.repo.IPedidoRepo;
import com.atarraya.repo.IProductoPedidoRepo;
import com.atarraya.service.IPedidoService;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

@Service
public class PedidoServiceImpl implements IPedidoService {
	
	@Autowired
	private IPedidoRepo repo;
	
	@Autowired
	private IProductoPedidoRepo ppRepo;
	
	public Pedido registrar(Pedido obj) {
		obj.getDetallePedido().forEach(det -> {  //por cada consulta asignarle su detalle
			det.setPedido(obj);
		});
		return repo.save(obj);
		
	}
	
	@Transactional
	@Override
	public Pedido registrarTransaccional(PedidoListaProductoDTO dto) {
		dto.getPedido().getDetallePedido().forEach(det -> {
			det.setPedido(dto.getPedido());
		});
		repo.save(dto.getPedido());
		
		dto.getLstProducto().forEach(ex -> ppRepo.registrar(dto.getPedido().getIdPedido(), ex.getIdProducto()));
		
		return dto.getPedido();
	}	
	
	@Override
	public Pedido modificar(Pedido obj) {		
		return repo.save(obj);
	}

	@Override
	public List<Pedido> listar() {
		return repo.findAll();
	}

	@Override
	public Pedido leerPorId(Integer id) {
		Optional<Pedido> op = repo.findById(id);
		return op.isPresent() ? op.get() : new Pedido();
	}

	@Override
	public boolean eliminar(Integer id) {		
		repo.deleteById(id);
		return true;
		}
	
	@Override
	public List<PedidoResumenDTO> listarResumen() {
		List<PedidoResumenDTO> pedidos = new ArrayList<>();
		
		repo.listarResumen().forEach(x -> {
			PedidoResumenDTO pr = new PedidoResumenDTO();
			pr.setCantidad(Integer.parseInt(String.valueOf(x[0])));
			pr.setFecha(String.valueOf(x[1]));
			pedidos.add(pr);
		});
		return pedidos;
	}
	
	@Override
	public byte[] generarReporte() {
		byte[] data = null;
		
		try {
			File file = new ClassPathResource("/reports/consultas.jasper").getFile();
			JasperPrint print = JasperFillManager.fillReport(file.getPath(), null, new JRBeanCollectionDataSource(this.listarResumen()));
			data = JasperExportManager.exportReportToPdf(print);	
		} catch (Exception e) {
			e.printStackTrace();
		}
		return data;	
	}

}
