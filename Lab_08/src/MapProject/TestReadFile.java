package MapProject;

import java.io.File;
import java.io.FileNotFoundException;import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;

public class TestReadFile {
	public static void main(String[] args) throws IOException {
		MyWordCountApp myWordCount = new MyWordCountApp();
		myWordCount.loadData();
		System.out.println(myWordCount.countUnique());
		myWordCount.printWordCounts();
		myWordCount.printWordCountsAlphabet();

		TextAnalyzer text = new TextAnalyzer();
		try {
			text.load("Data/short");
		} catch (IOException e) {
			e.printStackTrace();
		}

		text.add("IT", 2);
		text.displayWords();
		text.displayText();
		System.out.println(text.mostFrequentWord());
	}
}
