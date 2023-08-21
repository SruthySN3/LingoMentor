package com.canddella.entity;

public class ModuleDetails {

	private String moduleId;
	private String moduleName;
	private String moduleDescription;
	private int time;
	private CourseDetail courseDetail;
	private Course course;

	public ModuleDetails(String moduleId, String moduleName, String moduleDescription, int time,
			CourseDetail courseDetail, Course course) {
		super();
		this.moduleId = moduleId;
		this.moduleName = moduleName;
		this.moduleDescription = moduleDescription;
		this.time = time;
		this.courseDetail = courseDetail;
		this.course = course;
	}

	public ModuleDetails(String moduleId2, String moduleName2, String moduleDescription2, int time2,
			CourseDetail courseDetail2, String courseCode) {
		// TODO Auto-generated constructor stub
	}

	public ModuleDetails() {
		// TODO Auto-generated constructor stub
	}

	public ModuleDetails(String moduleId2) {
		// TODO Auto-generated constructor stub
	}

	public String getModuleId() {
		return moduleId;
	}

	public void setModuleId(String moduleId) {
		this.moduleId = moduleId;
	}

	public String getModuleName() {
		return moduleName;
	}

	public void setModuleName(String moduleName) {
		this.moduleName = moduleName;
	}

	public String getModuleDescription() {
		return moduleDescription;
	}

	public void setModuleDescription(String moduleDescription) {
		this.moduleDescription = moduleDescription;
	}

	public int getTime() {
		return time;
	}

	public void setTime(int time) {
		this.time = time;
	}

	public CourseDetail getCourseDetail() {
		return courseDetail;
	}

	public void setCourseDetail(CourseDetail courseDetail) {
		this.courseDetail = courseDetail;
	}

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}
}