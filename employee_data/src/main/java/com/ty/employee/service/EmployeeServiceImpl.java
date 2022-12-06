package com.ty.employee.service;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ty.employee.entity.dto.EmployeeDTO;
import com.ty.employee.repository.dao.EmployeeRepository;
import com.ty.employee.request.dto.EmployeeRequestDTO;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	private static final Logger log = LoggerFactory.getLogger(EmployeeServiceImpl.class);

	@Autowired
	EmployeeRepository repository;

	@Override
	public EmployeeDTO saveData(EmployeeRequestDTO requestDTO) {
		try {
			log.info("Calling employee repository to save the data");
			EmployeeDTO employeeDTO = new EmployeeDTO();
			BeanUtils.copyProperties(requestDTO, employeeDTO);
			if (employeeDTO != null) {
				return repository.save(employeeDTO);
			}

		} catch (Exception e) {
			log.error("Exception occured due to " + e);
		}
		return null;
	}

	@Override
	public List<EmployeeDTO> getData(String empId) {
		try {
			log.info("Calling employee repository to get the data");
			if (empId != null) {
				List<EmployeeDTO> findByEmpId = repository.findByEmpId(empId);
				if (findByEmpId != null) {
					return findByEmpId;
				}

			} else {
				throw new Exception("empId is not valid");
			}

		} catch (Exception e) {
			log.error("Exception occured due to :" + e);
		}
		return null;
	}

	@Override
	public EmployeeDTO updateData(EmployeeRequestDTO requestDTO) {
		try {
			log.info("Calling employee repository to update the data");
			Optional<EmployeeDTO> findById = repository.findById(requestDTO.getId());
			if (findById.isPresent()) {
				EmployeeDTO employeeDTO = findById.get();
				BeanUtils.copyProperties(requestDTO, employeeDTO);
				if (employeeDTO != null) {
					return repository.save(employeeDTO);
				}

			}

		} catch (Exception e) {
			log.error("Exception occured due to :" + e);
		}
		return null;
	}

	@Override
	public void deleteData(Integer Id) {
		try {
			log.info("Calling employee repository to delete the data");
			if (Id != null) {
				repository.deleteById(Id);
			} else {
				throw new Exception(Id + "is not a valid value");
			}

		} catch (Exception e) {
			log.error("Exception occured due to :" + e);
		}

	}

}
