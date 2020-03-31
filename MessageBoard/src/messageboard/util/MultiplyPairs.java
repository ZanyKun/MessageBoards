package messageboard.util;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MultiplyPairs {
	public static void main(String... args) {
		File booty = new File("numbers.txt");
		try {
			Scanner reader = new Scanner(booty);
			int n = Integer.parseInt(reader.nextLine());
			List<Integer> list = new ArrayList<>();
			int count = 0;
			while(count < n) {
				list.add(reader.nextInt());
			}
			System.out.print(list);
			reader.close();
		}catch (FileNotFoundException e){
			e.printStackTrace();
		}
	}
	
	static void findPairs(File input) {
		try {
			Scanner reader = new Scanner(input);
			int n = Integer.parseInt(reader.nextLine());
			List<Integer> list = new ArrayList<>();
			int count = 0;
			while(count < n) {
				list.add(reader.nextInt());
			}
			System.out.print(list);
			reader.close();
		}catch (FileNotFoundException e){
			e.printStackTrace();
		}
		
	}
}
