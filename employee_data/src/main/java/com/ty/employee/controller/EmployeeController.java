package com.ty.employee.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ty.employee.entity.dto.EmployeeDTO;
import com.ty.employee.request.dto.EmployeeRequestDTO;
import com.ty.employee.response.dto.ResponseDTO;
import com.ty.employee.service.EmployeeService;

@RequestMapping("/api/v1/employee")
@RestController
public class EmployeeController {
	private static final Logger log = LoggerFactory.getLogger(EmployeeController.class);
	@Autowired
	EmployeeService employeeService;

	@PostMapping("/savedata")
	public ResponseEntity<ResponseDTO> inserData(@RequestBody EmployeeRequestDTO requestDTO) {
		EmployeeDTO saveData = null;
		try {
			log.info("Calling  employee service to save the data");
			saveData = employeeService.saveData(requestDTO);
			if (saveData != null) {
				return new ResponseEntity<ResponseDTO>(
						new ResponseDTO(false, "Sucessfully inserted the data", saveData), HttpStatus.OK);
			}

		} catch (Exception e) {
			log.error("Exception occured due to :", e);
		}
		return new ResponseEntity<ResponseDTO>(new ResponseDTO(false, "Failed to insert Data", saveData),
				HttpStatus.BAD_REQUEST);

	}

	@GetMapping("/getdata")
	public ResponseEntity<ResponseDTO> getData(@RequestParam String empId) {
		List<EmployeeDTO> data = null;
		try {
			log.info("Calling  employee service to get the data");
			data = employeeService.getData(empId);
			if (data != null) {
				return new ResponseEntity<ResponseDTO>(new ResponseDTO(false, "Sucessfully get the data", data),
						HttpStatus.OK);

			}
		} catch (Exception e) {
			log.error("Exception ocuured due to ", e);
		}
		return new ResponseEntity<ResponseDTO>(new ResponseDTO(false, "Failed to insert Data", data),
				HttpStatus.BAD_REQUEST);

	}

	@PutMapping("/updatedata")
	public ResponseEntity<ResponseDTO> updateData(@RequestBody EmployeeRequestDTO requestDTO) {
		EmployeeDTO updateData = null;
		try {
			log.info("Calling  employee service to update the data");
			updateData = employeeService.updateData(requestDTO);
			if (updateData != null) {
				return new ResponseEntity<ResponseDTO>(
						new ResponseDTO(false, "Sucessfully updated the data", updateData), HttpStatus.OK);

			}

		} catch (Exception e) {
			log.error("Exception ocuured due to ", e);
		}
		return new ResponseEntity<ResponseDTO>(new ResponseDTO(false, "Failed to update Data", updateData),
				HttpStatus.BAD_REQUEST);

	}
	@DeleteMapping("/deletedata")
	public ResponseEntity<ResponseDTO>deleteData(@RequestParam Integer id){
		log.info("Calling  employee service to delete the data");
		employeeService.deleteData(id);
		return new ResponseEntity<ResponseDTO>(
				new ResponseDTO(false, "Sucessfully deleted the data against", id), HttpStatus.OK);
		
	}

}
