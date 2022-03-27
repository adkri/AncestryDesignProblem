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
        // TODO: implement tests
    	List<String> answ = new LinkedList<>();
    	answ.add("asp");
    	answ.add("leu");
    	System.out.println(dnaSequence.transcribe("GATTTACG"));
    	assertEquals(answ, dnaSequence.transcribe("GATTTACG"));
    	
    	List<String> answ2 = new LinkedList<>();
    	answ2.add("met");
    	answ2.add("tyr");
    	answ2.add("arg");
    	answ2.add("ala");
    	answ2.add("asp");
    	answ2.add("asp");
    	answ2.add("asn");
    	System.out.println(dnaSequence.transcribe("ATGTATAGAGCTGATGATAAC"));
    	assertEquals(answ2, dnaSequence.transcribe("ATGTATAGAGCTGATGATAAC"));
    	
    	
    }
}