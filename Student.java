/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assisgnment1groupofstudents;

/**
 *
 * @author Katerina Stankova
 * @author Sun Geun Yu
 */
    public class Student // why is not it static
    {
        private String first_name;
        private String second_name;
        private int student_number;
        
        public Student (String firstName, String secondName, int studentNumber)
        {
        this.first_name = firstName;
        this.second_name = secondName;
        this.student_number = studentNumber;
        }
        
        public String getFirstName()
        {
            return first_name;
        }
        
        public String getSecondName()
        {
            return second_name;
        }

        public int getStudentNumber()
        {
            return student_number;
        }
        
        public void setFirstName(String newFirstName)
        {
            this.first_name = newFirstName;
        }
        public void setSecondName(String newSecondName)
        {
            this.second_name = newSecondName;
        }
        
        @Override
        public String toString(){
            return first_name + " " + second_name + ", s" + student_number;
        }
    }
