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
    public void testEmptyString() {
        List<String> ret = dnaSequence.transcribe("");
        assertEquals(0, ret.size());
    }

    @Test
    public void testNullString() {
        List<String> ret = dnaSequence.transcribe(null);
        assertEquals(0, ret.size());
    }

    @Test
    public void testInvalidDNASeq() {
        List<String> ret = dnaSequence.transcribe("ABCDEFG");
        assertEquals(0, ret.size());
    }

    @Test
    public void testDNASeqLengthOne() {
        List<String> ret = dnaSequence.transcribe("G");
        assertEquals(0, ret.size());
    }

    @Test
    public void testDNASeqLengthFour() {
        List<String> ret = dnaSequence.transcribe("TGTC");
        assertEquals(1, ret.size());
        assertEquals(ret.get(0), "cys");
    }

    @Test
    public void testDNASeqLengthFive() {
        List<String> ret = dnaSequence.transcribe("ATTCT");
        assertEquals(1, ret.size());
        assertEquals(ret.get(0), "lle");
    }

    @Test
    public void testDNASeqLengthThree() {
        List<String> ret = dnaSequence.transcribe("ATG");
        assertEquals(1, ret.size());
        assertEquals(ret.get(0), "met");
    }

    @Test
    public void testDNASeqLengthNine() {
        List<String> ret = dnaSequence.transcribe("GCTCGTAAT");
        assertEquals(3, ret.size());
        assertEquals(ret.get(0), "ala");
        assertEquals(ret.get(1), "arg");
        assertEquals(ret.get(2), "asn");
    }

}