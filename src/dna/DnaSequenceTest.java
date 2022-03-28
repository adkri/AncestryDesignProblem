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
    public void transcribeGroupingAmount() {
    	String dna = "GCTCGCAACATCGGATATAGA";
    	DnaSequence dnaSequence = new DnaSequence();
        List<String> aminoacid = dnaSequence.transcribe(dna);
    	 assertEquals(7, aminoacid.size());
    }
    @Test
    public void transcribe() {
    	String dna = "GCT";
    	DnaSequence dnaSequence = new DnaSequence();
    	List<String> aminoAcids = new LinkedList<>();
        int i = 0;
        while(i < dna.length()-2) {
            String triplet = "" + "a" + "l" + "a";
        }
        assertEquals(aminoAcids, dnaSequence.transcribe(dna));
    	
    }
}