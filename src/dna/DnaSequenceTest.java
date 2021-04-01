package dna;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

import java.util.LinkedList;

public class DnaSequenceTest {
    DnaSequence dnaSequence;
    @Before
    public void setUp() throws Exception {
        dnaSequence = new DnaSequence();
    }

    @Test
    public void transcribe() {
        // TODO: implement tests
    	DnaSequence test = new DnaSequence();
    	String testdna = "GCTCGTTCTACT"; // work with a variety of codons
    	LinkedList<String> testlist = new LinkedList<String>();
    	testlist.add("ala");
    	testlist.add("arg");
    	testlist.add("ser");
    	testlist.add("thr");
    	assertEquals(testlist, test.transcribe(testdna));
    	
    	testdna = "GCTCGTTCTAC"; //skip last codons if there is only a double
    	testlist.remove("thr");
    	assertEquals(testlist, test.transcribe(testdna));
    	
    	testdna = "GCTCGTTCTA"; //or single
    	assertEquals(testlist, test.transcribe(testdna));
    	
    	testdna = "GCTCGTTCT"; //work properly if there are no extra codons
    	assertEquals(testlist, test.transcribe(testdna));
    	
    	testdna = "blaGCTCGTTCTblabl";
    	assertEquals(testlist, test.transcribe(testdna)); //don't add triples that don't qualify as codons
    	
    	LinkedList<String> testlist2 = new LinkedList<String>();
    	String testdna2 = "TT"; //do nothing if there is less then a triple codon
    	assertEquals(testlist2, test.transcribe(testdna2));
    	}
    }
