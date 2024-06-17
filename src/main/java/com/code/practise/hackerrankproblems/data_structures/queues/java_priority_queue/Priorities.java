package com.code.practise.hackerrankproblems.data_structures.queues.java_priority_queue;

import java.util.*;

public class Priorities {
    // this method should return the names of the remaining students who were not served
    public List<Student> getStudents(List<String> events){
        List<Student> studentList = new ArrayList<>();

        for(String event : events){
            String[] arr = event.split(" ");
            if ("ENTER".equals(arr[0])) {
                Student student = new Student(Integer.parseInt(arr[3]), arr[1], Double.parseDouble(arr[2]));
                studentList.add(student);
            } else if ("SERVED".equals(arr[0])) {
                Student servedStudent = servePriorityStudent(studentList);
                studentList.remove(servedStudent);
            }
        }

        return studentList;
    }

    private Student servePriorityStudent(List<Student> studentList) {

        Optional<Double> maxCGPA = studentList.stream().map(Student::getCGPA).max(Double::compare);

        //get the list of students with max cgpa
        List<Student> studentsWithMaxCGPA = new ArrayList<>(maxCGPA.map(cgpa -> studentList.stream()
                .filter(student -> student.getCGPA() == cgpa).toList()
        ).orElse(List.of()));

        if (studentsWithMaxCGPA.size() == 1) {
            return studentsWithMaxCGPA.get(0);
        } else { // if there are students with same max cgpa
            studentsWithMaxCGPA.sort(Comparator.comparing(Student::getName));
            if(studentsWithMaxCGPA.get(0).getName().equals(studentsWithMaxCGPA.get(1).getName())){
                if (studentsWithMaxCGPA.get(0).getID() < studentsWithMaxCGPA.get(1).getID()) {
                    return studentsWithMaxCGPA.get(0);
                } else {
                    return studentsWithMaxCGPA.get(1);
                }
            } else {
                return studentsWithMaxCGPA.get(0);
            }
        }
    }
}

/**
 *
 * Below is the 'Priorities' class implementation that pass all the test cases

class Priorities {

    List<Student> getStudents(List<String> events) {

        PriorityQueue<Student> priorityQueue = new PriorityQueue<>(new Comparator<Student>() {
            public int compare(Student s1, Student s2) {
                return s1.getCGPA() != s2.getCGPA() ? s2.getCGPA() - s1.getCGPA() > 0 ? 1 : -1 : !s1.getName().equals(s2.getName()) ? s1.getName().compareTo(s2.getName()) :  s1.getID() > s2.getID() ? 1 : -1;
            }
        });

        for (String str: events) {
            String isENTER = str.split(" ")[0];

            if (isENTER.equals("ENTER")) {
                int id = Integer.parseInt(str.split(" ")[3]);
                String name = str.split(" ")[1];
                double cgpa = Double.parseDouble(str.split(" ")[2]);

                priorityQueue.add(new Student(id, name, cgpa));

            } else priorityQueue.poll();
        }

        List<Student> result = new ArrayList<>();

        while (!priorityQueue.isEmpty()) {
            result.add(priorityQueue.poll());
        }

        return result;
    }
}

 **/