/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assisgnment1groupofstudents;

import java.util.Scanner;

/**
 *
 * @author Katerina Stankova
 * @author Sun Geun Yu
 */
public class Assisgnment1GroupOfStudents {

    /**
     * The main method asks for an input for a size of a group, generates new 
     * students upto the group size, prints the group of students, ask the user 
     * to enter a student number for which wants to change a first and a second 
     * name and prints an updated list of the group.
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int groupCapacity = groupCapacityInput(input);
        Group group = new Group(groupCapacity);
        Student student = newStudent(group, input, groupCapacity);
        System.out.println("Students in the group: " + group.toString());
        updateStudent(input, group, student);
    }

    /**
     * The method generate a new student.
     * @param group
     * @param input
     * @param groupCapacity
     * @return a new student
     */
    private static Student newStudent(Group group, Scanner input, int groupCapacity) {
        int studentNumber = 0;
        String firstName = "";
        String secondName = "";
        while (group.getNumOfStudents() < groupCapacity) {
            System.out.println("Enter first name");
            firstName = input.nextLine();
            System.out.println("Enter second name");
            secondName = input.nextLine();
            // taking in account user's errors: entering a characteur or string 
            // instead of an interger or entering existing SN
            boolean validSN = false;
            System.out.println("Enter student number");
            while (!validSN) {
                boolean interger = false;
                while (!interger) {
                    try {
                        studentNumber = input.nextInt();
                        input.nextLine();
                        interger = true;
                    } catch (Exception e) {
                        System.out.println("Student number can contain only "
                                + "numbers, please, enter new student number");
                        input.nextLine();
                    }
                }
                interger = false;
                if (!group.containStudent(studentNumber)) {
                    interger = true;
                    validSN = true;
                } else {
                    System.out.println("Student number is already in the list,"
                            + " please, enter a new number");
                    input.nextLine();
                }
            }
            Student student = new Student(firstName, secondName, studentNumber);
            group.addStudent(student);
        }
        return new Student(firstName, secondName, studentNumber);
    }

    /**
     * The method uses user's input
     * @param input
     * @return group capacity
     */
    private static int groupCapacityInput(Scanner input) {
        System.out.println("Define the capacity of the group of students:");
        int groupCapacity = input.nextInt();
        input.nextLine();
        // if (input )
        return groupCapacity;
    }

    /**
     * Method updates first and second name of a selected student number and
     * print a new list of student until. Process repeats until user enter 
     * a negative student number
     * @param input
     * @param group
     * @param student
     */
    private static void updateStudent(Scanner input, Group group, Student student) {
        int studentNumber = 0;
        while (studentNumber >= 0) {
            System.out.println("To change student's name provide a student"
                    + " number without 's'");
            System.out.println("To determinate program enter a negative value");
            // taking in account user's errors: entering a characteur or string 
            // instead of an interger
            boolean interger = false;
            while (!interger) {
                try {
                    studentNumber = input.nextInt();
                    input.nextLine();
                    interger = true;
                } catch (Exception e) {
                    System.out.println("Student number must be a number,"
                            + " please, enter new number");
                    input.nextLine();
                }
            }
                Student current = group.searchForStudent(studentNumber);
                if (current != null) {
                    System.out.println("A new first name");
                    String newFirstName = input.nextLine();
                    System.out.println("A new second name");
                    String newSecondName = input.nextLine();
                    current.setFirstName(newFirstName);
                    current.setSecondName(newSecondName);
                   // System.out.println(student.getFirstName()+ " " + student.getSecondName());
                // if the SN is not in the list request the user for a new SN
                } else {
                    System.out.println("Entered student number is not in the "
                            + "group, please enter a new number.");
                    input.nextLine();
                }
                System.out.println("Students in the group: "+ group.toString());

            }
        }
    }

