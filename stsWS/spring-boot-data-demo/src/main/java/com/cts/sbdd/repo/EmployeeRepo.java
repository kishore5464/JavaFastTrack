package com.cts.sbdd.repo;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.cts.sbdd.entity.Employee;

public interface EmployeeRepo extends JpaRepository<Employee, Long> {
	List<Employee> findAllByFullName(String fullName);
    boolean existsByMailId(String mailId);
    Optional<Employee> findByMailId(String mailId);

    @Query("SELECT e FROM Employee e WHERE e.dateOfJoining BETWEEN :start AND :end")
    List<Employee> getAllJoinedBetween(LocalDate start,LocalDate end);
}
