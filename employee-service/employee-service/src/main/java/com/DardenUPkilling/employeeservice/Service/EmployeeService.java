package com.DardenUPkilling.employeeservice.Service;

import org.springframework.stereotype.Service;

import com.DardenUPkilling.employeeservice.DTO.APIResponseDto;
import com.DardenUPkilling.employeeservice.DTO.EmployeeDto;

@Service
public interface EmployeeService {
    EmployeeDto saveEmployee(EmployeeDto employeeDto);

    APIResponseDto getEmployeeById(Long employeeId);
}