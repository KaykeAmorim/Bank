package com.accenture.academico.g3bank.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.accenture.academico.g3bank.entity.Cliente;
import com.accenture.academico.g3bank.entity.Conta;
import com.accenture.academico.g3bank.entity.Extrato;
import com.accenture.academico.g3bank.service.ContaService;
import com.accenture.academico.g3bank.service.ExtratoService;

import io.swagger.annotations.ApiOperation;

@Controller
@RequestMapping
public class ExtratoController {
	
	@Autowired
	private ExtratoService extratoService;
	
	@Autowired
	private ContaService contaService;
	
	@RequestMapping(value = "/extrato/{id}", method = RequestMethod.GET)
	@ApiOperation(value="Retorna um extrato único")
	public ResponseEntity<List<Extrato>> GetById(@PathVariable(value = "id") Long id)
    {
		Conta conta = contaService.search(id);
		List<Extrato> extratos = extratoService.search(conta);
       
       if (extratos == null) {
			return ResponseEntity.notFound().build();
		}
       else {
    	   return ResponseEntity.ok().body(extratos);
       }
    }
	
	@RequestMapping(value = "/extratos/{id}", method = RequestMethod.GET)
	@ApiOperation(value="Retorna um extrato único")
	    public ModelAndView get(@PathVariable(value = "id") Long id) {
		Conta conta = contaService.search(id);
		List<Extrato> extratos = extratoService.search(conta);
		
		ModelAndView modelAndView = new ModelAndView("extrato");
		modelAndView.addObject("extratos", extratos);
		modelAndView.addObject("conta", conta);
		
		return modelAndView;
	}

}
