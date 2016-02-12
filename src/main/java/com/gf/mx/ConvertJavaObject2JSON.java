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
		// Object to JSON in file
		try {
			ObjectMapper mapper = new ObjectMapper();
			Staff obj = new Staff();
			obj.setAge(27);
			obj.setName("Gustavo");
			obj.setPosition("First");
			obj.setSalary(new BigDecimal(100000.00));
			List<String> skills = new ArrayList<String>();
			skills.add("skill 1");
			skills.add("skill 2");
			skills.add("skill 3");
			obj.setSkills(skills);
			mapper.writeValue(new File("file.json"), obj);
			// Object to JSON in String
			String jsonInString = mapper.writeValueAsString(obj);
		} catch (JsonGenerationException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
