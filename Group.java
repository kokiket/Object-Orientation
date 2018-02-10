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
public class Group {

    private Student[] students;
    private int nrOfStudents;
    private int capacity;

    public Group(int groupCapacity) {
        nrOfStudents = 0;
        capacity = groupCapacity;
        students = new Student[groupCapacity];
    }

    public void addStudent(Student s) {
        if (nrOfStudents < capacity) {
            students[nrOfStudents] = s;
            nrOfStudents++;
        }
    }

    public Student searchForStudent(int snumber) {
        for (int i = 0; i < nrOfStudents; i++) {
            if (students[i].getStudentNumber() == snumber) {
                return students[i];
            }
        }
        return null;
    }

    // return true if the student is in the group
    public boolean containStudent(int studentNumber) {

        for (Student s : students) {
            if (!(s == null)) {
                if (s.getStudentNumber() == studentNumber) {
                    return true;
                }
            }
        }
        return false;
    }

    public int getNumOfStudents() {
        return nrOfStudents;
    }
// this method prints whole group. However, it has a problem when we use it for
// updated list of students it prints the old list. We did not figurout it out 
// how to fix it. Neverthelles, the problem is not in the student, we tried to
// the specific student and it worked but the problem is specifically here.

    @Override
    public String toString() {
        String allTogether = "";
        for (int i = 0; i < nrOfStudents; i++) {
            allTogether += students[i].toString() + "; ";
        }
        allTogether += "Our group consists of " + nrOfStudents + " students." + "\n";   //for new line use "\n"
        return allTogether;
    }
}
