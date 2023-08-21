package com.canddella.utility;

import java.util.List;
import java.util.Scanner;

import com.canddella.entity.Course;
import com.canddella.service.CourseServiceImp;

public class CourseUtility {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		courseDetails();
	}

	public static void courseDetails() {
		// TODO Auto-generated method stub
		char selectChoice;
		do {
			System.out.println("Select Your Option");
			Scanner scanner = new Scanner(System.in);
			System.out.println("1. Add Course\n2. Update Course\n3. Display All Course\n4. Search Course");
			int choice = scanner.nextInt();
			switch (choice) {
			case 1:
				addCourse();

				break;
			case 2:
				updateCourse();
				break;
			case 3:
				dispalyAllCourse();
				break;
			case 4:
				searchCourse();
				break;
			default:
				System.out.println("Invalid choice");
			}

			System.out.println("Do you want to continue? ");
			selectChoice = scanner.next().charAt(0);
		} while (selectChoice == 'y' || selectChoice == 'Y');

	}

	private static void addCourse() {
		// TODO Auto-generated method stub
		CourseServiceImp courseServiceImp = new CourseServiceImp();
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter The Course Details");
		System.out.println("Enter The Course Code:");
		String courseCode = scanner.nextLine();
		System.out.println("Enter The Course Name:");
		String courseName = scanner.nextLine();
		System.out.println("Enter The Course Duration:");
		String courseDuration = scanner.nextLine();
		System.out.println("Enter The Course Fee:");
		Long courseFee = scanner.nextLong();

		courseServiceImp.addCourse(new Course(courseCode, courseName, courseDuration, courseFee));
		System.out.println("Added Successfully!");

	}

	private static void updateCourse() {
		// TODO Auto-generated method stub
		CourseServiceImp courseServiceImp = new CourseServiceImp();
		Scanner scanner = new Scanner(System.in);

		Course course = searchCourse();

		if (course != null) {
			System.out.println("1. Update Course Name");
			System.out.println("2. Update Course Duration");
			System.out.println("3. Update Course Fee");

			int updateChoice = scanner.nextInt();
			scanner.nextLine();

			if (updateChoice == 1) {
				System.out.println("Enter the Course Name: ");
				String updateCourseName = scanner.nextLine();
				course.setCourseName(updateCourseName);
			} else if (updateChoice == 2) {
				System.out.println("Enter the Course Duration: ");
				String updateCourseDuration = scanner.nextLine();
				course.setCourseDuration(updateCourseDuration);
			} else if (updateChoice == 3) {
				System.out.println("Enter the Course Fee: ");
				Long updateCourseFee = scanner.nextLong();
				course.setCourseFee(updateCourseFee);

			}
			courseServiceImp.updateCourse(course);

			System.out.println("Updated Successfully!");
		}
	}

	private static Course searchCourse() {
		// TODO Auto-generated method stub
		CourseServiceImp courseServiceImp = new CourseServiceImp();
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter The Course_Code:");
		String courseCode = scanner.next();
		Course course = courseServiceImp.searchCourse(courseCode);

		if (course != null) {
			System.out.println("Course Code: " + course.getCourseCode());
			System.out.println("Course Name: " + course.getCourseName());
			System.out.println("Course Duration: " + course.getCourseDuration());
			System.out.println("Course Fee: " + course.getCourseFee());

		} else {
			System.out.println("Course not found.");
		}
		return course;
	}

	private static void dispalyAllCourse() {
		// TODO Auto-generated method stub
		CourseServiceImp courseServiceImp = new CourseServiceImp();
		List<Course> courseList = courseServiceImp.listAllCourse();
		if (courseList.isEmpty()) {
			System.out.println("No Course found.");
		} else {
			System.out.println("Course Details:");
			for (Course course : courseList) {
				System.out.println("Course Code: " + course.getCourseCode());
				System.out.println("Course Name: " + course.getCourseName());
				System.out.println("Course Duration: " + course.getCourseDuration());
				System.out.println("Course Fee: " + course.getCourseFee());

				System.out.println("--------------------------------------");
			}
		}
	}

}
