package com.sean.test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.Date;

import java.sql.PreparedStatement;



import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;



public class JsonToDatabase {

	public static void main(String[] args) {

		// Creating a JSONParser object
		JSONParser jsonParser = new JSONParser();
		try {

			String Payload = "C:/Users/gudia/git/jsonProject/sean/src/test/java/com/sean/test/testfile.json";

			JSONObject jsonObject = (JSONObject) jsonParser.parse(new FileReader(Payload));
			// Retrieving the array
			JSONArray jsonArray = (JSONArray) jsonObject.get("Sean");
			Connection con = DBUtil.getConnection();
			// Insert a row into the MyPlayers table

			PreparedStatement pstmt = con
					.prepareStatement("INSERT INTO staffing values (?, ?, ?, ?, ? ,?, ?, ?, ?, ?, ?, ?,? ,?)");

		
//			
			
			
			for (Object object : jsonArray) {
				JSONObject record = (JSONObject) object;

				
				String A_CODE = (String) record.get("A_CODE");
				String FIRST_NAME = (String) record.get("FIRST_NAME");
				String OFFICE = (String) record.get("OFFICE");
				String JOB_SERIES = (String) record.get("JOB_SERIES");
				String LAST_NAME = (String) record.get("LAST_NAME");
				String MIDDLE_NAME = (String) record.get("MIDDLE_NAME");
				String HANDLE = (String) record.get("HANDLE");
				String POSITION_OFFICIAL_TITLE = (String) record.get("POSITION_OFFICIAL_TITLE");
				String START_DATE = (String) record.get("START_DATE");
				String REQUEST_CUSTOMER_NAME = (String) record.get("REQUEST_CUSTOMER_NAME");
				String GRADE = (String) record.get("GRADE");
				String SP_HANDLE = (String) record.get("SP_HANDLE");
				String PAY_PLAN = (String) record.get("PAY_PLAN");
				String ORG_CODE = (String) record.get("ORG_CODE");
				
				System.out.println("value"+A_CODE);
				
				pstmt.setString(1, A_CODE);
				pstmt.setString(2, FIRST_NAME);
				pstmt.setString(3, OFFICE);
				pstmt.setString(4, JOB_SERIES);
				pstmt.setString(5, LAST_NAME);
				pstmt.setString(6, MIDDLE_NAME);
				pstmt.setString(7, HANDLE);
				pstmt.setString(8, POSITION_OFFICIAL_TITLE);
				pstmt.setString(9, START_DATE);
				pstmt.setString(10, REQUEST_CUSTOMER_NAME);
				pstmt.setString(11, GRADE);
				pstmt.setString(12, SP_HANDLE);
				pstmt.setString(13, PAY_PLAN);
				pstmt.setString(14, ORG_CODE);
				

				// pstmt.execute();
				pstmt.executeUpdate();
				con.commit();
			}
			System.out.println("Records inserted.....");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}