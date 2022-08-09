package com.accenture.academico.g3bank.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.accenture.academico.g3bank.entity.Agencia;
import com.accenture.academico.g3bank.service.AgenciaService;

import io.swagger.annotations.ApiOperation;

@Controller
@RestController
@RequestMapping(path = "/g3bank")
public class AgenciaController {
	

	@Autowired
	private AgenciaService agenciaService;
	
	 @RequestMapping(value = "/agencia", method = RequestMethod.GET)
	 @ApiOperation(value="Retorna uma lista de agências")
	    public ResponseEntity<List<Agencia>> Get() {
		 	List<Agencia> agencias = agenciaService.searchAll();
	        return ResponseEntity.ok().body(agencias);
	    }
	 
	 @RequestMapping(value = "/agencia/{id}", method = RequestMethod.GET)
	 @ApiOperation(value="Retorna uma agência única")
	    public ResponseEntity<Agencia> GetById(@PathVariable(value = "id") Long id)
	    {
	       Agencia agencia = agenciaService.search(id);
	       
	       if (agencia == null) {
				return ResponseEntity.notFound().build();
			}
	       else {
	    	   return ResponseEntity.ok().body(agencia);
	       }
	    }
	 
	 @RequestMapping(value = "/agencia", method =  RequestMethod.POST)
	 @ApiOperation(value="Salva uma agência")
	    public  ResponseEntity<Agencia> Post(@Valid @RequestBody Agencia agencia)
	    {
		 
		 Agencia newAgencia = agenciaService.save(agencia);
		 return ResponseEntity.ok().body(newAgencia);
	    }
	 
	 @RequestMapping(value = "/agencia/{id}", method =  RequestMethod.PUT)
	 @ApiOperation(value="Atualiza uma agência")
	    public ResponseEntity<Agencia> Put(@PathVariable(value = "id") Long id, @Valid @RequestBody Agencia newAgencia)
	    {
	        
	            Agencia agencia = agenciaService.search(id);
	            agencia.setEnderecoAgencia(newAgencia.getEnderecoAgencia());
	            agencia.setTelefoneAgencia(newAgencia.getTelefoneAgencia());
	            agencia = agenciaService.save(agencia);
	            
		        return ResponseEntity.ok().body(agencia);
	        }

	   @RequestMapping(value = "/agencia/{id}", method = RequestMethod.DELETE)
	   @ApiOperation(value="Deleta uma agência")
	    public ResponseEntity<Object> Delete(@PathVariable(value = "id") Long id)
	    {
		   agenciaService.delete(id);
		   return ResponseEntity.noContent().build();
	    }
}
