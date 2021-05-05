package Testing;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import Test.WordCounter;
import Testing.stubs.FailStub;

public class Testing {
	
	/*@Test
	public void programWorkingTest() throws FileNotFoundException {
		List<String> params = Arrays.asList("D:\\test.txt");
		Task wordCounter = new WordCounter();
		if (wordCounter.configure(params) == true) {
		    String outcome = wordCounter.run();
		    assertEquals("Number of words: 14", outcome, "the proper outcome");
		}
	}
	
	@Test
	public void wrongPathTest() throws FileNotFoundException {
		List<String> params = Arrays.asList("D:\test.txt");
		Task wordCounter = new WordCounter();
		if (wordCounter.configure(params) == true) {
		    String outcome = wordCounter.run();
		    assertEquals("[D:	est.txt] Is an invalid path, please write the correct path", outcome, "the proper outcome");
		}
	}*/
	
	@Test
	public void programWorkingTest() throws FileNotFoundException {
		WordCounter wc  = new WordCounter();
		assertEquals("Number of words: 15", wc.run(), "proper output");
	}
	
	@Test
	public void trueConfigTest() {
		WordCounter wc  = new WordCounter();
		List<String> temp = new ArrayList<String>();
		temp.add("D:\\test.txt");
		assertTrue(wc.configure(temp), "The proper output");
	}
	
	@Test
	public void falseConfigTest() {
		WordCounter wc  = new WordCounter();
		List<String> temp = new ArrayList<String>();
		temp.add(null);
		assertFalse(wc.configure(temp), "The proper output");
	}
	
	@Test
	public void emptyPathTest() {
		WordCounter wc  = new WordCounter();
		List<String> temp = new ArrayList<String>();
		temp.add("");
		assertFalse(wc.configure(temp), "The proper output");
	}
	
	
	@Test
	public void fileDoesNotExistConfigTest() {
		WordCounter wc  = new WordCounter();
		List<String> temp = new ArrayList<String>();
		temp.add("D:\\tes.txt");
		assertFalse(wc.configure(temp), "The proper output");
	}
	
	@Test
	public void failStubTest() {
		FailStub fs = new FailStub();
		assertEquals("An error has occured.", fs.run(), "suppost ifalli");
		
	}
	
	/*@Test
	public void checkConfigTest() {
		WordCounter wc  = new WordCounter();
		List<String> temp = new ArrayList<String>();
		temp = toCheck.get(-1);
		temp.add("D:\\tes.txt");
		assertFalse(wc.configure(temp), "The proper output");
	}*/
	
	
	
	
}
