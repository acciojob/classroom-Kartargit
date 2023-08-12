package com.driver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {
    @Autowired
    StudentRepository repositoryObj = new StudentRepository();

    public void addStudent(Student student){
       repositoryObj.addStudent(student);
    }
    public void addTeacher(Teacher teacher){
        repositoryObj.addTeacher(teacher);
    }
    public void addStudentTeacher(String student,String teacher){
        if(repositoryObj.studentHashMap.containsKey(student)&&repositoryObj.teacherHashMap.containsKey(teacher)){
            repositoryObj.addStudentInTeacherList(student,teacher);
        }
    }
    public Student getStudentByName(String name){
        return repositoryObj.studentHashMap.get(name);
    }
    public Teacher getTeacherByName(String name){
        return repositoryObj.teacherHashMap.get(name);
    }
    public List<String> getStudentsByTeacherName(String teacherName){
        return repositoryObj.teacherListOfStudent.get(teacherName);
    }
    public List<String> getAllStudents(){
        List<String> list = repositoryObj.studentList;
        return list;
    }
    public void deleteTeacherByName(String teacherName){
        repositoryObj.deleteTeacherByName(teacherName);
    }
    public void deleteAllTeachers(){
        repositoryObj.deleteAllTeachers();
    }
}
