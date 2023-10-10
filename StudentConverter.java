package edu.sms.util;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import edu.sms.dto.StudentDTO;
import edu.sms.entity.Student;

@Component
public class StudentConverter {

	//method to convert student dto to student entity
	public Student convertStdDtoToEntity(StudentDTO sDto)
	{
		Student std = new Student();
		
		if(sDto!=null)
		{
			BeanUtils.copyProperties(sDto, std);
		}
		
		return std;
	}
	
	//method to convert student entity to dto
	public StudentDTO convertStdEntityToDto(Student std)
	{
		StudentDTO sDto = new StudentDTO();
		
		if(std!=null)
		{
			BeanUtils.copyProperties(std, sDto);
		}
		
		return sDto;
	}
}
