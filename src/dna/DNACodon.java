package dna;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

import java.util.List;
import java.util.Map;

public class DNACodon {
    private Map<String, List<String>> aminoAcids;
    private Map<String, String> codons;

    /**
     * Sets up the DNA Codon values
     * Note: There is a constraint on the codon to amino acid relation.
     * Sometimes two triples of letters will translate into the same protein,
     * but no triple will translate into more than one protein.
     */
    public DNACodon() {
        // initialize the maps
        aminoAcids = new HashMap<>();
        codons = new HashMap<>();

        // Codons from wikipedia: https://en.wikipedia.org/wiki/DNA_codon_table
        
        ArrayList<String> list1 = new ArrayList<>(Arrays.asList("GCT", "GCC", "GCA", "GCG"));
        ArrayList<String> list2 = new ArrayList<>(Arrays.asList("CGT", "CGC", "CGA", "CGG", "AGA", "AGG"));
        ArrayList<String> list3 = new ArrayList<>(Arrays.asList("AAT", "AAC"));
        ArrayList<String> list4 = new ArrayList<>(Arrays.asList("GAT", "GAC"));
        ArrayList<String> list5 = new ArrayList<>(Arrays.asList("TGT", "TGC"));
        ArrayList<String> list6 = new ArrayList<>(Arrays.asList("CAA", "CAG"));
        ArrayList<String> list7 = new ArrayList<>(Arrays.asList("GAA", "GAG"));
        ArrayList<String> list8 = new ArrayList<>(Arrays.asList("GGT", "GGC", "GGA", "GGG"));
        ArrayList<String> list9 = new ArrayList<>(Arrays.asList("CAT", "CAC"));
        ArrayList<String> list10 = new ArrayList<>(Arrays.asList("ATT", "ATC", "ATA"));
        ArrayList<String> list11 = new ArrayList<>(Arrays.asList("CTT", "CTC", "CTA", "CTG", "TTA", "TTG"));
        ArrayList<String> list12 = new ArrayList<>(Arrays.asList("AAA", "AAG"));
        ArrayList<String> list13 = new ArrayList<>(Arrays.asList("ATG"));
        ArrayList<String> list14 = new ArrayList<>(Arrays.asList("TTT", "TTC"));
        ArrayList<String> list15 = new ArrayList<>(Arrays.asList("CCT", "CCC", "CCA", "CCG"));
        ArrayList<String> list16 = new ArrayList<>(Arrays.asList("TCT", "TCC", "TCA", "TCG", "AGT", "AGC"));
        ArrayList<String> list17 = new ArrayList<>(Arrays.asList("ACT", "ACC", "ACA", "ACG"));
        ArrayList<String> list18 = new ArrayList<>(Arrays.asList("TGG"));
        ArrayList<String> list19 = new ArrayList<>(Arrays.asList("TAT", "TAC"));
        ArrayList<String> list20 = new ArrayList<>(Arrays.asList("GTT", "GTC", "GTA", "GTG"));
        ArrayList<String> list21 = new ArrayList<>(Arrays.asList("TAA", "TGA", "TAG"));
        
        aminoAcids.put("ala", list1);
        aminoAcids.put("arg", list2);
        aminoAcids.put("asn", list3);
        aminoAcids.put("asp", list4);
        // there are some codons that can translate to both asp or asn, but due
        // to the constraint we will not include them

        aminoAcids.put("cys", list5);
        aminoAcids.put("gln", list6);
        aminoAcids.put("glu", list7);
        aminoAcids.put("gly", list8);

        aminoAcids.put("his", list9);

        // aminoAcids.put("start", List.of("ATG"));
        // we don't include start as ATG already trancribes to start

        aminoAcids.put("lle", list10);
        aminoAcids.put("leu", list11);
        aminoAcids.put("lys", list12);

        aminoAcids.put("met", list13);

        aminoAcids.put("phe", list14);
        aminoAcids.put("pro", list15);

        aminoAcids.put("ser", list16);

        aminoAcids.put("thr", list17);
        aminoAcids.put("trp", list18);
        aminoAcids.put("tyr", list19);

        aminoAcids.put("val", list20);

        aminoAcids.put("stop", list21);

        // We will also have a inverse map for quick amino acid lookup
        for (Map.Entry<String, List<String>> entry : aminoAcids.entrySet()) {
            String acid = entry.getKey();
            List<String> codonList = entry.getValue();

            // we will iterate over all the codons and build the map from codon -> acid
            for (String codon : codonList) {
                this.codons.put(codon, acid);
            }
        }
    }

    /**
     * Returns a list of codons for a given amino acid.
     *
     * @param aminoacid the three letter amino acid
     * @return the list of codons
     */
    public List<String> codonsFor(String aminoacid) throws Exception {
        if (aminoacid.length() != 3 && !aminoacid.equals("stop")) {
            throw new Exception("incorrect amino acid");
        }
        aminoacid = aminoacid.toLowerCase();
        if (this.aminoAcids.containsKey(aminoacid)) {
            return this.aminoAcids.get(aminoacid);
        }
        throw new Exception("this amino acid has no codons:" + aminoacid);
    }

    /**
     * Returns the amino acid for a codon.
     *
     * @param codon the three letter codon
     * @return the amino acid transcribed by the codon
     */
    public String acidFor(String codon) throws Exception {
        if (codon.length() != 3) {
            throw new Exception("incorrect codon. must be three letters");
        }
        codon = codon.toUpperCase();
        if (this.codons.containsKey(codon)) {
            return this.codons.get(codon);
        }
        throw new Exception("this codon does not transcribe a amino acid: " + codon);
    }
}
