package edu.sms.util;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import edu.sms.dto.DepartmentDTO;
import edu.sms.entity.Department;

@Component
public class DepartmentConverter {

	//method to convert student dto to student entity
		public Department convertDeptDtoToEntity(DepartmentDTO dDto)
		{
			Department dept = new Department();
			
			if(dDto!=null)
			{
				BeanUtils.copyProperties(dDto, dept);
			}
			
			return dept;
		}
		
		//method to convert student entity to dto
		public DepartmentDTO convertDeptEntityToDto(Department dept)
		{
			DepartmentDTO dDto = new DepartmentDTO();
			
			if(dept!=null)
			{
				BeanUtils.copyProperties(dept, dDto);
			}
			
			return dDto;
		}
}
