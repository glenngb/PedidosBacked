package com.atarraya.controller;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

import java.io.IOException;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.mvc.ControllerLinkBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import com.atarraya.dto.PedidoDTO;
import com.atarraya.dto.PedidoListaProductoDTO;
import com.atarraya.dto.PedidoResumenDTO;
import com.atarraya.exception.ModeloNotFoundException;
import com.atarraya.model.Archivo;
import com.atarraya.model.Pedido;
import com.atarraya.service.IArchivoService;
import com.atarraya.service.IPedidoService;

@RestController
@RequestMapping("/pedidos")
public class PedidoController {

	@Autowired
	private IPedidoService service;

	@Autowired
	private IArchivoService serviceArchivo;

	@GetMapping
	public ResponseEntity<List<Pedido>> listar() {
		List<Pedido> lista = service.listar();
		return new ResponseEntity<List<Pedido>>(lista, HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Pedido> listarPorId(@PathVariable("id") Integer id) {
		Pedido obj = service.leerPorId(id);
		if (obj.getIdPedido() == null) {
			throw new ModeloNotFoundException("ID NO ENCONTRADO " + id);
		}
		return new ResponseEntity<Pedido>(obj, HttpStatus.OK);
	}

	@GetMapping(value = "/hateoas", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<PedidoDTO> listarHateoas() {
		List<Pedido> pedidos = new ArrayList<>();
		List<PedidoDTO> pedidosDTO = new ArrayList<>();
		pedidos = service.listar();

		for (Pedido p : pedidos) {
			PedidoDTO d = new PedidoDTO();
			d.setIdPedido(p.getIdPedido());
			d.setEmpleado(p.getEmpleado());

			ControllerLinkBuilder linkTo = linkTo(methodOn(PedidoController.class).listarPorId((p.getIdPedido())));
			d.add(linkTo.withSelfRel());
			pedidosDTO.add(d);

			ControllerLinkBuilder linkTo1 = linkTo(
					methodOn(EmpleadoController.class).listarPorId((p.getEmpleado().getIdEmpleado())));
			d.add(linkTo1.withSelfRel());
			pedidosDTO.add(d);
		}
		return pedidosDTO;
	}
	@PostMapping
	public ResponseEntity<Object> registrar(@Valid @RequestBody PedidoListaProductoDTO pedidoDTO) {
		Pedido obj = service.registrarTransaccional(pedidoDTO);
		
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getIdPedido()).toUri();
		return ResponseEntity.created(location).build();
	}
	
	@PutMapping
	public ResponseEntity<Pedido> modificar(@Valid @RequestBody Pedido pedido) {
		Pedido obj = service.modificar(pedido);
		return new ResponseEntity<Pedido>(obj, HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Object> eliminar(@PathVariable("id") Integer id){
		Pedido obj = service.leerPorId(id);
		if(obj.getIdPedido() == null) {
			throw new ModeloNotFoundException("ID NO ENCONTRADO " + id);
		}
		service.eliminar(id);
		return new ResponseEntity<Object>(HttpStatus.OK);
	}
	
	@GetMapping(value = "/listarResumen")
	public ResponseEntity<List<PedidoResumenDTO>> listarResumen() {
		List<PedidoResumenDTO> pedidos = new ArrayList<>();
		pedidos = service.listarResumen();
		return new ResponseEntity<List<PedidoResumenDTO>>(pedidos, HttpStatus.OK);
	}
	@GetMapping(value = "/generarReporte", produces = MediaType.APPLICATION_OCTET_STREAM_VALUE)
	public ResponseEntity<byte[]> generarReporte(){
		byte[] data = null;
		data = service.generarReporte();
		return new ResponseEntity<byte[]>(data, HttpStatus.OK);
	}
	@PostMapping(value = "/guardarArchivo", consumes = {MediaType.MULTIPART_FORM_DATA_VALUE})
	public ResponseEntity<Integer> guardarArchivo(@RequestParam("adjunto") MultipartFile file) throws IOException{
		int rpta = 0;
		Archivo ar = new Archivo();
		ar.setFiletype(file.getContentType());
		ar.setFilename(file.getName());
		ar.setValue(file.getBytes());
		
		rpta = serviceArchivo.guardar(ar);

		return new ResponseEntity<Integer>(rpta, HttpStatus.OK);	
	}
	
	@GetMapping(value = "/leerArchivo/{idArchivo}", produces = MediaType.APPLICATION_OCTET_STREAM_VALUE)
	public ResponseEntity<byte[]> leerArchivo(@PathVariable("idArchivo") Integer idArchivo) throws IOException {
				
		byte[] arr = serviceArchivo.leerArchivo(idArchivo); 

		return new ResponseEntity<byte[]>(arr, HttpStatus.OK);
	}
}
