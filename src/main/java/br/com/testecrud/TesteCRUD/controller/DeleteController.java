package br.com.testecrud.TesteCRUD.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Classe de controle de mapeamento para solicitações DELETE
 */
@RestController
@RequestMapping(produces = "application/json")
public class DeleteController {

	@DeleteMapping(path = "/")
	public String x() {
		return "{\"message\": \"DELETED!\"}";
	}

}