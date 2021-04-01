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
      try {                                     //empty
    	  dnaSequence.get(0);
    	  fail();
      }catch(IndexOutOfBoundsException ex) {
    	  //do nothing
      }
      dnaSequence.transcribe("GCTGCCCAACTAATGTTTAGCTGGGTATGATA");
      assertEquals("ala", dnaSequence.get(0));  //GCT
      assertEquals("ala", dnaSequence.get(1));  //GCC
      assertEquals("gln", dnaSequence.get(2));  //CAA
      assertEquals("leu", dnaSequence.get(3));  //CTA
      assertEquals("met", dnaSequence.get(4));  //ATG
      assertEquals("phe", dnaSequence.get(5));  //TTT
      assertEquals("ser", dnaSequence.get(6));  //AGC
      assertEquals("trp", dnaSequence.get(7));  //TGG
      assertEquals("val", dnaSequence.get(8));  //GTA
      assertEquals("stop", dnaSequence.get(9)); //TGA
                                                //TA: not be translated
      
      try {                                     //IndexOutOfBoundsException
    	  dnaSequence.get(10);
    	  fail();
      }catch(IndexOutOfBoundsException ex) {
    	  //do nothing
      }
      
      try {                                     //IndexOutOfBoundsException
    	  dnaSequence.get(-1);
    	  fail();
      }catch(IndexOutOfBoundsException ex) {
    	  //do nothing
      }
    }
}