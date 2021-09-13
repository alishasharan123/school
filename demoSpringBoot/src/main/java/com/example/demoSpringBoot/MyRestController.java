package com.example.demoSpringBoot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


import java.util.List;
import java.util.Optional;
@Component
@RestController
public class MyRestController {

    @Autowired
    StudentDAO studentDAO;

    @Autowired
    Student1DAO student1DAO;
    @GetMapping("/")
    public String firstMethod()
    {
        return "Welcome to Spring boot Application";
    }

    @GetMapping("/student")
    public List<StudentDTo> getStudent()
    {
       return studentDAO.findAll();  //Does what getAllStudent method does in springMVC
    }

    @GetMapping("/student/{id}")
    @Cacheable("StudentDTo")
    public Optional<StudentDTo> getAnyStudent(@PathVariable String id)
    {
        return studentDAO.findById(id);  //Optional returns the specified Object or null when there is no object
    }

    @GetMapping("/student/fname/{fname}")
    public Optional<StudentDTo> getAnyStudentByName(@PathVariable String fname)
    {
        return studentDAO.findByFname(fname);  //Optional returns the specified Object or null when there is no object
    }

    @GetMapping("/student/name/{fname}/{lname}")
    public List<StudentDTo> getAnyStudentByName(@PathVariable String fname,@PathVariable String lname)
    {
        return studentDAO.findAllByFnameAndLname(fname,lname);  //Optional returns the specified Object or null when there is no object
    }

    @GetMapping("/student/marks")
    public List<Student1DTO> getAllStudentsMarks()
    {
        return student1DAO.findAll();
    }
    @GetMapping("/student/getDetails")
	public List<String> getStudentDetails(){
	
			return student1DAO.getJointDetails();//optional returns the specified object or null when there is no object
	
		
	}


    @PostMapping("/insert")
    //Add @RequestBody for the parameter of the function which has a @PostMapping Annotation to fetch values from the request.
    //For this to work remove @GeneratedMapping in the DTO
    public String insertStudent(@RequestBody StudentDTo sDTO){
        try{
            studentDAO.save(sDTO);
            return "Data is Inserted";
        }catch (Exception e){
            return (e.getMessage());
        }
    }



	@PutMapping("/update")
	public String updateStudent(@RequestBody StudentDTo sDTO){
		try{
			studentDAO.save(sDTO);
			return "Data is Updated";
		}catch (Exception e){
			return (e.getMessage());
		}
	}

	@PatchMapping("/patch")
	public String patchStudent(@RequestBody StudentDTo sDTO){
		try{
			studentDAO.save(sDTO);
			return "Data is Patched";
		}catch (Exception e){
			return (e.getMessage());
		}
	}

	    @DeleteMapping("/delete/{sid}")
	    public String deleteStudent(@PathVariable String sid){
	        try{
	            studentDAO.deleteById(sid);
	            return "Data is Deleted";
	        }catch (Exception e){
	            return (e.getMessage());
	        }
	    }
	}


