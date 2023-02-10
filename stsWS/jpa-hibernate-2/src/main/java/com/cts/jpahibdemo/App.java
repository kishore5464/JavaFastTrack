package com.cts.jpahibdemo;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.cts.jpahibdemo.entity.Assosiate;
import com.cts.jpahibdemo.entity.ContractAssosiate;
import com.cts.jpahibdemo.entity.Manager;

public class App {

	public static void main(String[] args) {
		
		EntityManager em = Persistence.createEntityManagerFactory("mysqlPU").createEntityManager();
		
		EntityTransaction txn = em.getTransaction();
		txn.begin();
		em.persist(new Assosiate(1L, "Vamsy", 56000.0));
		em.persist(new Manager(2L, "Suseela", 65000.0, 5000.0));
		em.persist(new ContractAssosiate(3L, "Sagar", 45000.0, 10.0));
		txn.commit();		
		em.close();
	}

}
