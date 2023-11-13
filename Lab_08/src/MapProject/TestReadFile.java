package MapProject;

import java.io.File;
import java.io.FileNotFoundException;import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;

public class TestReadFile {
	public static void main(String[] args) throws FileNotFoundException {
		MyWordCountApp myWordCount = new MyWordCountApp();
		myWordCount.loadData();
		System.out.println(myWordCount.countUnique());
		myWordCount.printWordCounts();
		myWordCount.printWordCountsAlphabet();
		
	}
}