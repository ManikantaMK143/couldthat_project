package com.ty.employee.repository.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ty.employee.entity.dto.EmployeeDTO;

@Repository
public interface EmployeeRepository extends JpaRepository<EmployeeDTO, Integer> {
	
	List<EmployeeDTO>  findByEmpId(String empId);

}
