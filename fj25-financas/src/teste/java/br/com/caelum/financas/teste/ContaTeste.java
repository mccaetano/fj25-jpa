package br.com.caelum.financas.teste;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.Assert;
import org.junit.Test;

import br.com.caelum.financas.modelo.Conta;

public class ContaTeste {

	@Test
	public void TestaInsereConta() {
		EntityManagerFactory factory = null;
		try {
			factory =  Persistence.createEntityManagerFactory("controlefinancas");
		} catch(Exception e) {
			Assert.fail(e.getCause().getMessage());
		}
		EntityManager manager = factory.createEntityManager();
		
		Conta conta = new Conta();
		conta.setTitular("José Roberto");
		conta.setBanco("Banco do Brasil");
		conta.setNumero("123456-6");
		conta.setAgencia("0999");
		
		manager.getTransaction().begin();
		try {
			manager.persist(conta);
		} catch(Exception e) {
			Assert.fail(e.getCause().getMessage());
		}
		manager.getTransaction().commit();
		
		Assert.assertTrue(manager.contains(conta));
		
		manager.close();
		
		factory.close();		
		
	}

}
