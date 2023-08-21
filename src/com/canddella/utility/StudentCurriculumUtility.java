package com.canddella.utility;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.canddella.entity.Course;
import com.canddella.entity.EnrollmentDetails;
import com.canddella.entity.ModuleDetails;
import com.canddella.entity.Student;
import com.canddella.entity.StudentCurriculum;
import com.canddella.entity.Teacher;
import com.canddella.service.ModuleDetailServiceImp;
import com.canddella.service.StudentCurriculumServiceImp;
import com.canddella.service.TeacherTimeSheetServiceImp;

public class StudentCurriculumUtility {

	public static void createCurriculum(EnrollmentDetails enrollmentDetails) {
		DateTimeFormatter formater = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm:ss");
		StudentCurriculumServiceImp studentCurriculumServiceImp = new StudentCurriculumServiceImp();

		String courseCode = enrollmentDetails.getCourse().getCourseCode();

		Course course = new Course(courseCode);
		String studentId = enrollmentDetails.getStudent().getStudentId();
		Student student = new Student(studentId);
		TeacherTimeSheetServiceImp teacherTimeSheetServiceImp = new TeacherTimeSheetServiceImp();
		ModuleDetailServiceImp moduleDetailServiceImp = new ModuleDetailServiceImp();

		List<Teacher> teacherList = teacherTimeSheetServiceImp.checkAvailability(enrollmentDetails.getPreferredTime());

		for (Teacher teacher : teacherList) {
			System.out.println(teacher.getTeacherId());
		}

		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter The TeacherId:");
		String teacherId = scanner.nextLine();
		Teacher teacher = new Teacher(teacherId);

		System.out.println("Enter The Date (yyyy-MM-dd)::");
		String date = scanner.nextLine();
		LocalDate currentDate = LocalDate.parse(date, formater);

		System.out.println("Enter The Time (HH:mm:ss):");
		String Time = scanner.nextLine();
		LocalTime localTime = LocalTime.parse(Time, timeFormatter);
		int numberOfDays = 7;

		List<ModuleDetails> moduleDetailsList = moduleDetailServiceImp.getModuleDetails(courseCode);
		for (ModuleDetails moduleDetails : moduleDetailsList) {

			StudentCurriculum studentCurriculum = new StudentCurriculum(currentDate, localTime, student, course,
					teacher, moduleDetails);
			studentCurriculumServiceImp.addDetailsIntoStudentCurriculum(studentCurriculum);
			currentDate = currentDate.plusDays(1);
		}

	}

	public static List<LocalDate> getAbsentDatesForStudent(Student student) {
		List<LocalDate> absentDates = new ArrayList<>();

		StudentCurriculumServiceImp studentCurriculumServiceImp = new StudentCurriculumServiceImp();

		absentDates = studentCurriculumServiceImp.getAbsentDatesByStudentId(student.getStudentId());

		return absentDates;
	}

	public static void listAllCurriculumDetailsByStudentId(String studentId) {
		StudentCurriculumServiceImp studentCurriculumServiceImp = new StudentCurriculumServiceImp();
		List<StudentCurriculum> studentCurriculumList = studentCurriculumServiceImp
				.getCurriculumDetailsByStudentId(studentId);

		if (studentCurriculumList.isEmpty()) {
			System.out.println("No curriculum found for the student.");
		} else {
			System.out.println("Student Curriculum:");
			for (StudentCurriculum curriculum : studentCurriculumList) {
				Course course = curriculum.getCourse();
				String courseCode = (course != null) ? course.getCourseCode() : "N/A";

				ModuleDetails moduleDetails = curriculum.getModuleDetails();
				String moduleId = (moduleDetails != null) ? moduleDetails.getModuleId() : "N/A";

				Teacher teacher = curriculum.getTeacher();
				String teacherId = (teacher != null) ? teacher.getTeacherId() : "N/A";

				System.out.println("Date: " + curriculum.getDate() + ", Time: " + curriculum.getTime() + ", Course: "
						+ courseCode + ", Module: " + moduleId + ", Teacher: " + teacherId);
			}
		}

	}

	public static void listAllCurriculumDetailsByStudentId() {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter Student ID: ");
		String studentId = scanner.nextLine();
		listAllCurriculumDetailsByStudentId(studentId);
	}
}
