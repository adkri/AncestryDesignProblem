package dna;

import java.util.LinkedList;
import java.util.List;

public class DnaSequence {
    DNACodon dnaCodon;

    public DnaSequence() {
        this.dnaCodon = new DNACodon();
    }

    public List<String> transcribe(String dna) {
        // TODO: fix me
        List<String> aminoAcids = new LinkedList<>();
        int i = 2;
        while(i < dna.length()) {
            String triplet = "" + dna.charAt(i-2) + dna.charAt(i-1) + dna.charAt(i);
            try {
                String acid = this.dnaCodon.acidFor(triplet);
                aminoAcids.add(acid);
            } catch (Exception e) {
                // silently pass codon that does not transcribe a amino acid
            }
            i += 1;
        }
        return aminoAcids;
    }
}
