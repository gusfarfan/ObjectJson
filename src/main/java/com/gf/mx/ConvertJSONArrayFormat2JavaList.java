package com.gf.mx;

import java.io.IOException;
import java.util.List;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.gf.mx.json.Staff;

public class ConvertJSONArrayFormat2JavaList {
	public static void main(String[] args) {
		try {
			ObjectMapper mapper = new ObjectMapper();
			String json = "[{\"name\":\"Gustavo\",\"age\":27,\"position\":\"First\",\"salary\":100000,\"skills\":[\"skill 1\",\"skill 2\",\"skill 3\"]}, {\"name\":\"Gustavo\",\"age\":27,\"position\":\"Second\",\"salary\":200000,\"skills\":[\"skill 4\",\"skill 5\",\"skill 6\"]}]";
			List<Staff> list = mapper.readValue(json, new TypeReference<List<Staff>>() {
			});
			for (Staff staff : list) {
				System.out.println(staff);
			}
		} catch (JsonParseException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
