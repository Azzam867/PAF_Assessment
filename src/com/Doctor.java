package com;

import java.sql.*;

public class Doctor {

	private Connection connect() {
		Connection con = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/test", "root", "");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return con;
	}

	public String addDoctor(String doctorid, String doctorName, String email, String specialist, String phone) {
		String output = "";
		try {
			Connection con = connect();
			if (con == null) {
				return "Error nothing in the database.";
			}

			String query = " insert into doctor(`doctorid`,`doctorName`,`email`,`specialist`,`phone)"
					+ " values (?, ?, ?, ?, ?)";
			PreparedStatement preparedStmt = con.prepareStatement(query);

			preparedStmt.setString(1, doctorid);
			preparedStmt.setString(2, doctorName);
			preparedStmt.setString(3, email);
			preparedStmt.setString(4, specialist);
			preparedStmt.setString(5, phone);

			preparedStmt.execute();
			con.close();
			output = "Inserted successfully";
		} catch (Exception e) {
			output = "Error while inserting the item.";
			System.err.println(e.getMessage());
		}
		return output;
	}

	public String getDoctor() {
		String output = "";
		try {
			Connection con = connect();
			if (con == null) {
				return "Error while connecting to the database for reading.";
			}

			output = "<table border=\"1\"><tr><th>doctorid</th>" + "<th>doctorName</th><th>email</th>"
					+ "<th>specialist</th><th>phone</th>";
			String query = "select * from doctor";
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			while (rs.next()) {
				String doctorid = rs.getString("doctorid");
				String doctorName = rs.getString("doctorName");
				String email = rs.getString("email");
				String specialist = rs.getString("specialist");
				String phone = rs.getString("phone");

				output += "<tr><td>" + doctorid + "</td>";
				output += "<td>" + doctorName + "</td>";
				output += "<td>" + email + "</td>";
				output += "<td>" + specialist + "</td>";
				output += "<td>" + phone + "</td>";

			}
			con.close();

			output += "</table>";
		} catch (Exception e) {
			output = "Error while reading the items.";
			System.err.println(e.getMessage());
		}
		return output;
	}

	public String updateDoctor(String doctorid, String doctorName, String email, String specialist, String phone)

	{
		String output = "";
		try {
			Connection con = connect();
			if (con == null) {
				return "Error while connecting to the database for updating.";
			}

			String query = "UPDATE doctor SET doctorid=?, doctorName=?, email=?, specialist=?, phone=?,   WHERE doctorid=?";
			PreparedStatement preparedStmt = con.prepareStatement(query);

			preparedStmt.setString(1, doctorid);
			preparedStmt.setString(2, doctorName);
			preparedStmt.setString(3, email);
			preparedStmt.setString(4, specialist);
			preparedStmt.setString(5, phone);

			preparedStmt.execute();
			con.close();
			output = "Updated successfully";
		} catch (Exception e) {
			output = "Error while updating a doctor details.";
			System.err.println(e.getMessage());
		}
		return output;
	}

	public String deleteDoctor(String doctorid) {
		String output = " ";
		try {
			Connection con = connect();
			if (con == null) {
				return "Error while connecting to the database for deleting.";
			}

			String query = "delete from doctor where doctorid=?";
			PreparedStatement preparedStmt = con.prepareStatement(query);

			preparedStmt.setString(1, doctorid);

			preparedStmt.execute();
			con.close();
			output = "Deleted successfully";
		} catch (Exception e) {
			output = "Error while deleting the doctor detail.";
			System.err.println(e.getMessage());
		}
		return output;
	}

}
