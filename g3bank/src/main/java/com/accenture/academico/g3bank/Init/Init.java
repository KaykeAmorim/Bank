package com.accenture.academico.g3bank.Init;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import com.accenture.academico.g3bank.entity.Agencia;
import com.accenture.academico.g3bank.entity.Conta;
import com.accenture.academico.g3bank.repository.AgenciaRepository;

@Component
public class Init implements ApplicationListener<ContextRefreshedEvent> {

	@Autowired
	AgenciaRepository agenciaRepo;

	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {
		Conta conta1 = new Conta(1, "12", 1.400, 123456);
		Agencia agencia = new Agencia(1, "G3Bank Centro", "Rua Osvaldo Cruz, 1999", "(19)9999-9999", 24);
		
		agencia.setContas(Arrays.asList(conta1));
		conta1.setAgencia(agencia);
		agenciaRepo.save(agencia);
	}
}
