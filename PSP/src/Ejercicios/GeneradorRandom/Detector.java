package Ejercicios.GeneradorRandom;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Detector {
	public static void main(String[] args) throws Exception {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String linea;
		while ((linea = reader.readLine()) != null) {
			String[] nums = linea.trim().split(" ");
			if (nums.length == 2 && nums[0].equals(nums[1])) {
				System.out.println("IGUAL");
				System.out.flush();
				break;
			} else {
				System.out.println("NO");
				System.out.flush();
			}
		}
	}
}
