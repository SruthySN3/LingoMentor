package com.canddella.utility;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;

import com.canddella.entity.Student;
import com.canddella.service.StudentService;
import com.canddella.service.StudentServiceImp;

public class StudentUtility {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		studentDetails();
	}

public static void studentDetails() {
		char selectChoice;
		do {
			System.out.println("Select Your Option");
			Scanner scanner = new Scanner(System.in);
			System.out.println("1. Add Student\n2. Update Student\n3. Display All Students\n4. Search Student");
			int choice = scanner.nextInt();
			switch (choice) {
			case 1:
				addStudent();
				System.out.println("Enter Your Details");
				break;
			case 2:
				updateStudent();
				break;
			case 3:
				dispalyAllStudent();
				break;
			case 4:
				searchStudent();
				break;
			default:
				System.out.println("Invalid choice");
			}

			System.out.println("Do you want to continue? ");
			selectChoice = scanner.next().charAt(0);
		} while (selectChoice == 'y' || selectChoice == 'Y');
	}

	private static void addStudent() {
		StudentService studentService = new StudentServiceImp();
		Scanner scanner = new Scanner(System.in);

		System.out.println("Enter Student Details:");
		System.out.print("Student ID: ");
		String studentId = scanner.next();
		System.out.print("First Name: ");
		String firstName = scanner.next();
		System.out.print("Last Name: ");
		String lastName = scanner.next();
		System.out.print("Date of Birth (yyyy-MM-dd): ");
		String dateOfBirthStr = scanner.next();
		LocalDate dateOfBirth = LocalDate.parse(dateOfBirthStr, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
		System.out.print("Gender: ");
		String gender = scanner.next();
		System.out.print("Address: ");
		String address = scanner.next();
		System.out.print("Phone Number: ");
		Long phoneNo = scanner.nextLong();
		scanner.nextLine();
		System.out.print("Email: ");
		String email = scanner.nextLine();

		studentService
				.addStudent(new Student(studentId, firstName, lastName, dateOfBirth, gender, address, phoneNo, email));

		System.out.println("Student added successfully!");
	}

	private static void updateStudent() {
		StudentServiceImp studentServiceImp = new StudentServiceImp();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		Scanner scanner = new Scanner(System.in);

		Student student = searchStudent();

		if (student != null) {
			System.out.println("1. Update Student First Name");
			System.out.println("2. Update Student Last Name");
			System.out.println("3. Update Student Gender");
			System.out.println("4. Update Student Date of Birth");
			System.out.println("5. Update Student Phone Number");
			System.out.println("6.Update Student Address");
			System.out.println("7. Update Student Email");
			int updateChoice = scanner.nextInt();
			scanner.nextLine();

			if (updateChoice == 1) {
				System.out.println("Enter the Student First Name: ");
				String updateFirstName = scanner.nextLine();
				student.setFirstName(updateFirstName);
			} else if (updateChoice == 2) {
				System.out.println("Enter the Student Last Name: ");
				String updateLastName = scanner.nextLine();
				student.setLastName(updateLastName);
			} else if (updateChoice == 3) {
				System.out.println("Enter the Student Gender: ");
				String updateGender = scanner.nextLine();
				student.setGender(updateGender);
			} else if (updateChoice == 4) {
				System.out.println("Enter the Student Date of Birth (yyyy-MM-dd): ");
				String updateDOB = scanner.nextLine();
				LocalDate nUpdateDOB = LocalDate.parse(updateDOB, formatter);
				student.setDateOfBirth(nUpdateDOB);
			} else if (updateChoice == 5) {
				System.out.println("Enter the Student Phone Number: ");
				Long updatePhoneNo = scanner.nextLong();
				scanner.nextLine();
				student.setPhoneNo(updatePhoneNo);
			} else if (updateChoice == 6) {
				System.out.println("Enter The Student Address");
				String address = scanner.nextLine();
				student.setAddress(address);
			} else if (updateChoice == 7) {
				System.out.println("Enter the Student Email: ");
				String updateEmail = scanner.nextLine();
				student.setEmail(updateEmail);
			}

			studentServiceImp.updateStudent(student);

			System.out.println("Updated Successfully!");
		}
	}

	private static Student searchStudent() {
		StudentService studentService = new StudentServiceImp();
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter The Student_Id:");
		String studentId = scanner.next();
		Student student = studentService.searchStudent(studentId);

		if (student != null) {
			System.out.println("Student ID: " + student.getStudentId());
			System.out.println("Name: " + student.getFirstName() + " " + student.getLastName());
			System.out.println("Date of Birth: " + student.getDateOfBirth());
			System.out.println("Gender: " + student.getGender());
			System.out.println("Address: " + student.getAddress());
			System.out.println("Phone Number: " + student.getPhoneNo());
			System.out.println("Email: " + student.getEmail());
		} else {
			System.out.println("Student not found.");
		}
		return student;
	}

	private static void dispalyAllStudent() {
		StudentService studentService = new StudentServiceImp();
		List<Student> studentList = studentService.listAllStudent();
		if (studentList.isEmpty()) {
			System.out.println("No students found.");
		} else {
			System.out.println("Student Details:");
			for (Student student : studentList) {
				System.out.println("Student ID: " + student.getStudentId());
				System.out.println("Name: " + student.getFirstName() + " " + student.getLastName());
				System.out.println("Date of Birth: " + student.getDateOfBirth());
				System.out.println("Gender: " + student.getGender());
				System.out.println("Address: " + student.getAddress());
				System.out.println("Phone Number: " + student.getPhoneNo());
				System.out.println("Email: " + student.getEmail());
				System.out.println("--------------------------------------");
			}
		}
	}
}