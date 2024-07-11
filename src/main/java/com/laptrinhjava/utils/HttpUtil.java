package com.laptrinhjava.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import javax.servlet.ServletOutputStream;

import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.core.exc.StreamWriteException;

import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class HttpUtil {

	public static <T> T toModel(BufferedReader reader, Class<T> t) {
		ObjectMapper mapper = new ObjectMapper();
		try {
			return mapper.readValue(reader, t);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@SuppressWarnings("unchecked")
	public static <T> List<T> parseJsonArray(BufferedReader bufferedReader, Class<T> classOnWhichArrayIsDefined)
			throws IOException, ClassNotFoundException {
		ObjectMapper mapper = new ObjectMapper();
		Class<T[]> arrayClass = (Class<T[]>) Class.forName("[L" + classOnWhichArrayIsDefined.getName() + ";");
		T[] objects = mapper.readValue(bufferedReader, arrayClass);
		return Arrays.asList(objects);
	}

	public static <T> List<T> toListModel(BufferedReader reader, Class<T> t)
			throws StreamReadException, DatabindException, IOException {
		ObjectMapper mapper = new ObjectMapper();
		List<T> list = mapper.readValue(reader, mapper.getTypeFactory().constructCollectionType(List.class, t));
		return list;
	}

	public static <T> void toJson(ServletOutputStream os, T t) {
		ObjectMapper mapper = new ObjectMapper();
		try {
			mapper.writeValue(os, t);
		} catch (StreamWriteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (DatabindException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
