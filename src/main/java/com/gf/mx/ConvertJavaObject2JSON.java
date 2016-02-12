package com.gf.mx;

import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.gf.mx.json.Staff;

public class ConvertJavaObject2JSON {

	public static void main(String[] args) {
		
		Staff staff = new Staff();
		staff.setAge(27);
		staff.setName("Gustavo");
		staff.setPosition("First");
		staff.setSalary(new BigDecimal(100000.00));
		List<String> skills = new ArrayList<String>();
		skills.add("skill 1");
		skills.add("skill 2");
		skills.add("skill 3");
		staff.setSkills(skills);
		
		// Object to JSON in file
		try {
			ObjectMapper mapper = new ObjectMapper();
		
			mapper.writeValue(new File("file.json"), staff);
			// Object to JSON in String
			String jsonInString = mapper.writeValueAsString(staff);
			System.out.println(jsonInString);

			// Convert object to JSON string and pretty print
			jsonInString = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(staff);
			System.out.println(jsonInString);
		} catch (JsonGenerationException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
