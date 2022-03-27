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
    	List<String> aminoAcids = new LinkedList<>();
    	assertEquals(aminoAcids, dnaSequence.transcribe(""));
    	assertEquals(aminoAcids, dnaSequence.transcribe("TT"));
    	aminoAcids.add("phe"); //phe
    	assertEquals(aminoAcids, dnaSequence.transcribe("TTTX"));
    	assertEquals(aminoAcids, dnaSequence.transcribe("TTTXXX"));
    	aminoAcids.add("leu"); //phe, leu
    	assertEquals(aminoAcids, dnaSequence.transcribe("TTTCTT"));
    }
}