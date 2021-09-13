package com.example.demoSpringBoot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

@Component
@RestController
@RequestMapping("/sdetail")
public class PostController {

    @Autowired
    StudentDAO studentDao;

    @PostMapping("/insert")
    //Add @RequestBody for the parameter of the function which has a @PostMapping Annotation to fetch values from the request.
    //For this to work remove @GeneratedMapping in the DTO
    public String insertStudent(@RequestBody StudentDTo sDTO){
        try{
            studentDao.save(sDTO);
            return "Data is Inserted";
        }catch (Exception e){
            return (e.getMessage());
        }
    }

}