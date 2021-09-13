package com.example.demoSpringBoot;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringRunner;
import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

import java.util.List;
import java.util.Optional;


@SpringBootTest
@RunWith(SpringRunner.class)
@ExtendWith(SpringExtension.class)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class DemoSpringBootApplicationTests {
	@Autowired
	MyRestController controller;
	
	@Autowired
	PostController postcontroller;

//	@Autowired
//	StudentDTo st;
	
	
	@Test
	@Order(1)
	public void testDTOAvailableOrNot() {
		try {
		StudentDTo student=new StudentDTo();
		student.getDb1();
	}catch(Exception e){
		fail();
	}
	}
		
		@Test
		@Order(2)
		public void testDTOAvailableOrNot1() {
			try {
			StudentDTo student=new StudentDTo();
			student.getAddress();
		}catch(Exception e){
			fail();
		}
		

		}
		@Test
		@Order(3)
		public void testController1() {
			try {
			List<String> list=controller.getStudentDetails();
			if(list==null) {throw new Exception();}
		}catch(Exception e){
			fail();
		}
		

		}
		

	

		 @Test
		 @Order(4)
		 public void testController3(){
		  try {
		   Optional<StudentDTo> list = controller.getAnyStudent("101");
		   assertNotNull(list);
		  } catch (Exception e){
		   fail();
		  }
		 }

		 @Test
		 @Order(5)
		 public void testController4(){
		  try {
		   Optional<StudentDTo> list = controller.getAnyStudent("5000");
		   assertEquals(list, Optional.empty());
		  } catch (Exception e){
		   fail();
		  }
		 }

		 @Test
		 @Order(6)
		 public void testInsertion(){
		  try {
		   StudentDTo student2 = new StudentDTo();
		   student2.setSid("133");
		   student2.setAddress("abc, def");
		   student2.setFname("Ganesh");
		   student2.setLname("Delta");
		   student2.setDb1("1991-01-01");
		   String result =postcontroller.insertStudent(student2);
		   assertEquals(result, "Data is Inserted");
		  } catch (Exception e){
		   fail();
		  }
		 }

		 @Test
		 @Order(7)
		 public void testUpdate(){
		  try {
		   StudentDTo student = new StudentDTo();
		   student.setSid("133");
		   student.setAddress("adarsh nagar");
		   student.setFname("Zeta");
		   student.setLname("Delta");
		   student.setDb1("1991-01-01");
		   String result = 	controller.updateStudent(student);
		   assertEquals(result, "Data is Updated");
		  } catch (Exception e){
		   fail();
		  }
		 }

		 @Test
		@Order(8)
		public void GetStudentByName(){
		Optional<StudentDTo> list=controller.getAnyStudentByName("alisha");
		assertNotNull(list);
	}

	@Test
	@Order(9)
	public void GetStudentByFirstAndLastName(){
		List<StudentDTo> list=controller.getAnyStudentByName("alisha","sharan");
		assertNotNull(list);
	}

	@Test
	@Order(10)
	public void GetMarksOfStudents(){
		List<Student1DTO> list=controller.getAllStudentsMarks();
		assertNotNull(list);
	}

//	@Test
//	@Order(11)
//	public void GetMarks1()
//	{
//       StudentDTo st = new StudentDTo();
//		st.setSid("102");
//		st.setFname("john");
//		String res= st.getAddress();
//		assertEquals(res,"abc12, xqv nagar");
//	}



//@ParameterizedTest
//@Order(11)
//@ValueSource(params={"160","abhi","raj","4-july-2003","mango"})
//	 void ParameterizedInsertion(){
//	StudentDTo student2 = new StudentDTo(params);
//	}


//	@Test
//	@Order(7)
//	public void testControllerDelete(){
//
//		String result = controller.deleteStudent("102");
//			assertEquals(result,"Data is Deleted");
//
//	}
	}






		
		
		

	
