package edu.handong.analysis;

import java.util.ArrayList;

import edu.handong.analysis.datamodel.Course;
import edu.handong.analysis.datamodel.Student;

public class HGUCoursePatternAnalyzer {
	
	String[] lines = {	"1999-1, JC Nam, Java Programming",
						"1999-2, JC Nam, Programming Language Theory",
						"1999-1, JC Nam, Data Structures",
						"2001-1, JC Nam, Database Systems",
						"2018-1, SB Lim, Java Programming",
						"2018-2, SB Lim, Programming Language Theory",
						"2019-1, SB Lim, Data Structures",
						"2019-1, SB Lim, Algorithm Analysis",
						"2018-1, SJ Kim, Java Programming",
						"2018-2, SJ Kim, Programming Language Theory",
						"2019-1, SJ Kim, Logic Design",
						"2019-1, SJ Kim, Algorithm Analysis",
						};

	private ArrayList<Student> students = new ArrayList<Student>();
	private ArrayList<Course> courses = new ArrayList<Course>();
	/**
	 * This method runs our analysis logic to get the list of student and course names from lines.
	 * @param args
	 */
	public void run() {
		
	
		initiateStudentArrayFromLines(lines);
		
		System.out.println("Number of All Students: " + students.size());
		
		for(Student student: students) {
			System.out.println(student.getName());
		}
		
		initiateCourseArrayFromLines(lines);
		System.out.println("Number of All Courses: " + courses.size());
		for(Course course: courses) {
			System.out.println(course.getCourseName());
		}
		
	}

	/**
	 * This method returns a Student array to initiate the field, students, from lines.
	 * @param lines
	 * @return
	 */
	private void initiateStudentArrayFromLines(String[] lines) {
		Student st;
		
		for(String line: lines) {
			st = new Student(line.trim().split(", ")[1]);
			if(studentExist(students, st)) {
				students.add(st);
			}
		}
		
	}

	/**
	 * This method check if there is the same name of the second arugement in the array, students
	 * @param students
	 * @param student
	 * @return boolean
	 */
	private boolean studentExist(ArrayList<Student> students, Student student) {
		//null일 때까지 반복
		for(int i = 0; i < students.size(); i++) {
			//만약 같으면 false
			if(students.get(i).getName().equals(student.getName()) == true)
				return false;
		}
		return true;
	}
	
	/**
	 * This method returns a Course array to initiate the field, courses, from lines.
	 * @param lines
	 * @return
	 */
	private void initiateCourseArrayFromLines(String[] lines) {
		Course cs;
		
		for(String line: lines) {
			cs = new Course(line.trim().split(", ")[2]);
			if(courseExist(courses, cs)) {
				courses.add(cs);
			}
		}
	}

	/**
	 * This method check if there is the same name of the second argument in the array, courses.
	 * @param courses
	 * @param course
	 * @return boolean
	 */
	private boolean courseExist(ArrayList<Course> courses, Course course) {
		for(int i = 0; i < courses.size(); i++) {
			//만약 같으면 false
			if(courses.get(i).getCourseName().equals(course.getCourseName()) == true)
				return false;
		}
		return true;
	}

}
