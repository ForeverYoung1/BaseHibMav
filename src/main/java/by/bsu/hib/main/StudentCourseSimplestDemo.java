package by.bsu.hib.main;


import by.bsu.hib.dao.CourseDAO;
import by.bsu.hib.dao.StudentDAO;
import by.bsu.hib.entity.Course;
import by.bsu.hib.entity.Student;
import by.bsu.hiber.util.HibernateUtil;
import org.hibernate.Session;



import java.util.HashSet;
import java.util.Set;

public class StudentCourseSimplestDemo {
    public static void main(String[] args) {

        Session session = HibernateUtil.getSession();

        // Session session =  HibernateUtil.getSessionFactory();

       //Session session = (Session) HibernateUtil.getSessionFactory();

        try {
            StudentDAO studentDAO = new StudentDAO(session);
            CourseDAO courseDAO = new CourseDAO(session);

            String courseTitle1 = "Java";
            Course course1 = new Course();
            course1.setTitle(courseTitle1);

            HashSet<Student> set1 = new HashSet<Student>() {
                {
                    this.add(new Student("Ivanov", "Vitalii"));
                    this.add(new Student("Rembo", "Arnold"));
                    this.add(new Student("Shwartz", "Silvester"));

                }
            };  //для чего   ";"
            course1.setStudents(set1);
            courseDAO.addCourse(course1);

            String courseTitle2 = "Design Patterns for Java";
            Course course2 = new Course();
            course2.setTitle(courseTitle2);
           courseDAO.addCourse(course2);
            Set<Student> setRes = courseDAO.findRegistedOnCourse(courseTitle1);
            Student student1 = new Student("Zainka", "Vital");
            studentDAO.addStudent(student1);
            System.out.println(setRes);
            Student student2 = studentDAO.getStudent("Ivanov");
            System.out.println(student2);
            HashSet<Student> set2 = new HashSet<>();
            set2.add(student1);
            set2.add(student2);
            course2.setStudents(set2);
            courseDAO.addCourse(course2);
        }finally {
            if (session != null){
                session.close();
            }
        }
    }
}
