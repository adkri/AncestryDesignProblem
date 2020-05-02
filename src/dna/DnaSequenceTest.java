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
    	String dna = "GCTCGCAACATCGGATATAGA";
        List<String> acids = dnaSequence.transcribe(dna);
        assertEquals("ala", acids.get(0));
        assertEquals("lle", acids.get(3));
        assertEquals("arg", acids.get(6));
        
        String dna2 = "AAGTAGCCGAGCTACGAGCGG";
        List<String> acids2 = dnaSequence.transcribe(dna2);
        assertEquals("lys", acids2.get(0));
        assertEquals("ser", acids2.get(3));
        assertEquals("arg", acids2.get(6));
        
        
    }
    @Test(expected = IndexOutOfBoundsException.class)
    public void errorOnInvalidCodonSize() throws Exception {
        String badSizedCodon = "BB";
        List<String> acids = dnaSequence.transcribe(badSizedCodon);
    }
}