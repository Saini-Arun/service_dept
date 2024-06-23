package net.javaguides.departmentservice.service.impl;

import lombok.AllArgsConstructor;
import net.javaguides.departmentservice.dto.DepartmentDto;
import net.javaguides.departmentservice.entity.Department;
import net.javaguides.departmentservice.exception.DepartmentCodeAlreadyRegisteredException;
import net.javaguides.departmentservice.exception.ResourceNotFoundException;
import net.javaguides.departmentservice.repository.DepartmentRepository;
import net.javaguides.departmentservice.service.DepartmentService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class DepartmentServiceImpl implements DepartmentService {

    private DepartmentRepository departmentRepository;
    private ModelMapper modelMapper;

    @Override
    public DepartmentDto saveDepartment(DepartmentDto departmentDto) {
        if (departmentRepository.existsByDepartmentCode(departmentDto.getDepartmentCode())){
            throw new DepartmentCodeAlreadyRegisteredException("DEPARTMENT_CODE_ALREADY_EXIST.");
        }
//        Department department=new Department(
//                departmentDto.getId(),
//                departmentDto.getDepartmentName(),
//                departmentDto.getDepartmentDescription(),
//                departmentDto.getDepartmentCode()
//                );
        Department department=modelMapper.map(departmentDto,Department.class);
        Department response=departmentRepository.save(department);
//        DepartmentDto responseDto=new DepartmentDto(
//                response.getId(),
//                response.getDepartmentName(),
//                response.getDepartmentDescription(),
//                response.getDepartmentCode()
//        );
        DepartmentDto responseDto=modelMapper.map(response,DepartmentDto.class);
        return responseDto;
    }

    @Override
    public DepartmentDto getDepartmentByCode(String departmentCode) {
        if(!departmentRepository.existsByDepartmentCode(departmentCode)){
            throw new ResourceNotFoundException("Department","Dpt. code", departmentCode);
        }
        Department responseData= departmentRepository.findByDepartmentCode(departmentCode);
//        DepartmentDto responseDataDto= new DepartmentDto(
//                responseData.getId(),
//                responseData.getDepartmentName(),
//                responseData.getDepartmentDescription(),
//                responseData.getDepartmentCode()
//        );
        DepartmentDto responseDataDto=modelMapper.map(responseData,DepartmentDto.class);
        return responseDataDto;
    }
}
