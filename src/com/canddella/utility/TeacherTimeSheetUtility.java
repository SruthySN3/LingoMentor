package com.canddella.utility;

import java.util.List;
import java.util.Scanner;

import com.canddella.entity.Student;
import com.canddella.entity.Teacher;
import com.canddella.entity.TeacherTimeSheet;
import com.canddella.service.StudentCurriculumServiceImp;
import com.canddella.service.TeacherTimeSheetServiceImp;

public class TeacherTimeSheetUtility {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		teacherTimeSheetDetails();
	}

	public static void teacherTimeSheetDetails() {
		// TODO Auto-generated method stub
		char selectChoice;
		do {
			Scanner scanner = new Scanner(System.in);
			System.out.println(
					"1.AddTeacherTimeSheet\n 2.Display All Teacher TimeSheet 3.SearchDisplay StudentName By TeacherId");
			int choice = scanner.nextInt();
			if (choice == 1) {
				addToTimeSheet();

			} else if (choice == 2) {
				dispalyAllTimeSheet();
			} else if (choice == 3) {
				getStudentNameByTeacherId();
			}

			System.out.println("do you want continue");
			selectChoice = scanner.next().charAt(0);
		} while (selectChoice == 'y' || selectChoice == 'Y');
	}

	private static void getStudentNameByTeacherId() {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter Teacher ID: ");
		String teacherId = scanner.nextLine();
		StudentCurriculumServiceImp studentCurriculumServiceImp = new StudentCurriculumServiceImp();
		List<Student> students = studentCurriculumServiceImp.getStudentNameByTeacherId(teacherId);

		if (students.isEmpty()) {
			System.out.println("No students found for the given Teacher ID.");
		} else {
			System.out.println("Students taught by Teacher ID " + teacherId + ":");
			for (Student student : students) {
				System.out.println("First Name: " + student.getFirstName());
				System.out.println("-----------------------------------------");
			}
		}
	}

	private static void addToTimeSheet() {
		// TODO Auto-generated method stub
		TeacherTimeSheetServiceImp teacherTimeSheetServiceImp = new TeacherTimeSheetServiceImp();
		Scanner scanner = new Scanner(System.in);
		System.out.println("Teacher Time Sheet");
		System.out.println("Enter the TT-SlNo:");
		String ttSlNo = scanner.nextLine();
		System.out.println("Enter The Available Time:");
		String availableTime = scanner.nextLine();
		System.out.println("Enter The Class Duration:");
		int classDuration = scanner.nextInt();
		scanner.nextLine();

		System.out.println("Availability");
		String teacherAvailability = scanner.nextLine();
		System.out.println("Enter The Teacher_Id");
		String teacherId = scanner.nextLine();
		Teacher teacher = new Teacher();
		teacher.setTeacherId(teacherId);

		teacherTimeSheetServiceImp.addteacherTimeSheet(
				new TeacherTimeSheet(ttSlNo, availableTime, classDuration, teacherAvailability, teacher));
		System.out.println("Added Successfully!");

	}

	private static void dispalyAllTimeSheet() {
		// TODO Auto-generated method stub

		TeacherTimeSheetServiceImp teacherTimeSheetServiceImp = new TeacherTimeSheetServiceImp();
		List<TeacherTimeSheet> teacherTimeSheetsList = teacherTimeSheetServiceImp.listAllTeacherTimeSheet();
		System.out.println("Teacher Time Sheet Details:");
		if (teacherTimeSheetsList.isEmpty()) {
			System.out.println("No details available.");
		} else {
			for (TeacherTimeSheet teacherTimeSheet : teacherTimeSheetsList) {
				System.out.println("TT-SlNo: " + teacherTimeSheet.getTtSlNo());
				System.out.println("Available Time: " + teacherTimeSheet.getAvailableTime());
				System.out.println("Class Duration: " + teacherTimeSheet.getClassDuration());
				System.out.println("Teacher Availability:" + teacherTimeSheet.getTeacherAvailability());
				System.out.println("Teacher Id: " + teacherTimeSheet.getTeacher().getTeacherId());
				System.out.println("-----------------------------------");
			}
		}

	}
}
