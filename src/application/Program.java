package application;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;

public class Program {

	public static void main(String[] args) {

		Map<String, Integer> candidates = new HashMap<String, Integer>();

		String path = "C:\\projetos\\ws-eclipse\\curso_java_map_exercicio\\input.txt";

		try (BufferedReader buffer = new BufferedReader(new FileReader(path))) {

			String line = buffer.readLine();
			
			while (line != null) {
				String[] fields = line.split(",");
				if (candidates.containsKey(fields[0])) {
					int aux = candidates.get(fields[0]);
					int votes = aux + Integer.parseInt(fields[1]);
					candidates.put(fields[0], votes);
				} else {
					candidates.put(fields[0], Integer.parseInt(fields[1]));
				}
				
				line = buffer.readLine();
			}

		} catch (Exception e) {
			System.out.println("Error: " + e.getMessage());
		}
		
		for(String key : candidates.keySet()){
			System.out.println(key +": "+ candidates.get(key));
		}

	}

}
