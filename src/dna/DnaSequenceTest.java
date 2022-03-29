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

    /* Tests transcribe() in general, with a valid string to be transcribed. */
    @Test
    public void testTranscribe() {
      List<String> aminoacid = null;
      try {
        aminoacid = dnaSequence.transcribe("ATGGCTCGCAACATCGGATATAGATGA");
      } catch(Exception e) {
        fail();
      }
      String[] expected = {"met", "ala", "arg", "asn", "lle", "gly", "tyr", "arg", "stop"};
      
      int acidSize = aminoacid.size();
      assertEquals(expected.length, acidSize);
      // A very inefficient list verifier...
      for(int i = 0; i < expected.length; ++i) {
          String acid = aminoacid.get(i);
          String expectedAcid = expected[i];
          assertEquals(expectedAcid, acid);
      }
    }
    
    @Test
    public void testTranscribeEmptyString() {
      /* This should not throw an exception because it should silently pass anything
       * of a valid length that cannot be transcribed. If you are trying to transcribe
       * "nothing," you should happily get "nothing" back in return. */
      List<String> aminoacid = null;
      try {
        aminoacid = dnaSequence.transcribe("");
      } catch (Exception e) { fail(); } 
      assertEquals(0, aminoacid.size());
    }
    
    /* Tests that transcribe() throws an exception for strings of an invalid length */
    @Test
    public void testTranscribeException() {
      try {
        dnaSequence.transcribe("GCTCGCAACATCGGATATAG");
        fail();
      } catch(Exception e) {}
      try {
        dnaSequence.transcribe("G");
        fail();
      } catch(Exception e) {}
      try {
        dnaSequence.transcribe("GC");
        fail();
      } catch(Exception e) {}
      try {
        dnaSequence.transcribe("GCTCGCAACAT");
        fail();
      } catch(Exception e) {}
      try {
        dnaSequence.transcribe("GCTCGCAACA");
        fail();
      } catch(Exception e) {}
      try {
        dnaSequence.transcribe("GCZCGCAACA");
        fail();
      } catch(Exception e) {}
      try {
        dnaSequence.transcribe("ZCTCGCAACA");
        fail();
      } catch(Exception e) {}
      try {
        dnaSequence.transcribe("GCZCGCAACZ");
        fail();
      } catch(Exception e) {}
      try {
        assertEquals(4, dnaSequence.transcribe("GCTCGCAACATC").size()); // This should not fail.
      } catch(Exception e) {
        fail();
      }
      
    }
    
    /* Tests that transcribe() follows the same behavior as, and therefore likely
     * correctly implements, DNACodon's acidFor() function, with all combinations of ATGC.
     */
    @Test public void testTranscribeFollowsAcidForFunction() {
      DNACodon cod = new DNACodon();
      char[] letters = {'A', 'T', 'G', 'C'};
      for(char first : letters) {
          for(char second: letters) {
              for (char third: letters) {
                  String codon = "" + first + second + third;
                  try {
                      List<String> trans = dnaSequence.transcribe(codon);
                      assertEquals(1, trans.size());
                      String acid = cod.acidFor(codon);
                      assertEquals(acid, trans.get(0));
                  } catch (Exception e) {
                      e.printStackTrace();
                      System.out.println("testTranscribeFollowsAcidForFunction failed on codon: " + codon);
                      fail();
                  }
              }
          }
      }
    }
    
    /* Tests if transcribe() will correctly ignore a bad codon, using strings with a valid length. */
    @Test 
    public void testTranscribeBadCodon() {
      try {
        dnaSequence.transcribe("GCTCMOOACATC");
      } catch (Exception e) {
        fail(); // It should silently ignore any non-transcribable codons.
      }
      try {
        dnaSequence.transcribe("MOOCTTTACATC");
      } catch (Exception e) {fail();}
      try {
        dnaSequence.transcribe("GCTCTTTACMOO");
      } catch (Exception e) {fail();}
      try {
        dnaSequence.transcribe("GCTCGCAACATZ");
      } catch (Exception e) {fail();}
      try {
        dnaSequence.transcribe("ZCTCGCAACATC");
      } catch (Exception e) {fail();}
      try {
        dnaSequence.transcribe("GCTCGCZACATC");
      } catch (Exception e) {fail();}
      try {
        dnaSequence.transcribe("GCTCGCAACATC");
      } catch (Exception e) {fail();}
    }
    
    
    /* Assuming that the purpose of transcribe() is more to translate what all the codons mean,
     * rather than to act as actual RNA generators, it should continue past a stop codon.
     */
    @Test
    public void testTranscribeIncludesStop() {
      List<String> aminoacid = null;
      try {
        aminoacid = dnaSequence.transcribe("ATGGCTCGCAACTGAATCGGATATAGA");
      } catch(Exception e) {
        fail();
      }
      String[] expected = {"met", "ala", "arg", "asn", "stop", "lle", "gly", "tyr", "arg"};
      int acidSize = aminoacid.size();
      assertEquals(expected.length, acidSize);
      for(int i = 0; i < expected.length; ++i) { // Verify this against expected.
          String acid = aminoacid.get(i);
          String expectedAcid = expected[i];
          assertEquals(expectedAcid, acid);
      }
    }
    
    //TODO: test exceptions and stuff....
    
    /* "...Sometimes two triples of letters will translate into the same protein,
     * but no triple will translate into more than one protein..."  - test this?? */
}