package com.DardenUPkilling.employeeservice.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.DardenUPkilling.employeeservice.DTO.APIResponseDto;
import com.DardenUPkilling.employeeservice.DTO.DepartmentDto;
import com.DardenUPkilling.employeeservice.DTO.EmployeeDto;
import com.DardenUPkilling.employeeservice.Repository.EmployeeRepository;
import com.DardenUPkilling.employeeservice.entity.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeService{
	
	@Autowired
	private EmployeeRepository er;
	
//	@Autowired
//	private WebClient w;
//	
	
	@Autowired
	private APIClients apiClients;
	
	
	
	
	

	public EmployeeServiceImpl(EmployeeRepository er, APIClients apiClients) {
	super();
	this.er = er;
	this.apiClients = apiClients;
}

	@Override
    public EmployeeDto saveEmployee(EmployeeDto employeeDto) {

        Employee employee = new Employee(
                employeeDto.getId(),
                employeeDto.getFirstName(),
                employeeDto.getLastName(),
                employeeDto.getEmail(),
                employeeDto.getDepartmentCode()
        );

        Employee saveDEmployee = er.save(employee);

        EmployeeDto savedEmployeeDto = new EmployeeDto(
                saveDEmployee.getId(),
                saveDEmployee.getFirstName(),
                saveDEmployee.getLastName(),
                saveDEmployee.getEmail(),
                saveDEmployee.getDepartmentCode()
        );

        return savedEmployeeDto;
    }

	@Override
    public APIResponseDto getEmployeeById(Long employeeId) {

        Employee employee = er.findById(employeeId).get();

//        ResponseEntity<DepartmentDto> responseEntity = restTemplate.getForEntity("http://localhost:8080/api/departments/" + employee.getDepartmentCode(),
//                DepartmentDto.class);
//
//        DepartmentDto departmentDto = responseEntity.getBody();

//        DepartmentDto departmentDto = w.get()
//                .uri("http://localhost:8080/api/departments/" + employee.getDepartmentCode())
//                .retrieve()
//                .bodyToMono(DepartmentDto.class)
//                .block();

        DepartmentDto departmentDto = apiClients.getDepartment(employee.getDepartmentCode());

        EmployeeDto employeeDto = new EmployeeDto(
                employee.getId(),
                employee.getFirstName(),
                employee.getLastName(),
                employee.getEmail(),
                employee.getDepartmentCode()
        );

        APIResponseDto apiResponseDto = new APIResponseDto();
        apiResponseDto.setEmployee(employeeDto);
        apiResponseDto.setDepartment(departmentDto);

        return apiResponseDto;
    }

}
