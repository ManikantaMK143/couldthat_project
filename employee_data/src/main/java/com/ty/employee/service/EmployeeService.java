package com.ty.employee.service;

import java.util.List;

import com.ty.employee.entity.dto.EmployeeDTO;
import com.ty.employee.request.dto.EmployeeRequestDTO;

public interface EmployeeService {
	
	public EmployeeDTO saveData(EmployeeRequestDTO requestDTO);
	
	public List<EmployeeDTO> getData(String empId);
	
	public EmployeeDTO updateData(EmployeeRequestDTO requestDTO);
	
	public void deleteData(Integer Id);

}
