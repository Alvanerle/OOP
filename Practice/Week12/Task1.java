package Practice.Week12;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Task1 {
    public static void main(String[] args) throws CloneNotSupportedException {
        Student st1 = new Student(1, "Imangali");
        Object test = st1.clone();
        Student st2 = new Student(2, "John");
        Student st3 = new Student(3, "Maksat");

        System.out.println("----------------");
        st1.id = 10;
        System.out.println(st1.toString());
        System.out.println(test.toString());
        System.out.println("----------------");

        Course math = new Course(1, "Math", new ArrayList<Student>(Arrays.asList(st1, st2, st3)));
        Course chemistry = new Course(2, "Chemistry", new ArrayList<Student>(Arrays.asList(st1, st2)));
        Course history = new Course(3, "History", new ArrayList<>(Arrays.asList(st1)));


        Object test1 = math.clone();
        math.students.add(new Student(1000, "dasds"));

        System.out.println("----------------");
        System.out.println(math.toString());
        System.out.println(test1.toString());
        System.out.println("----------------");

        Course courses[] = new Course[3];
        courses[0] = math;
        courses[1] = chemistry;
        courses[2] = history;

        System.out.println("----------------");
        Arrays.sort(courses);
        for(int i = 0; i < courses.length; i++){
            System.out.println(courses[i].toString());
        }
        System.out.println("----------------");
    }
}

class Student implements Cloneable {
    public int id;
    public String name;

    Student(int id, String name){
        this.id = id;
        this.name = name;
    }

    @Override
    public Object clone() throws CloneNotSupportedException{
        return new Student(id, new String(name));
    }

    @Override
    public String toString(){
        return String.format("id = %s, name = %s", id, name);
    }
}

class Course implements Comparable<Course>, Cloneable {
    public int id;
    public String name;
    List<Student> students;

    Course(int id, String name, List<Student> students){
        this.id = id;
        this.name = name;
        this.students = students;
    }

    @Override
    public Object clone() throws CloneNotSupportedException{
        return new Course(id, new String(name), new ArrayList<>(students));
    }

    @Override
    public int compareTo(Course course) {
        return this.students.size() - course.students.size();
    }

    @Override
    public String toString(){
        return String.format("id = %s, name = %s, number of students = %s", id, name, students.size());
    }
}
