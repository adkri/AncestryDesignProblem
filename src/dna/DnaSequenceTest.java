package dna;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

import java.util.List;

public class DnaSequenceTest {
    DnaSequence dnaSequence;
    @Before
    public void setUp() throws Exception {
        dnaSequence = new DnaSequence();
    }

    @Test
    public void transcribe() {
        // TODO: implement tests
    	String dna = "AGTCAGCGTATCGACTTTTCGCTAGCTCTTAGCTCCAAA";
        List<String> aminoacid = dnaSequence.transcribe(dna);
        assertEquals(13, aminoacid.size());
        
        dna = "TTC";
        aminoacid = dnaSequence.transcribe(dna);
        assertEquals(1, aminoacid.size());
        
        dna = "ACTGTACTATCTTAC";
        aminoacid = dnaSequence.transcribe(dna);
        assertEquals(5, aminoacid.size());
    }
}