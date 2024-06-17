package com.code.practise.hackerrankproblems.data_structures.queues.java_priority_queue;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Solution {
    private final static Scanner scan = new Scanner(System.in);
    private final static Priorities priorities = new Priorities();

    public static void main(String[] args) {
//        int totalEvents = Integer.parseInt(scan.nextLine());
//        List<String> events = new ArrayList<>();
//
//        while (totalEvents-- != 0) {
//            String event = scan.nextLine();
//            events.add(event);
//        }

//        List<Student> students = priorities.getStudents(events);
        List<Student> students = priorities.getStudents(getEvents());
        students.sort(Comparator.comparing(Student::getCGPA).reversed());

        if (students.isEmpty()) {
            System.out.println("EMPTY");
        } else {
            for (Student st: students) {
                System.out.println(st.getName());
            }
        }
    }

    private static List<String> getEvents(){
        List<String> eventsList = new ArrayList<>();
        eventsList.add("ENTER John 3.75 50");
        eventsList.add("ENTER Mark 3.8 24");
        eventsList.add("ENTER Shafaet 3.7 35");
        eventsList.add("SERVED");
        eventsList.add("SERVED");
        eventsList.add("ENTER Samiha 3.85 36");
        eventsList.add("SERVED");
        eventsList.add("ENTER Ashley 3.9 42");
        eventsList.add("ENTER Maria 3.6 46");
        eventsList.add("ENTER Anik 3.95 49");
        eventsList.add("ENTER Dan 3.95 50");
        eventsList.add("SERVED");
        return eventsList;
    }
}


//input

//12
//ENTER John 3.75 50
//ENTER Mark 3.8 24
//ENTER Shafaet 3.7 35
//SERVED
//SERVED
//ENTER Samiha 3.85 36
//SERVED
//ENTER Ashley 3.9 42
//ENTER Maria 3.6 46
//ENTER Anik 3.95 49
//ENTER Dan 3.95 50
//SERVED