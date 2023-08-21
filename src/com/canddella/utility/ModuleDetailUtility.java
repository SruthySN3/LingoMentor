package com.canddella.utility;

import java.util.List;
import java.util.Scanner;

import com.canddella.entity.Course;
import com.canddella.entity.CourseDetail;
import com.canddella.entity.ModuleDetails;
import com.canddella.service.CourseDetailServiceImp;
import com.canddella.service.ModuleDetailServiceImp;

public class ModuleDetailUtility {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		moduleDetails();

	}

	public static void moduleDetails() {
		// TODO Auto-generated method stub
		char selectChoice;
		do {
			System.out.println("Select Your Option");
			Scanner scanner = new Scanner(System.in);
			System.out.println(
					"1. Add ModuleDetail\n2. Update ModuleDetail\n3. Display All ModuleDetail\n4. Search CourseDetail");
			int choice = scanner.nextInt();
			switch (choice) {
			case 1:
				addModuleDetails();
				System.out.println("Enter Your Details");
				break;
			case 2:
				updateModuleDetails();
				break;
			case 3:
				dispalyAllModuleDetails();
				break;
			case 4:
				searchModuleDetails();
				break;
			default:
				System.out.println("Invalid choice");
			}

			System.out.println("Do you want to continue? ");
			selectChoice = scanner.next().charAt(0);
		} while (selectChoice == 'y' || selectChoice == 'Y');
	}

	private static void addModuleDetails() {
		// TODO Auto-generated method stub
		ModuleDetailServiceImp moduleDetailSerivceImp = new ModuleDetailServiceImp();
		Scanner scanner = new Scanner(System.in);
		System.out.println("Module Detail");
		System.out.print("Enter Module Id: ");
		String moduleId = scanner.nextLine();
		scanner.nextLine();
		System.out.println("Enter The ModuleName:");
		String moduleName = scanner.nextLine();
		scanner.nextLine();
		System.out.print("Module Description: ");
		String moduleDescription = scanner.nextLine();
		System.out.print("Time: ");
		int time = scanner.nextInt();
		scanner.nextLine();
		System.out.print("Enter course SlNo: ");
		String cdSlNo = scanner.nextLine();
		CourseDetail courseDetail = new CourseDetail();
		courseDetail.setCdSlNo(cdSlNo);
		System.out.println("Enter The Course Code:");
		String courseCode = scanner.nextLine();
		Course course = new Course();
		course.setCourseCode(courseCode);

		moduleDetailSerivceImp.addmoduleDetails(
				new ModuleDetails(moduleId, moduleName, moduleDescription, time, courseDetail, courseCode));
		System.out.println("Added Successfully!");

	}

	private static void dispalyAllModuleDetails() {
		// TODO Auto-generated method stub
		ModuleDetailServiceImp ModuleDetailServiceImp = new ModuleDetailServiceImp();
		List<ModuleDetails> moduleDetailList = ModuleDetailServiceImp.listAllModuleDetails();

		if (moduleDetailList.isEmpty()) {
			System.out.println("No course details available.");
		} else {
			for (ModuleDetails moduleDetails : moduleDetailList) {

				System.out.println("Module Id: " + moduleDetails.getModuleId());
				System.out.println("Module Name:" + moduleDetails.getModuleName());
				System.out.println("Module Description: " + moduleDetails.getModuleDescription());
				System.out.println("Time: " + moduleDetails.getTime());
				System.out.println("CourseDetailsSlNo: " + moduleDetails.getCourseDetail().getCdSlNo());
				System.out.println("CourseCode:" + moduleDetails.getCourse().getCourseCode());
				System.out.println("-----------------------------------");
			}
		}

	}

	private static void searchModuleDetails() {
		// TODO Auto-generated method stub

	}

	private static void updateModuleDetails() {
		// TODO Auto-generated method stub

	}
}