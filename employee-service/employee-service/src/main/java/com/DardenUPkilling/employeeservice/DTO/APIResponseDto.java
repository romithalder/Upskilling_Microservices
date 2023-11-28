package com.DardenUPkilling.employeeservice.DTO;

import org.springframework.beans.factory.annotation.Autowired;

public class APIResponseDto {
	
	@Autowired
    private EmployeeDto employee;
	
	@Autowired
    private DepartmentDto department;
	public EmployeeDto getEmployee() {
		return employee;
	}
	public void setEmployee(EmployeeDto employee) {
		this.employee = employee;
	}
	public DepartmentDto getDepartment() {
		return department;
	}
	public void setDepartment(DepartmentDto department) {
		this.department = department;
	}
	public APIResponseDto(EmployeeDto employee, DepartmentDto department) {
		super();
		this.employee = employee;
		this.department = department;
	}
	public APIResponseDto() {
		super();
		// TODO Auto-generated constructor stub
	}
    
    
}
