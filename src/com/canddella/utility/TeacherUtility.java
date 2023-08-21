package com.canddella.utility;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;

import com.canddella.entity.StudentCurriculum;
import com.canddella.entity.Teacher;
import com.canddella.service.TeacherService;
import com.canddella.service.TeacherServiceImp;

public class TeacherUtility {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		teacherDetails();

	}

public static void teacherDetails() {
		// TODO Auto-generated method stub
		char selectChoice;
		do {
			Scanner scanner = new Scanner(System.in);
			System.out.println("1.AddTeacher\n 2.Update Teacher 3.Display All Teacher 4.Search");
			int choice = scanner.nextInt();
			if (choice == 1) {
				addTeacher();

			} else if (choice == 2) {
				updateTeacher();
			} else if (choice == 3) {
				dispalyAllTeacher();
			}
			else if(choice==4) {
				searchTeacher();
			}

			System.out.println("do you want continue");
			selectChoice = scanner.next().charAt(0);
		} while (selectChoice == 'y' || selectChoice == 'Y');
	}

	private static void addTeacher() {
		// TODO Auto-generated method stub
		TeacherServiceImp teacherServiceImp = new TeacherServiceImp();
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter Teacher Details:");
		System.out.print("Teacher ID: ");
		String teacherId = scanner.nextLine();
		System.out.print("First Name: ");
		String firstName = scanner.nextLine();
		System.out.print("Last Name: ");
		String lastName = scanner.nextLine();
		System.out.print("Date of Birth (yyyy-MM-dd): ");
		String dateOfBirthStr = scanner.nextLine();
		LocalDate dateOfBirth = LocalDate.parse(dateOfBirthStr, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
		System.out.print("Gender: ");
		String gender = scanner.nextLine();
		System.out.print("Address: ");
		String address = scanner.nextLine();
		System.out.print("Phone Number: ");
		Long phoneNo = scanner.nextLong();
		scanner.nextLine();
		System.out.print("Email: ");
		String email = scanner.nextLine();
		System.out.print("Experience: ");
		String experience = scanner.nextLine();

		teacherServiceImp.addTeacher(
				new Teacher(teacherId, firstName, lastName, dateOfBirth, gender, address, phoneNo, email, experience));

		System.out.println("Teacher added successfully!");

	}

	private static void updateTeacher() {
		// TODO Auto-generated method stub
		TeacherServiceImp teacherServiceImp = new TeacherServiceImp();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		Scanner scanner = new Scanner(System.in);

		Teacher teacher = searchTeacher();

		if (teacher != null) {
			System.out.println("1. Update Teacher First Name");
			System.out.println("2. Update Teacher Last Name");
			System.out.println("3. Update Teacher Gender");
			System.out.println("4. Update Teacher Date of Birth");
			System.out.println("5. Update Teacher Phone Number");
			System.out.println("6.Update Teacher Address");
			System.out.println("7. Update Teacher Email");
			System.out.println("8.Update Teacher Experience");
			int updateChoice = scanner.nextInt();
			scanner.nextLine();

			if (updateChoice == 1) {
				System.out.println("Enter the Teacher First Name: ");
				String updateFirstName = scanner.nextLine();
				teacher.setFirstName(updateFirstName);
			} else if (updateChoice == 2) {
				System.out.println("Enter the Teacher Last Name: ");
				String updateLastName = scanner.nextLine();
				teacher.setLastName(updateLastName);
			} else if (updateChoice == 3) {
				System.out.println("Enter the Teacher Gender: ");
				String updateGender = scanner.nextLine();
				teacher.setGender(updateGender);
			} else if (updateChoice == 4) {
				System.out.println("Enter the Teacher Date of Birth (yyyy-MM-dd): ");
				String updateDOB = scanner.nextLine();
				LocalDate nUpdateDOB = LocalDate.parse(updateDOB, formatter);
				teacher.setDateOfBirth(nUpdateDOB);
			} else if (updateChoice == 5) {
				System.out.println("Enter the Teacher Phone Number: ");
				Long updatePhoneNo = scanner.nextLong();
				scanner.nextLine();
				teacher.setPhoneNo(updatePhoneNo);
			} else if (updateChoice == 6) {
				System.out.println("Enter the Teacher Address");
				String updateAddress = scanner.nextLine();
				teacher.setAddress(updateAddress);
			}

			else if (updateChoice == 7) {
				System.out.println("Enter the Teacher Email: ");
				String updateEmail = scanner.nextLine();
				teacher.setEmail(updateEmail);
			}

			else if (updateChoice == 8) {
				System.out.println("Enter The Teacher Experience");
				String updateExperience = scanner.nextLine();
				teacher.setExperience(updateExperience);
			}
			teacherServiceImp.updateTeacher(teacher);

			System.out.println("Updated Successfully!");
		}
	}

	private static Teacher searchTeacher() {
		// TODO Auto-generated method stub
		TeacherService teacherService = new TeacherServiceImp();
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter The Teacher_Id:");
		String teacherId = scanner.next();
		Teacher teacher = teacherService.searchTeacher(teacherId);

		if (teacher != null) {
			System.out.println("Teacher ID: " + teacher.getTeacherId());
			System.out.println("Name: " + teacher.getFirstName() + " " + teacher.getLastName());
			System.out.println("Date of Birth: " + teacher.getDateOfBirth());
			System.out.println("Gender: " + teacher.getGender());
			System.out.println("Address: " + teacher.getAddress());
			System.out.println("Phone Number: " + teacher.getPhoneNo());
			System.out.println("Email: " + teacher.getEmail());
			System.out.println("Experience: " + teacher.getExperience());
		} else {
			System.out.println("Teacher not found.");
		}
		return teacher;

	}

	private static void dispalyAllTeacher() {
		// TODO Auto-generated method stub
		TeacherService teacherService = new TeacherServiceImp();
		List<Teacher> teacherList = teacherService.listAllTeacher();
		for (Teacher teacher : teacherList) {
			System.out.println(teacher.getTeacherId() + "  " + teacher.getFirstName() + "  " + teacher.getLastName()
					+ "   " + teacher.getDateOfBirth() + "  " + teacher.getGender() + "   " + teacher.getAddress()
					+ "   " + teacher.getPhoneNo() + "  " + teacher.getEmail() + "   " + teacher.getExperience());
		}
	}

}
