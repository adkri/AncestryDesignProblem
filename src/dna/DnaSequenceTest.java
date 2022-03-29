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
    	
        List<String> Bob = new LinkedList<>();
        Bob.add("asp");
    	assertEquals (Bob, dnaSequence.transcribe("GAT"));
    }
}