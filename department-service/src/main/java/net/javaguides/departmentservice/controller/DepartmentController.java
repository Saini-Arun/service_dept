package net.javaguides.departmentservice.controller;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import net.javaguides.departmentservice.dto.DepartmentDto;
import net.javaguides.departmentservice.service.DepartmentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("api/departments")
public class DepartmentController {

    private DepartmentService departmentService;

    @PostMapping
    public ResponseEntity<DepartmentDto> saveDepartment(@Valid @RequestBody DepartmentDto departmentDto){
        DepartmentDto savedResponse= departmentService.saveDepartment(departmentDto);
        return new ResponseEntity<>(savedResponse, HttpStatus.CREATED);
    }

    @GetMapping("{department-code}")
    public ResponseEntity<DepartmentDto> getDepartmentByCode(@PathVariable("department-code") String departmentCode){
        DepartmentDto savedResponse= departmentService.getDepartmentByCode(departmentCode);
        return new ResponseEntity<>(savedResponse, HttpStatus.OK);
    }
}
