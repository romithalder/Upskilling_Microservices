package com.DardenUPkilling.employeeservice.Service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.DardenUPkilling.employeeservice.DTO.DepartmentDto;


@FeignClient(url = "http://localhost:8080", value = "DEPARTMENT-SERVICE")
public interface APIClients {
	 @GetMapping("api/departments/{department-code}")
	    DepartmentDto getDepartment(@PathVariable("department-code") String departmentCode);
}
