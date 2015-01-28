package com.mysql.HighSchool;

import com.mysql.dbAccess.DbQuerys;

public class App {

	public static void main(String[] args) {
		DbQuerys logic = new DbQuerys();

		// exercise 4
		int idCourse = 11;

		logic.cleanResult();

		logic.getCourseStudents(idCourse);

		System.out.println(logic.getResult());

		// exercise 5
		int registrationNumber = 1;

		logic.cleanResult();

		logic.getStudentFinals(registrationNumber);

		System.out.println(logic.getResult());
	}
}
