package com.ty.employee.request.dto;

public class EmployeeRequestDTO {

	private Integer id;
	private String empName;
	private String empDesignation;
	private String empDOB;
	private Long empSalary;
	private String empId;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public String getEmpDesignation() {
		return empDesignation;
	}

	public void setEmpDesignation(String empDesignation) {
		this.empDesignation = empDesignation;
	}

	public String getEmpDOB() {
		return empDOB;
	}

	public void setEmpDOB(String empDOB) {
		this.empDOB = empDOB;
	}

	public Long getEmpSalary() {
		return empSalary;
	}

	public void setEmpSalary(Long empSalary) {
		this.empSalary = empSalary;
	}

	public String getEmpId() {
		return empId;
	}

	public void setEmpId(String empId) {
		this.empId = empId;
	}

	@Override
	public String toString() {
		return "EmployeeDTO [id=" + id + ", empName=" + empName + ", empDesignation=" + empDesignation + ", empDOB="
				+ empDOB + ", empSalary=" + empSalary + ", empId=" + empId + "]";
	}

}
