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
    public void transcribe(String dna, DNACodon dnaCodon) {
        // TODO: implement tests
    	
    	//uncertain what tests to put here...  the error was caused by an out of bounds exception because
    	//it was checking i instead of the upper bound i+2
    	
    }
}