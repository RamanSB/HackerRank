import java.util.*;

/**
 * Problem: https://www.hackerrank.com/challenges/java-sort/problem
 *
 * Sort: ID, FirstName, and CGPA
 *
 * Sort Order:
 *  1) CGPA in decreasing order
 *  2) same CGPA, then arrange them according to their first name in alphabetical order
 *  3) students also have the same first name, then order them according to their ID
 *
 *  Condition: No two students have the same ID
 *
 * ID Name CGPA
 *  Input:
 * 5
 * 33 Rumpa 3.68
 * 85 Ashis 3.85
 * 56 Samiha 3.75
 * 19 Samara 3.75
 * 22 Fahim 3.76
 *
 * Output:
 * Ashis
 * Fahim
 * Samara
 * Samiha
 * Rumpa
 */
public class JavaSortProblem {

    public static void main(String[] args){
            Scanner in = new Scanner(System.in);
            int testCases = Integer.parseInt(in.nextLine());

            List<Student> studentList = new ArrayList<Student>();
            while(testCases>0){
                int id = in.nextInt();
                String fname = in.next();
                double cgpa = in.nextDouble();

                Student st = new Student(id, fname, cgpa);
                studentList.add(st);

                testCases--;
            }Ò

        studentList.sort(new Comparator<Student>() {
            @Override
            public int compare(Student s1, Student s2) {
                if (s1.getCgpa() == s2.getCgpa()) {
                    if (s1.getFname().compareTo(s2.getFname()) == 0) {
                        return s1.getId() - s2.getId();
                    } else {
                        return s1.getFname().compareTo(s2.getFname());
                    }
                } else {
                    return -(s1.getCgpa()-s2.getCgpa()) > 0  ?  1 : -1;
                }
            }
        });

        //studentList.sort(new Student());
        for(Student st: studentList){
                System.out.println(st.getFname());
            }

    }
}


class Student implements Comparator<Student> {
    private int id;
    private String fname;
    private double cgpa;

    public Student(){};

    public Student(int id, String fname, double cgpa) {
        super();
        this.id = id;
        this.fname = fname;
        this.cgpa = cgpa;
    }
    public int getId() {
        return id;
    }
    public String getFname() {
        return fname;
    }
    public double getCgpa() {
        return cgpa;
    }

    @Override
    public int compare(Student s1, Student s2){
        if(s1.getCgpa() == s2.getCgpa()){
            if(s1.getFname().compareTo(s2.getFname())==0){
                return s1.getId()-s2.getId();
            }else{
                return s1.getFname().compareTo(s2.getFname());
            }
        }else{
            System.out.println("Comparing " + s1.getFname() + " and " + s2.getFname() + " based on Cgpa");
            return -(s1.getCgpa()-s2.getCgpa()) > 0  ?  1 : -1;
        }
    }
}
