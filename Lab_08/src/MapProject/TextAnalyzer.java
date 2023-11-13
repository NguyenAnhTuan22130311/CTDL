package MapProject;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class TextAnalyzer {
	// <word, its positions>
	private Map<String, ArrayList<Integer>> map = new HashMap<String, ArrayList<Integer>>();

	// load words in the text file given by fileName and store into map by using add
	// method in Task 2.1.
	// Using BufferedReader reffered in file TextFileUtils.java
	public void load(String fileName) {
		BufferedReader reader = null;
		try {
			reader = new BufferedReader(new FileReader(fileName));
			int index = 1;
			String line = null;
			while ((line = reader.readLine()) != null) {
				StringTokenizer tokens = new StringTokenizer(line, " ");

				while (tokens.hasMoreTokens()) {
					String word = tokens.nextToken();
					if (tokens.hasMoreTokens()) {
						add(word, index);
					} else {
						add(word, -index);
					}
				}
				index++;
			}
			System.out.println(map);
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (reader != null) {
				try {
					reader.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
	// In the following method, if the word is not in the map, then adding that word
	// to the map containing the position of the word in the file. If the word is
	// already in the map, then its word position is added to the list of word
	// positions for this word.
	// Remember to negate the word position if the word is at the end of a line in
	// the text file

	public void add(String word, int position) {
		if (map.containsKey(word)) {
			ArrayList<Integer> values = new ArrayList<>();
			values.add(position);
		} else {
			ArrayList<Integer> values = new ArrayList<>();
			values.add(position);
			map.put(word, values);
		}
		System.out.println(map);
	}

	// This method should display the words of the text file along with the
	// positions of each word, one word per line, in alphabetical order
	public void displayWords() {
		TreeMap<String, ArrayList<Integer>> sorted = new TreeMap<>(map);
		for (Map.Entry<String, ArrayList<Integer>> entry : sorted.entrySet()) {
			System.out.println(entry.getKey() + ": " + entry.getValue());
		}
	}

	// This method will display the content of the text file stored in the map
	public void displayText() {
		for (Map.Entry<String, ArrayList<Integer>> entry : map.entrySet()) {
			System.out.println(entry.getKey() + ": " + entry.getValue());
		}
	}

	// This method will return the word that occurs most frequently in the text file
	public String mostFrequentWord() {
		String mostFrequent = null;
		int maxCount = 0;
		for (Map.Entry<String, ArrayList<Integer>> entry : map.entrySet()) {
			if (entry.getValue().size() > maxCount) {
				maxCount = entry.getValue().size();
				mostFrequent = entry.getKey();
			}
		}
		return mostFrequent;
	}
}
