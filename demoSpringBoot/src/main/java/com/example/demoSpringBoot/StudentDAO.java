package com.example.demoSpringBoot;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository  // equivalent @Component @Bean
public interface StudentDAO extends JpaRepository<StudentDTo,String> {  //DTO, Type of @Id

    public Optional<StudentDTo> findByFname(String fname);   //The parameter name should be exactly same as defined in StudentDTo

    public List<StudentDTo> findAllByFnameAndLname(String fname, String lname);

}