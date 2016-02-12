package com.gf.mx;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.gf.mx.json.Staff;
import com.gf.mx.json.Views;

public class JsonView {

	public static void main(String[] args) {

		ObjectMapper mapper = new ObjectMapper();

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

		try {

			// Salary will be hidden
			System.out.println("Normal View");
			String normalView = mapper.writerWithView(Views.Normal.class).writeValueAsString(staff);
			System.out.println(normalView);

			String jsonInString = "{\"name\":\"Gustavo\",\"age\":27,\"position\":\"Second\",\"salary\":200000,\"skills\":[\"skill 4\",\"skill 5\",\"skill 6\"]}";
			Staff normalStaff = mapper.readerWithView(Views.Normal.class).forType(Staff.class).readValue(jsonInString);
			System.out.println(normalStaff);

			// Display everything
			System.out.println("\nManager View");
			String managerView = mapper.writerWithView(Views.Manager.class).writeValueAsString(staff);
			System.out.println(managerView);

			Staff managerStaff = mapper.readerWithView(Views.Manager.class).forType(Staff.class)
					.readValue(jsonInString);
			System.out.println(managerStaff);

		} catch (JsonGenerationException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
