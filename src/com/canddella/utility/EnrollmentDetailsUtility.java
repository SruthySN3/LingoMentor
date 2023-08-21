package com.canddella.utility;

import java.util.List;
import java.util.Scanner;

import com.canddella.entity.Course;
import com.canddella.entity.EnrollmentDetails;
import com.canddella.entity.Student;
import com.canddella.service.EnrollmentDetailsServiceImp;

public class EnrollmentDetailsUtility {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		enrollment();
	}

	public static void enrollment() {
		// TODO Auto-generated method stub
		char selectChoice;
		do {
			Scanner scanner = new Scanner(System.in);
			System.out.println("Select Your Option");

			System.out.println("1. To Enroll Detail\n2. Display All Detail");
			int choice = scanner.nextInt();

			switch (choice) {
			case 1:
				addEnrollmentDetails();
				break;
			case 2:
				dispalyAllEnrollmentDetails();
				break;
			// Add other cases if needed
			default:
				System.out.println("Invalid choice");
			}

			System.out.println("Do you want to continue? (y/n)");
			selectChoice = scanner.next().charAt(0);

			// Consume the newline character
			scanner.nextLine();
		} while (selectChoice == 'y' || selectChoice == 'Y');
	}

	private static void dispalyAllEnrollmentDetails() {
		 EnrollmentDetailsServiceImp enrollmentDetailsServiceImp = new EnrollmentDetailsServiceImp();
		    List<EnrollmentDetails> enrollmentDetailsList = enrollmentDetailsServiceImp.listAllEnrollmentDetails();
		    System.out.println("All Enrollment Details:");

		    if (enrollmentDetailsList.isEmpty()) {
		        System.out.println("No details available.");
		    } else {
		        for (EnrollmentDetails enrollmentDetails : enrollmentDetailsList) {
		            System.out.println("EnrollmentId: " + enrollmentDetails.getEnrollmentId());
		            System.out.println("Preferred Time: " + enrollmentDetails.getPreferredTime());
		            System.out.println("StudentId: " + enrollmentDetails.getStudent().getStudentId());
		            System.out.println("CourseCode: " + enrollmentDetails.getCourse().getCourseCode());
		            System.out.println("-----------------------------------");

		            // List curriculum details for the corresponding student
		            StudentCurriculumUtility.listAllCurriculumDetailsByStudentId(enrollmentDetails.getStudent().getStudentId());
		            
		        }
		        
		    }
		}

	private static void addEnrollmentDetails() {
		// TODO Auto-generated method stub
		EnrollmentDetailsServiceImp enrollmentDetailsServiceImp = new EnrollmentDetailsServiceImp();
		Scanner scanner = new Scanner(System.in);

		System.out.println("Enrollment Details");

		System.out.print("EnrollmentId: ");
		String enrollmentId = scanner.nextLine();

		System.out.print("Preferred Time: ");
		String preferredTime = scanner.nextLine();

		System.out.print("StudentId: ");
		String studentId = scanner.nextLine();

		Student student = new Student();
		student.setStudentId(studentId);

		System.out.print("CourseCode: ");
		String courseCode = scanner.nextLine();

		Course course = new Course();
		course.setCourseCode(courseCode);

		EnrollmentDetails enrollmentDetails = new EnrollmentDetails(enrollmentId, preferredTime, student, course);
		enrollmentDetailsServiceImp.addEnrollmentDetails(enrollmentDetails);

		StudentCurriculumUtility.createCurriculum(enrollmentDetails);
	}

}
