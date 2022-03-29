package dna;

import org.junit.Before;
import org.junit.Test;

import java.util.LinkedList;
import java.util.List;

import static org.junit.Assert.*;

public class DnaSequenceTest {
    DnaSequence dnaSequence;
    @Before
    public void setUp() throws Exception {
        dnaSequence = new DnaSequence();
    }

    @Test
    public void transcribe() {
        	//TODO: test transcribe
        	List<String> testAminoAcid = this.dnaSequence.transcribe("CGAGCA");
        	
        	List<String> compareList= new LinkedList<>();
        	compareList.add("arg");
        	compareList.add("asn");
        	assertEquals(compareList,(testAminoAcid));
    }
}