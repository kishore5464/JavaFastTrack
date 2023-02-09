package com.cts.jsedemo;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.Scanner;

public class WriteIntoFile {

	public static void main(String[] args) {

		Scanner kbin = new Scanner(System.in);

		System.out.println("FileName: ");
		String fileName = kbin.next();
		
		Path filePath = Paths.get(fileName);
		
		
		System.out.println("Enter file contnet: ");
		String data = kbin.nextLine();
		
		try {
			Files.write(filePath, Collections.singletonList(data));
			System.out.println("file saved");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		kbin.close();
	}

}
