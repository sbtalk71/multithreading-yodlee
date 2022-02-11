package com.demo.concurrent;

import java.io.File;
import java.io.IOException;
import java.util.List;

import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class EmpDb {

	public static List<Emp> getEmpList() {

		ObjectMapper mapper = new ObjectMapper();
		try {
			return mapper.readValue(new File("employees.json"), new TypeReference<List<Emp>>() {
			});
		} catch (StreamReadException e) {
			e.printStackTrace();
		} catch (DatabindException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
}
