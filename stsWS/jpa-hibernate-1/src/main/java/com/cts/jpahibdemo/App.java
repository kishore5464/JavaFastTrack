package com.cts.jpahibdemo;

import java.util.TreeSet;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.cts.jpahibdemo.entity.Address;
import com.cts.jpahibdemo.entity.BankAccount;
import com.cts.jpahibdemo.entity.Departmnet;
import com.cts.jpahibdemo.entity.Employee;
import com.cts.jpahibdemo.entity.Gender;

public class App {

	public static void main(String[] args) {
		
		Departmnet d1 = new Departmnet(null,"Accounts",new TreeSet<>());
		Departmnet d2 = new Departmnet(null,"Sales",new TreeSet<>());
		Departmnet d3 = new Departmnet(null,"Operations",new TreeSet<>());

		Employee e1 = new Employee(null, "Vamsy", 45000.0, Gender.GENT, new Address("12-31","VSP","AP"), new BankAccount("1001", "SB001", null), d1);
		e1.getSalaryAccount().setHolder(e1);
		d1.getEmps().add(e1);
		
		Employee e2 = new Employee(null, "Sagar", 35000.0, Gender.GENT, new Address("12-77","VJY","AP"), new BankAccount("1002", "SB001", null), d1);
		e2.getSalaryAccount().setHolder(e2);
		d1.getEmps().add(e2);
		
		Employee e3 = new Employee(null, "Suseela", 55000.0, Gender.LADY, new Address("12-31","VSP","AP"), new BankAccount("1003", "SB001", null), d2);
		e3.getSalaryAccount().setHolder(e3);
		d2.getEmps().add(e3);
		
		Employee e4 = new Employee(null, "Indhikaa", 85000.0, Gender.LADY, new Address("12-31","VSP","AP"), new BankAccount("1009", "SB001", null), d2);
		e4.getSalaryAccount().setHolder(e4);
		d2.getEmps().add(e4);
		
		Employee e5 = new Employee(null, "Srinu", 145000.0, Gender.GENT, new Address("12-77","VSP","AP"), new BankAccount("1022", "SB001", null), d3);
		e5.getSalaryAccount().setHolder(e5);
		d3.getEmps().add(e5);

		EntityManager em = Persistence.createEntityManagerFactory("mysqlPU").createEntityManager();
		
		EntityTransaction txn = em.getTransaction();
		txn.begin();
		em.persist(d1);
		em.persist(d2);
		em.persist(d3);
		txn.commit();		
		em.close();
	}

}
