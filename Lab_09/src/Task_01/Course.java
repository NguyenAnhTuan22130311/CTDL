package Task_01;

import java.util.List;

public class Course {
	private String id;
	private String title;
	private String type;
	private List<Student> students;
	private String lecture;
	public Course(String id, String title, String type, List<Student> students, String lecture) {
		super();
		this.id = id;
		this.title = title;
		this.type = type;
		this.students = students;
		this.lecture = lecture;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public List<Student> getStudents() {
		return students;
	}
	public void setStudents(List<Student> students) {
		this.students = students;
	}
	public String getLecture() {
		return lecture;
	}
	public void setLecture(String lecture) {
		this.lecture = lecture;
	}
	
	@Override
	public String toString() {
		return "[ id: " + id + ", title: " + title + ", type: " + type + ", students: " + students + ", lecture: "
				+ lecture + " ]";
	}
}
