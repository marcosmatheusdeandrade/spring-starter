package br.mma.rest;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import br.mma.entities.Pedido;
import br.mma.rest.dto.PedidoDTO;
import br.mma.service.PedidoService;

@RestController
@RequestMapping("/api/pedido")
public class PedidoController {

	private PedidoService pedidoService;
	
	private static final ResponseStatusException RESPONSE_STATUS_NOT_FOUND = new ResponseStatusException(HttpStatus.NOT_FOUND, "Produto não encontrado");
	
	public PedidoController(PedidoService pedidoService) {
		this.pedidoService = pedidoService;
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Integer save(@RequestBody PedidoDTO pedidoDTO) {
		Pedido pedido = pedidoService.save(pedidoDTO);
		return pedido.getId();
	}
}