package com.gf.mx;

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
			String jsonInString = "{\"name\":\"Gustavo\",\"age\":27,\"position\":\"First\",\"salary\":100000,\"skills\":[\"skill 1\",\"skill 2\",\"skill 3\"]}";

			// Staff obj = mapper.readValue(new File("file.json"), Staff.class);

			// JSON from URL to Object
			// Staff obj = mapper.readValue(new
			// URL("http://mkyong.com/api/staff.json"), Staff.class);

			// JSON from String to Object
			Staff obj = mapper.readValue(jsonInString, Staff.class);
			System.out.println(obj);
		} catch (JsonParseException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
