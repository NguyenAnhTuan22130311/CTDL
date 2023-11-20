package Task_01;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class TestFalcuty {
	public static void main(String[] args) {
		List<Student> student1 = new ArrayList<Student>();
		student1.add(new Student("001","Nguyen Van A", 2022));
		student1.add(new Student("002","Nguyen Van B", 2020));
		student1.add(new Student("003","Pham Thi C", 2022));
		student1.add(new Student("004","Tran Hanh D", 2021));
		student1.add(new Student("005","Ngo Tan E", 2022));
		List<Student> student2 = new ArrayList<Student>();
		student2.add(new Student("006", "Pham Le Van F", 2022));
		
		List<Course> course = new ArrayList<Course>();
		course.add(new Course("2210" , "Xac suat thong ke", "LT", student1, "Thay Le"));
		course.add(new Course("2232", "Toan A1", "LT", student2, "Thay Hung"));
		course.add(new Course("2233", "Toan A2", "LT", student1, "Thay Hung"));
		course.add(new Course("2215" , "Cau truc du lieu", "TH", student1, "Co Tram"));
		course.add(new Course("2222" , "Giao tiep nguoi may", "TH", student1, "Thay Tu"));
		
		Faculty faculty1 = new Faculty("Khoa cong nghe thong tin", "Rang Dong", course);
		
		System.out.println("Course có nhiều sinh viên đăng ký nhất: ");
		System.out.println(faculty1.getMaxPracticalCourse());
		System.out.println("-------------------------------");
		System.out.println(faculty1.groupStudentsByYear());
		System.out.println("-------------------------------");
//		Set<Course> courses = faculty1.filterCourse("LT");
		System.out.println(faculty1.filterCourse("TH"));
	}
}
