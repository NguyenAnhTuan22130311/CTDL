package Task_01;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

public class Faculty {
	private String name;
	private String address;
	private List<Course> courses;

	public Faculty(String name, String address, List<Course> courses) {
		super();
		this.name = name;
		this.address = address;
		this.courses = courses;
	}

	@Override
	public String toString() {
		return "[ name: " + name + ", address; " + address + ", courses: " + courses + " ]";
	}

	public Course getMaxPracticalCourse() {
		Course maxCourse = null;
		int maxStudents = 0;
		for (Course i : this.courses) {
			int temp = i.getStudents().size();
			if (i.getType().equals("TH") && temp > maxStudents) {
				maxStudents = temp;
				maxCourse = i;
			}
		}
		return maxCourse;
	}

	public Map<Integer, List<Student>> groupStudentsByYear() {
		// Thống kê danh sách sinh viên theo năm vào học
		Map<Integer, List<Student>> groupStudents = new HashMap<Integer, List<Student>>();
		for (Course c : courses) {
			for (Student st : c.getStudents()) {
				int key = st.getYear();
				List<Student> values = new ArrayList<Student>();
				if (!groupStudents.containsKey(key)) {
					values.add(st);
					groupStudents.put(key, values);
				} else {
					values = groupStudents.get(key);
					if (!values.contains(st))
						values.add(st);
				}
				groupStudents.put(key, values);
			}
		}
		return groupStudents;
	}

	public Set<Course> filterCourse(String type) {
		// Tạo một set để chứa các course theo loại cho trước
		TreeSet<Course> courseType = new TreeSet<>(new Comparator<Course>() {
			@Override
			public int compare(Course o1, Course o2) {
				// Săp xếp giảm dần theo số lượng sv đăng ký hc
				return o2.getStudents().size() - o1.getStudents().size();
			}
		});
		for (Course c : courses) {
			if (c.getType().equals(type)) {
				courseType.add(c);
			}
		}
		return courseType;
	}
}
