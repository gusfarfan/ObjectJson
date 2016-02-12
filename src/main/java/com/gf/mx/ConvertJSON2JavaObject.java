package com.gf.mx;

import java.io.File;
import java.io.IOException;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.gf.mx.json.Staff;

public class ConvertJSON2JavaObject {

	public static void main(String[] args) {
		// JSON from file to Object
		try {

			ObjectMapper mapper = new ObjectMapper();

			// Convert JSON string from file to Object
			Staff staff = mapper.readValue(new File("file.json"), Staff.class);
			System.out.println(staff);

			// Convert JSON string to Object
			String jsonInString = "{\"name\":\"Gustavo\",\"age\":27,\"position\":\"Second\",\"salary\":200000,\"skills\":[\"skill 4\",\"skill 5\",\"skill 6\"]}";
			Staff staff1 = mapper.readValue(jsonInString, Staff.class);
			System.out.println(staff1);

			// JSON from URL to Object
			// Staff obj = mapper.readValue(new
			// URL("http://mkyong.com/api/staff.json"), Staff.class);

			// Pretty print
			String prettyStaff1 = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(staff1);
			System.out.println(prettyStaff1);
		} catch (JsonParseException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
