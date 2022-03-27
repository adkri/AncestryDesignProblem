package main;

import dna.DnaSequence;

import java.util.List;

public class Main {
    public static void main(String[] args) {

        String dna = "GCTCGCAACATCGGATATAGA";
        String dna1 = "CCCACGATGGTAGGAGTTTLA";
        System.out.println("DNA: " + dna);
        System.out.println("The amino acids produced by this DNA Sequence is:");
        
        DnaSequence dnaSequence = new DnaSequence();
        List<String> aminoacid = dnaSequence.transcribe(dna);

        String separater = "";
        for(String acid : aminoacid) {
            System.out.print(separater + acid);
            separater = "-";
        }
        System.out.println();
        
        System.out.println("Second DNA strand: "+ dna1);
        System.out.println("The amino acids produced by this DNA Sequence is: ");
        DnaSequence dnaSeq = new DnaSequence();
        List<String> aminoSeq = dnaSequence.transcribe(dna1);
        
        String sep ="";
        for(String acid : aminoSeq) {
            System.out.print(sep + acid);
            sep = "-";
        }
        System.out.println();
        
    }
}
