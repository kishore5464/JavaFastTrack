package com.cts.jpahibdemo;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import com.cts.jpahibdemo.entity.Departmnet;
import com.cts.jpahibdemo.entity.Employee;

public class App {

	public static void main(String[] args) {

		EntityManager em = Persistence.createEntityManagerFactory("mysqlPU").createEntityManager();

		EntityTransaction txn = em.getTransaction();

		// select * from depts
		TypedQuery<Departmnet> qry1 = em.createQuery("SELECT d FROM Departmnet d", Departmnet.class);
		qry1.getResultStream().forEach(System.out::println);

		// select fullName,city from emps
		Query qry2 = em.createQuery("SELECT e.fullName,e.address.city FROM Employee e");
		List<Object[]> data = qry2.getResultList();
		for (Object[] row : data) {
			System.out.println(row[0] + "\t" + row[1]);
		}

		// CROSS JOIN
		Query qry3 = em.createQuery("SELECT e.fullName,e.dept.name FROM Employee e");
		List<Object[]> data3 = qry3.getResultList();
		for (Object[] row : data3) {
			System.out.println(row[0] + "\t" + row[1]);
		}

		// INNER JOIN
		Query qry4 = em.createQuery("SELECT e.fullName,e.dept.name FROM Employee e INNER JOIN e.dept");
		List<Object[]> data4 = qry4.getResultList();
		for (Object[] row : data4) {
			System.out.println(row[0] + "\t" + row[1]);
		}

		// OUTER JOIN
		Query qry5 = em.createQuery("SELECT e.fullName,e.dept.name FROM Employee e LEFT OUTER JOIN e.dept");
		List<Object[]> data5 = qry5.getResultList();
		for (Object[] row : data5) {
			System.out.println(row[0] + "\t" + row[1]);
		}

		// Filtering
		TypedQuery<Employee> qry6 = em.createQuery("SELECT e FROM Employee e WHERE e.salary BETWEEN 40000 and 60000",
				Employee.class);
		qry6.getResultStream().forEach(System.out::println);

		// Filtering with params
		TypedQuery<Employee> qry7 = em.createQuery("SELECT e FROM Employee e WHERE e.salary BETWEEN :lb and :ub",
				Employee.class);
		qry7.setParameter("lb", 20000.0);
		qry7.setParameter("ub", 40000.0);
		qry7.getResultStream().forEach(System.out::println);

		//Group by
		Query qry8 = em.createQuery("SELECT e.dept.name,count(e) FROM Employee e LEFT OUTER JOIN e.dept GROUP BY e.dept");
		List<Object[]> data8 = qry8.getResultList();
		for (Object[] row : data8) {
			System.out.println(row[0] + "\t" + row[1]);
		}
		
		em.close();
	}

}
