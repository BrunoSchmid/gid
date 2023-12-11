package br.com.gid.controllers;

import java.text.ParseException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.gid.entities.Trabalho;
import br.com.gid.entities.TrabalhoDET;
import br.com.gid.entities.TrabalhoHIST;
import br.com.gid.services.TrabalhoService;

@RestController
@RequestMapping("/api/trabalhos")
public class TrabalhoController {

	@Autowired
	TrabalhoService trabalhoService;
	
	@GetMapping(value = "",  produces = MediaType.APPLICATION_JSON_VALUE)
	public Page<Trabalho> findAll(
		@RequestParam(required = false, defaultValue = "0") int offset, 
		@RequestParam(required = false, defaultValue = "10") int limit,
		@RequestParam(required = false) String arquivo,
		@RequestParam(required = false) String dtRec
	) throws ParseException {

		return trabalhoService.findAll(offset, limit, arquivo, dtRec);
	}
	
	@GetMapping(value = "/{trabalhoId}",  produces = MediaType.APPLICATION_JSON_VALUE)
	public Trabalho findById(
		@PathVariable("trabalhoId") int trabalhoId
	) {
		//CONFIGURAR PAGINAÇÃO
		return trabalhoService.findById(trabalhoId);
	}
	
	@GetMapping(value = "/det/{trabalhoId}",  produces = MediaType.APPLICATION_JSON_VALUE)
	public Page<TrabalhoDET> findAllDet(
		@PathVariable("trabalhoId") int trabalhoId,
		@RequestParam(required = false, defaultValue = "0") int offset, 
		@RequestParam(required = false, defaultValue = "10") int limit
	) {
		return trabalhoService.getAllDet(trabalhoId, offset, limit);
	}
	
	@GetMapping(value = "/hist",  produces = MediaType.APPLICATION_JSON_VALUE)
	public Page<TrabalhoHIST> findAllHist(
		@RequestParam(required = false, defaultValue = "0") int offset, 
		@RequestParam(required = false, defaultValue = "10") int limit
	) {
		//CONFIGURAR PAGINAÇÃO
		return trabalhoService.getAllHist(offset, limit);
	}
}