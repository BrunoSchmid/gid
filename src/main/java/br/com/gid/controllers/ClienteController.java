package br.com.gid.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.gid.entities.Cliente;
import br.com.gid.services.ClienteService;

@RestController
@RequestMapping("/api/clientes")
public class ClienteController {

	@Autowired
	ClienteService clienteService;
	
	@GetMapping(value = "", produces = MediaType.APPLICATION_JSON_VALUE)
	public Page<Cliente> findAll(
		@RequestParam(required = false, defaultValue = "0") int offset, 
		@RequestParam(required = false, defaultValue = "10") int limit
	) {
		//CONFIGURAR PAGINAÇÃO
		return clienteService.getAll(offset, limit);
	}
}
