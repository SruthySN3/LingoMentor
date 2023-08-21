package com.canddella.utility;

import java.util.Scanner;

import com.canddella.entity.EnrollmentDetails;
import com.canddella.entity.LoginDetail;
import com.canddella.entity.Student;
import com.canddella.service.LoginServiceImp;

public class MainUtility {

	public static void main(String[] args) {
		lingoMentorLoginMenu();
	}

	private static void lingoMentorLoginMenu() {
		char selectChoice;
		do {
			System.out.println("              " + " --LingoMentor-- " + "              ");
			System.out.println(
					"              " + "Learning is a journey, and with each step, we grow wiser." + "              ");
			Scanner scanner = new Scanner(System.in);
			System.out.println("1. SignUp\n2. Login");
			System.out.println("Don't have an account? Sign up");
			int choice = scanner.nextInt();
			switch (choice) {
			case 1:
				signUpDetails();
				break;
			case 2:
				login();
				break;
			default:
				System.out.println("Invalid choice");
			}
			System.out.println("Do you want to continue? (y/n)");
			selectChoice = scanner.next().charAt(0);
		} while (selectChoice == 'y' || selectChoice == 'Y');
	}

	private static void signUpDetails() {
		LoginServiceImp loginServiceImp = new LoginServiceImp();
		Scanner scanner = new Scanner(System.in);
		System.out.println("Welcome to LingoMentor!");
		System.out.println("Enter Your User Name:");
		String userName = scanner.next();
		System.out.println("Enter Your Password:");
		String password = scanner.next();
		System.out.println("Enter Your Role (admin/teacher/student):");
		String userRole = scanner.next();

		loginServiceImp.addUserDetail(new LoginDetail(-1, userName, password, userRole));

		System.out.println("Thank you for signing up.\nTo continue, login with your UserName & Password");
	}

	private static void login() {
		LoginServiceImp loginServiceImp = new LoginServiceImp();

		Scanner scanner = new Scanner(System.in);
		boolean isLoginValid = false;

		while (!isLoginValid) {
			System.out.println("Enter Your UserName:");
			String userName = scanner.next();
			System.out.println("Enter Your Password:");
			String password = scanner.next();

			LoginDetail loginDetail = loginServiceImp.getUserRoleByUserName(userName, password);

			if (loginDetail != null) {
				String userRole = loginDetail.getUserRole();
				System.out.println("UserRole: " + userRole);

				switch (userRole.toLowerCase()) {
				case "admin":
					adminMenu();
					isLoginValid = true;
					break;
				case "teacher":
					teacherMenu();
					isLoginValid = true;
					break;
				case "student":
					studentMenu();
					isLoginValid = true;
					break;
				default:
					System.out.println("Invalid user role.");
				}
			} else {
				System.out.println("Invalid username or password. Please try again.");
			}
		}
	}

	private static void adminMenu() {
		char selectChoice;
		do {
			Scanner scanner = new Scanner(System.in);
			System.out.println("Welcome, Admin!");
			System.out.println(
					"1. Course\n2. CourseDetails\n3. Module Details\n4. Student\n5. Enrollment\n6. Teacher\n7. TeacherTimeSheet\n8. AttendanceDetail");
			System.out.println("Enter Your Choice:");
			int choice = scanner.nextInt();

			switch (choice) {
			case 1:
				CourseUtility.courseDetails();
				break;
			case 2:
				CourseDetailUtility.courseOutline();
				break;
			case 3:
				ModuleDetailUtility.moduleDetails();
				break;
			case 4:
				StudentUtility.studentDetails();
				break;
			case 5:
				EnrollmentDetailsUtility.enrollment();
				break;
			case 6:
				TeacherUtility.teacherDetails();
				break;
			case 7:
				TeacherTimeSheetUtility.teacherTimeSheetDetails();
				break;
			case 8:
				AttendanceUtility.attendanceTrackingDetails();
				break;

			default:
				System.out.println("Invalid choice");
			}

			System.out.println("Do you want to continue in Admin Menu? (y/n)");
			selectChoice = scanner.next().charAt(0);
		} while (selectChoice == 'y' || selectChoice == 'Y');

		lingoMentorLoginMenu();
	}

	private static void teacherMenu() {
		// Implement teacher menu
		char selectChoice;
		do {
			Scanner scanner = new Scanner(System.in);
			System.out.println("Welcome, Teacher!");
			System.out.println("1. Teacher Details\n2.TeacherTimeSheet");
			System.out.println("Enter Your Choice:");
			int choice = scanner.nextInt();
			switch (choice) {
			case 1:
				TeacherUtility.teacherDetails();
				break;
			case 2:
				TeacherTimeSheetUtility.teacherTimeSheetDetails();
				break;
			case 3:
				StudentCurriculumUtility.listAllCurriculumDetailsByStudentId();
			break;
			default:
				System.out.println("Invalid choice");
			}

			System.out.println("Do you want to continue in Teacher Menu? (y/n)");
			selectChoice = scanner.next().charAt(0);
		} while (selectChoice == 'y' || selectChoice == 'Y');

		lingoMentorLoginMenu();

	}

	private static void studentMenu() {
		// Implement student menu
		char selectChoice;
		do {
			Scanner scanner = new Scanner(System.in);
			System.out.println("Welcome, Student!");
			System.out.println("1. Student Details\n2.Enrollment\n3.StudentCurriculum \n4.View Attendance");
			System.out.println("Enter Your Choice:");
			int choice = scanner.nextInt();
			switch (choice) {
			case 1:
				StudentUtility.studentDetails();
				break;
			case 2:
				EnrollmentDetailsUtility.enrollment();
				break;
			case 3:
				StudentCurriculumUtility.listAllCurriculumDetailsByStudentId();
				break;
			case 4:
				AttendanceUtility.attendanceTrackingDetails();
			default:
				System.out.println("Invalid choice");
			}

			System.out.println("Do you want to continue in Student Menu? (y/n)");
			selectChoice = scanner.next().charAt(0);
		} while (selectChoice == 'y' || selectChoice == 'Y');

		lingoMentorLoginMenu();

	}
}
