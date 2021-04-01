package dna;

import java.util.LinkedList;
import java.util.List;

public class DnaSequence {
    DNACodon dnaCodon;

    public DnaSequence() {
        this.dnaCodon = new DNACodon();
    }

    public List<String> transcribe(String dna) {
        List<String> aminoAcids = new LinkedList<>();
        int i = 0;
        while(i < dna.length()-2) { //skip last codons if they are not a triple
            String triplet = "" + dna.charAt(i) + dna.charAt(i+1) + dna.charAt(i+2);
            try {
                String acid = this.dnaCodon.acidFor(triplet);
                aminoAcids.add(acid);
            } catch (Exception e) {
                // silently pass codon that does not transcribe a amino acid
            }
            i += 3; //was previously moving forward one space at a time; should be moving 3 spaces at a time (3 codons = 1 amino acid)
        }
        return aminoAcids;
    }
}
