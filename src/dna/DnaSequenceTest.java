package dna;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

import java.util.LinkedList;
import java.util.List;

public class DnaSequenceTest {
    DnaSequence dnaSequence;
    @Before
    public void setUp() throws Exception {
        dnaSequence = new DnaSequence();
    }

    @Test
    public void transcribe() {
    	//creating a list to hold our expected answers
    	List<String> expected = new LinkedList<String>();

    	//testing we can transcribe one protein
    	String dna = "GCT";
		expected.add("ala");
    	assertEquals(expected, dnaSequence.transcribe(dna));	
    }
    
    @Test
    public void transcribeLargeSeq() {
    	List<String> expected = new LinkedList<String>();
    	
    	//trying a longer dna sequence
    	String dna = "GCTCGCAACATCGGATATAGA";
    	expected.add("ala");
    	expected.add("arg");
    	expected.add("asn");
    	expected.add("lle");
    	expected.add("gly");
    	expected.add("tyr");
    	expected.add("arg");
    	
    	assertEquals(expected, dnaSequence.transcribe(dna));	
    }
    
    
    @Test
    public void transcribeNewSq() {
    	//and just for fun
    	List<String> expected = new LinkedList<String>();
    	
    	//even though this technically stops at the second triplet :)
    	String dna = "TACTGATCGACCCCCATAATGAAA";
    	
    	expected.add("tyr");
    	expected.add("stop");
    	expected.add("ser");
    	expected.add("thr");
    	expected.add("pro");
    	expected.add("lle");
    	expected.add("met");
    	expected.add("lys");
    	
    	assertEquals(expected, dnaSequence.transcribe(dna));
    	
    }
}