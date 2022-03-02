package Practice.Week6;

/*
    Based on one of the tasks that you did last week (week-5 Practice), add the following:

    1) Add one more class;
    2) Overload at least one method, and demonstrate its usage;
    3) Override at least one method, and demonstrate its usage;
    4) Create an array of objects, and demonstrate polymorphism;
    5) Demonstrate dynamic binding based on the array created;
    6) Add/change at least one data field/method to protected, demonstrate how it works;
    7) Make one of the classes/methods final, and show its effect.
*/


import java.io.StringReader;

public class Task1 {
    public static void main(String[] args){
        Teacher[] teachers = {new Teacher("Alex", "Almaty", "+534543242"), new Teacher("John", "Astana"), new Teacher("Dave", "California", "+23424234"), new Teacher("+53223423")};
        Student[] students = {new Student("Imangali", "Almaty", "IT", 18, 1000000), new Student("Erasyl", "Astana", "IT", 20, 2000000)};

        for(Teacher teacher : teachers){
            System.out.println(teacher.toString());
        }

        for(Student student : students){
            System.out.println(student.toString());
        }

    }
}

class Dean extends Teacher{
    public Dean(String name, String address, String phoneNumber) {
        super(name, address, phoneNumber);
    }
}

final class Teacher extends Person{
    private String phoneNumber;

    public Teacher(String name, String address, String phoneNumber){
        super(name, address);
        this.phoneNumber = phoneNumber;
    }

    public Teacher(String name, String address){
        super(name, address);
    }

    public Teacher(String phoneNumber){
        this.phoneNumber = phoneNumber;
    }

    public String toString(){
        return String.format("Teacher[%s, phoneNumber = %s]", super.toString(), this.phoneNumber);
    }

    public String checkProtected(){
        return this.name;
    }

//    public String checkProtected2(){
//        return this.address;
//    }
}

class Person {
    protected String name;
    private String address;

    public Person(){

    }

    public Person(String name, String address){
        this.name = name;
        this.address = address;
    }

    public String getName(){
        return name;
    }

    public String getAddress(){
        return address;
    }

    public void setAddress(String address){
        this.address = address;
    }

    public String toString(){
        return String.format("Person[name = %s, address = %s]", this.name, this.address);
    }
};

class Student extends Person {
    private String program;
    private int year;
    private double fee;

    public Student(String name, String address, String program, int year, double fee){
        super(name, address);
        this.program = program;
        this.year = year;
        this.fee = fee;
    }

    public String getProgram(){
        return this.program;
    }

    public void setProgram(String program){
        this.program = program;
    }

    public int getYear(){
        return this.year;
    }

    public void setYear(int year){
        this.year = year;
    }

    public double getFee(){
        return this.fee;
    }

    public void setFee(double fee){
        this.fee = fee;
    }

    public String toString(){
        return String.format("Student[%s, program = %s, year = %s, fee = %s]", super.toString(), this.program, this.year, this.fee);
    }
};

class Staff extends Person {
    private String school;
    private double pay;

    public Staff(String name, String address, String school, double pay){
        super(name, address);
        this.school = school;
        this.pay = pay;
    }

    public String getSchool(){
        return this.school;
    }

    public void setSchool(String school){
        this.school = school;
    }

    public double getPay(){
        return this.pay;
    }

    public void setPay(double pay){
        this.pay = pay;
    }

    public String toString(){
        return String.format("Staff[%s, school = %s, pay = %s]", super.toString(), this.school, this.pay);
    }
}