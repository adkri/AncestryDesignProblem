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
    public void checkForTranscribe() {
        // TODO: implement tests
    	 List<String> aminoAcid1 = this.dnaSequence.transcribe("ATGCAG");
    	 List<String> test1 = new LinkedList<>();
    	 test1.add("met");
    	 test1.add("gln");
    	 assertEquals(test1,(aminoAcid1));
    }
}