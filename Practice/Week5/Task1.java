package Practice.Week5;

public class Task1 {
    public static void main(String[] args) {
        Person person1 = new Person("Josh", "NYC");
        System.out.println(person1.toString());

        Student student1 = new Student("Imangali", "Almaty", "IT", 18, 1000000);
        System.out.println(student1.toString());

        Staff staff1 = new Staff("Alex", "Mahachkala", "IT", 1000000);
        System.out.println(staff1.toString());
    }
}

class Person {
    private String name;
    private String address;

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