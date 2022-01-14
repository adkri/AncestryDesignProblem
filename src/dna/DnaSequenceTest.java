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
        assertEquals("[ala, arg, asp, asn, cys]", dnaSequence.transcribe("GCAAGAGATAATTGT").toString());
        assertEquals("[ala, arg, asp, asn, cys]", dnaSequence.transcribe("gcaagagataattgt").toString());

    }
}