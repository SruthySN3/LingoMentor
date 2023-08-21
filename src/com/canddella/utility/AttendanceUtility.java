package com.canddella.utility;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

import com.canddella.entity.AttendanceDetail;
import com.canddella.entity.StudentCurriculum;
import com.canddella.service.AttendanceServiceImp;
import com.canddella.service.StudentCurriculumServiceImp;

public class AttendanceUtility {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		attendanceTrackingDetails();

	}

	public static void attendanceTrackingDetails() {
		char selectChoice;
		do {
			System.out.println("Select Your Option");
			Scanner scanner = new Scanner(System.in);
			System.out.println("1. Add Detail\n2.Display Absent Details\n3. Display All Detail\n4. checkCompletion");
			int choice = scanner.nextInt();
			switch (choice) {
			case 1:
				addDetails();
				break;
			case 2:
				absentDetails();
				break;
			case 3:
				listAllAttendanceDetails();
				break;
			case 4:
				checkCompletionAndProvideCertificate();
				break;
			default:
				System.out.println("Invalid choice");
			}

			System.out.println("Do you want to continue? (y/n)");
			selectChoice = scanner.next().charAt(0);
		} while (selectChoice == 'y' || selectChoice == 'Y');
	}

	private static void checkCompletionAndProvideCertificate() {
		// TODO Auto-generated method stub
		StudentCurriculumServiceImp studentCurriculumServiceImp = new StudentCurriculumServiceImp();
		Scanner scanner = new Scanner(System.in);

		System.out.println("Enter student ID:");
		String studentId = scanner.next();

		LocalDate currentDate = LocalDate.now();
		int curriculumId = 0;
		LocalDate classDate = studentCurriculumServiceImp.getDateFromCurriculum(curriculumId);

		if (classDate != null && currentDate.isAfter(classDate)) {
			System.out.println("Student with ID " + studentId + " has completed the course.");
			System.out.println("Certificate provided for student with ID " + studentId);
		} else {
			System.out.println("Student with ID " + studentId + " has not completed the course yet.");
		}
	}

	private static void absentDetails() {
		// TODO Auto-generated method stub
		StudentCurriculumServiceImp studentCurriculumServiceImp = new StudentCurriculumServiceImp();
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter student ID:");
		String studentId = scanner.nextLine();

		List<LocalDate> absentDates = studentCurriculumServiceImp.getAbsentDatesByStudentId(studentId);

		if (absentDates.isEmpty()) {
			System.out.println("No absent dates found for student " + studentId);
		} else {
			System.out.println("Absent Dates for Student " + studentId + ":");
			for (LocalDate date : absentDates) {
				System.out.println(date);
			}
		}

	}

	private static void addDetails() {
		StudentCurriculumServiceImp studentCurriculumServiceImp = new StudentCurriculumServiceImp();
		AttendanceServiceImp attendanceServiceImp = new AttendanceServiceImp();
		Scanner scanner = new Scanner(System.in);

		System.out.println("AttendanceID:");
		String attendanceId = scanner.nextLine();

		System.out.println("Enter The CurriculumId:");
		int curriculumId = scanner.nextInt();
		scanner.nextLine();

		LocalDate date = studentCurriculumServiceImp.getDateFromCurriculum(curriculumId);

		if (date != null) {
			StudentCurriculum studentCurriculum = new StudentCurriculum();
			studentCurriculum.setSlNo(curriculumId);
			studentCurriculum.setDate(date);

			attendanceServiceImp.addAttendance(new AttendanceDetail(attendanceId, studentCurriculum));
			System.out.println("Added Successfully!");
		} else {
			System.out.println("Curriculum not found or has no valid date.");
		}
	}

	private static void listAllAttendanceDetails() {
		AttendanceServiceImp attendanceServiceImp = new AttendanceServiceImp();
		List<AttendanceDetail> attendanceDetailList = attendanceServiceImp.listAllAttendanceDetails();
		System.out.println("All Attendance Details:");
		if (attendanceDetailList.isEmpty()) {
			System.out.println("No details available.");
		} else {
			for (AttendanceDetail attendanceDetail : attendanceDetailList) {
				System.out.println("AttendanceId: " + attendanceDetail.getAttendanceId());
				System.out.println("SlNo: " + attendanceDetail.getStudentCurriculum().getSlNo());
				System.out.println("Date: " + attendanceDetail.getStudentCurriculum().getDate());
				System.out.println("-----------------------------------");
			}
		}
	}
}