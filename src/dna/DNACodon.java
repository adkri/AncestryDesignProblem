package dna;

import java.util.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DNACodon {
    private Map<String, List<String>> aminoAcids;
    private Map<String, String> codons;
    private List<ArrayList<String>> aminoAcidDNA;
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
        aminoAcidDNA = new ArrayList<ArrayList<String>>();

        // Codons from wikipedia: https://en.wikipedia.org/wiki/DNA_codon_table
        aminoAcidDNA.add(new ArrayList<String>());
        aminoAcidDNA.get(0).add("GCT");
        aminoAcidDNA.get(0).add("GCC");
        aminoAcidDNA.get(0).add("GCA");
        aminoAcidDNA.get(0).add("GCG");
        aminoAcids.put("ala", aminoAcidDNA.get(0));
        
        aminoAcidDNA.add(new ArrayList<String>());
        aminoAcidDNA.get(1).add("CGT");
        aminoAcidDNA.get(1).add("CGC");
        aminoAcidDNA.get(1).add("CGA");
        aminoAcidDNA.get(1).add("CGG");
        aminoAcidDNA.get(1).add("AGA");
        aminoAcidDNA.get(1).add("AGG");
        aminoAcids.put("arg", aminoAcidDNA.get(1));
        
        aminoAcidDNA.add(new ArrayList<String>());
        aminoAcidDNA.get(2).add("AAT");
        aminoAcidDNA.get(2).add("AAC");
        aminoAcids.put("asn", aminoAcidDNA.get(2));
        
        aminoAcidDNA.add(new ArrayList<String>());
        aminoAcidDNA.get(3).add("GAT");
        aminoAcidDNA.get(3).add("GAC");
        aminoAcids.put("asp", aminoAcidDNA.get(3));
        // there are some codons that can translate to both asp or asn, but due
        // to the constraint we will not include them
        
        aminoAcidDNA.add(new ArrayList<String>());
        aminoAcidDNA.get(4).add("TGT");
        aminoAcidDNA.get(4).add("TGC");
        aminoAcids.put("cys", aminoAcidDNA.get(4));
        
        aminoAcidDNA.add(new ArrayList<String>());
        aminoAcidDNA.get(5).add("CAA");
        aminoAcidDNA.get(5).add("CAG");
        aminoAcids.put("gln", aminoAcidDNA.get(5));
        
        aminoAcidDNA.add(new ArrayList<String>());
        aminoAcidDNA.get(6).add("GAA");
        aminoAcidDNA.get(6).add("GAG");
        aminoAcids.put("glu", aminoAcidDNA.get(6));
        
        aminoAcidDNA.add(new ArrayList<String>());
        aminoAcidDNA.get(7).add("GGT");
        aminoAcidDNA.get(7).add("GGC");
        aminoAcidDNA.get(7).add("GGA");
        aminoAcidDNA.get(7).add("GGG");
        aminoAcids.put("gly", aminoAcidDNA.get(7));

        aminoAcidDNA.add(new ArrayList<String>());
        aminoAcidDNA.get(8).add("CAT");
        aminoAcidDNA.get(8).add("CAC");
        aminoAcids.put("his", aminoAcidDNA.get(8));

        // aminoAcids.put("start", List.of("ATG"));
        // we don't include start as ATG already transcribes to start
        aminoAcidDNA.add(new ArrayList<String>());
        aminoAcidDNA.get(9).add("ATT");
        aminoAcidDNA.get(9).add("ATC");
        aminoAcidDNA.get(9).add("ATA");
        aminoAcids.put("lle", aminoAcidDNA.get(9));
        
        aminoAcidDNA.add(new ArrayList<String>());
        aminoAcidDNA.get(10).add("CTT");
        aminoAcidDNA.get(10).add("CTC");
        aminoAcidDNA.get(10).add("CTA");
        aminoAcidDNA.get(10).add("CTG");
        aminoAcidDNA.get(10).add("TTA");
        aminoAcidDNA.get(10).add("TTG");
        aminoAcids.put("leu", aminoAcidDNA.get(10));
        
        aminoAcidDNA.add(new ArrayList<String>());
        aminoAcidDNA.get(11).add("AAA");
        aminoAcidDNA.get(11).add("AAG");
        aminoAcids.put("lys", aminoAcidDNA.get(11));

        aminoAcidDNA.add(new ArrayList<String>());
        aminoAcidDNA.get(12).add("ATG");
        aminoAcids.put("met", aminoAcidDNA.get(12));

        aminoAcidDNA.add(new ArrayList<String>());
        aminoAcidDNA.get(13).add("TTT");
        aminoAcidDNA.get(13).add("TTC");
        aminoAcids.put("phe", aminoAcidDNA.get(13));
        
        aminoAcidDNA.add(new ArrayList<String>());
        aminoAcidDNA.get(14).add("CCT");
        aminoAcidDNA.get(14).add("CCC");
        aminoAcidDNA.get(14).add("CCA");
        aminoAcidDNA.get(14).add("CCG");
        aminoAcids.put("pro", aminoAcidDNA.get(14));

        aminoAcidDNA.add(new ArrayList<String>());
        aminoAcidDNA.get(15).add("TCT");
        aminoAcidDNA.get(15).add("TCC");
        aminoAcidDNA.get(15).add("TCA");
        aminoAcidDNA.get(15).add("TCG");
        aminoAcidDNA.get(15).add("AGT");
        aminoAcidDNA.get(15).add("AGC");
        aminoAcids.put("ser", aminoAcidDNA.get(15));

        aminoAcidDNA.add(new ArrayList<String>());
        aminoAcidDNA.get(16).add("ACT");
        aminoAcidDNA.get(16).add("ACC");
        aminoAcidDNA.get(16).add("ACA");
        aminoAcidDNA.get(16).add("ACG");
        aminoAcids.put("thr", aminoAcidDNA.get(16));
        
        aminoAcidDNA.add(new ArrayList<String>());
        aminoAcidDNA.get(17).add("TGG");
        aminoAcids.put("trp", aminoAcidDNA.get(17));
        
        aminoAcidDNA.add(new ArrayList<String>());
        aminoAcidDNA.get(18).add("TAT");
        aminoAcidDNA.get(18).add("TAC");
        aminoAcids.put("tyr", aminoAcidDNA.get(18));

        aminoAcidDNA.add(new ArrayList<String>());
        aminoAcidDNA.get(19).add("GTT");
        aminoAcidDNA.get(19).add("GTC");
        aminoAcidDNA.get(19).add("GTA");
        aminoAcidDNA.get(19).add("GTG");
        aminoAcids.put("val", aminoAcidDNA.get(19));

        aminoAcidDNA.add(new ArrayList<String>());
        aminoAcidDNA.get(20).add("TAA");
        aminoAcidDNA.get(20).add("TGA");
        aminoAcidDNA.get(20).add("TAG");
        aminoAcids.put("stop", aminoAcidDNA.get(20));
        
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
