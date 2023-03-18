package com.myapp.spring_boot_test.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.myapp.spring_boot_test.model.Student;
import com.myapp.spring_boot_test.service.StudentService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

@WebMvcTest
class StudentControllerTest {

    @Autowired
    MockMvc mockMvc;

    @InjectMocks
    StudentController studentController;

    @Autowired
    ObjectMapper objectMapper;

    @MockBean
    private StudentService studentService;

    @Test
    void addStudent() throws Exception {

        //arrange

        Student student = new Student();
        student.setName("pushpak");

        //Mockito.when(studentService.addStudent(Mockito.any(Student.class))).thenReturn(student);
        Mockito.when(studentService.addStudent(student)).thenReturn(student);


        //act
        MockHttpServletResponse response = mockMvc
                .perform(post("/add-student")
                        .content(objectMapper.writeValueAsString(student))
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON)
                ).andReturn().getResponse();
        System.out.println(response.getContentAsString());

        //assert
        Assertions.assertEquals(student.getName(), objectMapper.readValue(response.getContentAsString(), Student.class).getName());
    }
}