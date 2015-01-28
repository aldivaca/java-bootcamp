package com.mysql.dbAccess;

import java.sql.ResultSet;
import java.sql.SQLException;

public class DbQuerys extends DbAccess {

	StringBuilder result = new StringBuilder("");

	public void getStudentFinals(int registrationNumber) {
		String queryStudentFinals = "SELECT cr.name,  stcr.final FROM course cr ";
		queryStudentFinals += "JOIN studentcourse stcr ON cr.idCourse=stcr.idCourse ";
		queryStudentFinals += "JOIN student st ON st.registration_number=stcr.registration_number";
		queryStudentFinals += "WHERE stcr.registration_number=" + registrationNumber + " ORDER BY stcr.final DESC";

		getStudent(registrationNumber);
		openConnection();
		super.setQuery(queryStudentFinals);
		ResultSet rs = getResultsFromQuery();
		closeConnection();
		try {
			while (rs.next()) {

				String course = rs.getString(0);
				int finalNote = rs.getInt(1);
				result.append(course + "\t" + finalNote);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void getTeacher(int idTeacher) {
		String queryStudent = "SELECT * FROM teacher tc WHERE tc.idTeacher=" + idTeacher;

		openConnection();
		super.setQuery(queryStudent);
		ResultSet rs = getResultsFromQuery();
		closeConnection();
		try {
			while (rs.next()) {

				int id = rs.getInt(0);
				String firstName = rs.getString(1);
				String lastName = rs.getString(2);
				result.append("Teacher: " + lastName);
				result.append(", " + firstName);
				result.append("\t IdTeacher: " + id + " \n");

			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void getStudent(int registrationNumber) {
		String queryStudent = "SELECT * FROM student st WHERE st.registration_number=" + registrationNumber;

		openConnection();
		super.setQuery(queryStudent);
		ResultSet rs = getResultsFromQuery();
		closeConnection();
		try {
			while (rs.next()) {

				int id = rs.getInt(0);
				String firstName = rs.getString(1);
				String lastName = rs.getString(2);
				result.append("<" + lastName);
				result.append(", " + firstName + "> \t");
				result.append("Registration Number: " + id + " \n");

			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void getCourse(int idCourse) {
		String queryCourse = "SELECT * FROM course cr WHERE cr.idCourse=" + idCourse;

		openConnection();
		super.setQuery(queryCourse);
		ResultSet rs = getResultsFromQuery();
		closeConnection();
		try {
			while (rs.next()) {

				String name = rs.getString(1);
				int teacher = rs.getInt(2);
				result.append("Course: " + name + "\n");
				getTeacher(teacher);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void getCourseStudents(int idCourse) {
		String queryCourseStudents = "SELECT * FROM studentcourse stcr WHERE stcr.idCourse=" + idCourse;

		getCourse(idCourse);
		openConnection();
		super.setQuery(queryCourseStudents);
		ResultSet rs = getResultsFromQuery();
		closeConnection();
		try {
			result.append("Students: \n");
			while (rs.next()) {

				int student = rs.getInt(1);
				getStudent(student);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public String getResult() {
		return result.toString();
	}

	public void cleanResult() {
		result.setLength(0);
	}
}
