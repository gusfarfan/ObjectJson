package com.gf.mx;

import java.io.IOException;
import java.util.Map;
import java.util.Map.Entry;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ConvertJSONMap {
	public static void main(String[] args) {
		try {
			ObjectMapper mapper = new ObjectMapper();
			String json = "{\"name\":\"Gustavo\", \"age\":27}";
			Map<String, Object> map = mapper.readValue(json, new TypeReference<Map<String, Object>>() {
			});
			for (Entry<String, Object> entry : map.entrySet()) {
				System.out.println("KEY: " + entry.getKey() + " VALUE: " + entry.getValue());
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
