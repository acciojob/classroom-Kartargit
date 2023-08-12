package com.driver;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
@Repository
public class StudentRepository {
    public HashMap<String,Teacher> teacherHashMap = new HashMap<>();
    public HashMap<String,Student> studentHashMap = new HashMap<>();
    public HashMap<String, List<String>> teacherListOfStudent = new HashMap<>();
    public List<String> studentList = new ArrayList<>();

    public void addStudent(Student student){
        studentHashMap.put(student.getName(),student);
        studentList.add(student.getName());
    }
    public void addTeacher(Teacher teacher){
        teacherHashMap.put(teacher.getName(),teacher);
    }
    public void addStudentInTeacherList(String student,String teacher){
        List<String> list  ;
        if(teacherListOfStudent.containsKey(teacher)){
            list = teacherListOfStudent.get(teacher);
        }
        else{
            list = new ArrayList<>();
        }
        list.add(student);
        teacherListOfStudent.put(teacher, list);

    }
    public void deleteTeacherByName(String teacherName){
        teacherHashMap.remove(teacherName);
        teacherListOfStudent.remove(teacherName);
    }
    public void deleteAllTeachers(){
        teacherListOfStudent.clear();
        teacherHashMap.clear();
    }
}
