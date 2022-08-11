package com.accenture.academico.g3bank.entity;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import com.accenture.academico.g3bank.enums.TipoConta;

public class EntityTest {
	 @Test
	 public void UserTest() {
		 	Conta conta1 = new Conta(null, "1234", TipoConta.CORRENTE, 1400.00);
	        Cliente cliente = new Cliente(null,"Luana", "35877842307", 99999999, "luana@gmail.com", conta1);
	        
	        assertEquals("Luana", cliente.getNomeCliente());
	        assertEquals("35877842307", cliente.getCpfCliente());
	        assertEquals(99999999, cliente.getTelefoneCliente());
	        assertEquals("luana@gmail.com", cliente.getEmailCliente());
	        assertEquals(conta1, cliente.getConta());


	        assertTrue(cliente.toString().contains("Cliente"));
	    }
}
