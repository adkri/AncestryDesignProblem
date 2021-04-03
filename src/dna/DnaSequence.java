package dna;

import java.util.LinkedList;
import java.util.List;

public class DnaSequence {
    DNACodon dnaCodon;

    public DnaSequence() {
        this.dnaCodon = new DNACodon();
    }

    public List<String> transcribe(String dna) {
        List<String> aminoAcids = new LinkedList<String>();

        int i = 0;

        if (dna == null) {
            return aminoAcids;
        }

        while (i < dna.length() - 2) {
            String triplet = dna.substring(i, i + 3);

            try {
                String acid = this.dnaCodon.acidFor(triplet);
                aminoAcids.add(acid);
            } catch (Exception e) {
                // silently pass codon that does not transcribe a amino acid
            }

            i += 3;
        }

        return aminoAcids;
    }
}
