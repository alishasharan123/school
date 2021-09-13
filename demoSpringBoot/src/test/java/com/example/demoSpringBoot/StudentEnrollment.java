package com.example.demoSpringBoot;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import static org.junit.jupiter.api.Assertions.fail;


@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources")
public class StudentEnrollment extends CucumberSpringConfiguration {

@Autowired
    MyRestController controller1;


    StudentDTo student;
    String result;
    @Given("A student enrolls")
    public void aStudentEnrolls() {
        controller1=new MyRestController();
        student=new StudentDTo();

    }

    @When("The data is collected")
    public void theDataIsCollected() {
        student.setSid("156");
        student.setFname("Sahil");
        student.setLname("sara");
        student.setAddress("dimna");
        student.setDb1("5th feb 1991");
        result=controller1.insertStudent(student);
    }

    @Then("Data is added in the database")
    public void dataIsAddedInTheDatabase() {
//        try{
//            assertEquals(result, "Data is Inserted");
//        } catch (Exception e){
//            fail();
//        }
//            Optional<StudentDTo> list = controller1.getAnyStudent("146");
//            assertNotNull(list);



        }


}
