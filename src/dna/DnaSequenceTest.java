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
    	LinkedList<String> dna = new LinkedList<>();
    	dna.add("TAG");
    	dna.add("AGG");
    	dna.add("GTT");
    	dna.add("CCA");
    	
    	
    }
}