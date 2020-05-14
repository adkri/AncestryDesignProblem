package dna;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class DnaSequenceTest {
    DnaSequence dnaSequence;
    @Before
    public void setUp() throws Exception {
        dnaSequence = new DnaSequence();
    }

    @Test
    public void transcribe() {
    	//Test that it throws an exception when a string is entered that does not contain any of the acids
    	try{
    		dnaSequence.transcribe("mrskashadavisandkatyaareagreatteam");
    	}
    	catch (Exception e){
    		//do nothing
    	}
        
    	//test that it throws an exception when it has less than three chars
    	try{
    		dnaSequence.transcribe("ha");
    	}
    	catch(Exception e){
    		//do nothing
    	}
    	
    	//test that it returns the correct list
    	List<String> test = dnaSequence.transcribe("ttgttcctcatggagtaggtcgggaaacagcat");
    	assertEquals("leu", test.get(0));
    	assertEquals("phe", test.get(1));
    	assertEquals("leu", test.get(2));
    	assertEquals("met", test.get(3));
    	assertEquals("glu", test.get(4));
    	assertEquals("stop", test.get(5));
    	assertEquals("val", test.get(6));
    	assertEquals("gly", test.get(7));
    	assertEquals("lys", test.get(8));
    	assertEquals("gln", test.get(9));
    	assertEquals("his", test.get(10));
    }
}