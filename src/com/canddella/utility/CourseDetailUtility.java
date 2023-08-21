package com.canddella.utility;

import java.util.List;
import java.util.Scanner;

import com.canddella.entity.Course;
import com.canddella.entity.CourseDetail;
import com.canddella.service.CourseDetailServiceImp;



public class CourseDetailUtility {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		courseOutline();

	}

	public static void courseOutline() {
		// TODO Auto-generated method stub
		char selectChoice;
		do {
			System.out.println("Select Your Option");
			Scanner scanner = new Scanner(System.in);
			System.out.println("1. Add CourseDetail\n2. Update CourseDetail\n3. Display All CourseDetail\n4. Search CourseDetail");
			int choice = scanner.nextInt();
			switch (choice) {
			case 1:
				addCourseDetail();
				System.out.println("Enter Your Details");
				break;
			case 2:
				updateCourseDetail();
				break;
			case 3:
				dispalyAllCourseDetail();
				break;
			case 4:
				searchCourseDetail();
				break;
			default:
				System.out.println("Invalid choice");
			}

			System.out.println("Do you want to continue? ");
			selectChoice = scanner.next().charAt(0);
		} while (selectChoice == 'y' || selectChoice == 'Y');
		
	}



	private static CourseDetail searchCourseDetail() {
		// TODO Auto-generated method stub
		CourseDetailServiceImp courseDetailServiceImp = new CourseDetailServiceImp();
		  Scanner scanner = new Scanner(System.in);
	        System.out.print("Enter the slNo : ");
	        String slNo = scanner.nextLine();

	        CourseDetail courseDetail = courseDetailServiceImp.searchCourseDetail(slNo);
	      if (courseDetail != null) {
				System.out.println("SlNo: " + courseDetail.getCdSlNo());
				System.out.println("Course Code:  "+courseDetail.getCourse().getCourseCode());
				System.out.println("Course Level: " + courseDetail.getLevel());
	        } else {
	            System.out.println("Course Detail found:");
		
	        }
			return courseDetail;
	}

	private static void dispalyAllCourseDetail() {
		// TODO Auto-generated method stub
		 CourseDetailServiceImp courseDetailServiceImp = new CourseDetailServiceImp();
			List<CourseDetail> courseDetailList = courseDetailServiceImp.listAllCourseDetail();

		    if (courseDetailList.isEmpty()) {
		        System.out.println("No course details available.");
		    } else {
		        for (CourseDetail courseDetail : courseDetailList) {
		            System.out.println("Sl No: " + courseDetail.getCdSlNo());
		            System.out.println("Level: " + courseDetail.getLevel());
		            System.out.println("Course Code: " + courseDetail.getCourse().getCourseCode());
		            System.out.println("-----------------------------------");
		        }
		    }
		}
	

	private static void updateCourseDetail() {
		// TODO Auto-generated method stub
		CourseDetailServiceImp courseDetailServiceImp = new CourseDetailServiceImp();

		 Scanner scanner = new Scanner(System.in);
		 CourseDetail courseDetail =searchCourseDetail();
		 if (courseDetail != null) {
				System.out.println("1. Update course level");
				System.out.println("2. Update Course Module");
				System.out.println("3. Course Code");
				 int choice = 0;
				if(choice ==1) {
	        System.out.print("Enter slNo: ");
	        String slNo = scanner.nextLine();
	        scanner.nextLine(); 
	       
	        System.out.print("Enter level: ");
	        String level = scanner.nextLine();
	        courseDetail.setLevel(level);
	        
	        System.out.print("Enter module: ");
	        String module = scanner.nextLine();
	        System.out.print("Enter course code: ");
	        String courseCode = scanner.nextLine();

	        Course course = new Course();
	        course.setCourseCode(courseCode);

	         courseDetail = new CourseDetail(slNo,level,course);
	        courseDetailServiceImp.updateCourseDetail(courseDetail);
	        System.out.println("Course Detail updated successfully!");
	    }
		 }
		
	
	}
	private static void addCourseDetail() {
		// TODO Auto-generated method stub
		CourseDetailServiceImp courseDetailServiceImp = new CourseDetailServiceImp();
		Scanner scanner = new Scanner(System.in);
        System.out.println("Enter Course Detail:");
        System.out.print("Enter slNo: ");
        String slNo = scanner.nextLine();
        scanner.nextLine();
        System.out.print("Enter level: ");
        String level = scanner.nextLine();
        System.out.print("Enter course code: ");
        String courseCode = scanner.nextLine();

        Course course = new Course();
        course.setCourseCode(courseCode);

        courseDetailServiceImp.addCourseDetail(new CourseDetail(slNo, level, course));
        System.out.println("Course Detail added successfully!");
		
	}

}
