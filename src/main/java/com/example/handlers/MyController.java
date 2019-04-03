package com.example.handlers;



import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.entity.Student;
import com.example.service.IStudentService;


@Controller
@RequestMapping("/test")
public class MyController {
	
	private static Logger logger = LoggerFactory.getLogger(MyController.class);
	//@Resource(name="studentService")
	//private IStudentService service;
	
	/*public void setService(IStudentService service) {
		this.service = service;
	}*/

	@RequestMapping("/register.do")
	public String doRegister(Student student){
		
		//service.addStudent(student);
		
		logger.debug("ceshi");
		return "/welcome.jsp";
	}

}
