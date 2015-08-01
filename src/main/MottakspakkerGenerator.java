package main;

import java.util.*;

public class MottakspakkerGenerator {
    
    public Map<String, Set<String>> lagMottakspakker(List<Bootcampdeltaker> bootcampdeltakere){
        Map<String, Set<String>> pakker = new HashMap<>();

        for (Bootcampdeltaker bootcampdeltaker : bootcampdeltakere) {

            Set<String> innhold = genererPakkeinhold(bootcampdeltaker);
            pakker.put(bootcampdeltaker.getNavn(), innhold);
        }

        return pakker;
    }


    private Set<String> genererPakkeinhold(Bootcampdeltaker bootcampdeltaker) {
        Set<String> innhold = Collections.emptySet();
        innhold.addAll(hentAvdelingsinnhold(bootcampdeltaker));
        innhold.addAll(hentMaskinpakke(bootcampdeltaker));
        return innhold;
    }

    private Set<String> hentMaskinpakke(Bootcampdeltaker bootcampdeltaker) {
        Set<String> maskinpakke = Collections.emptySet();
        if (bootcampdeltaker.trengerPc()) {
            maskinpakke.add("PC eller MAC");
        }
        return maskinpakke;
    }

    private Set<String> hentAvdelingsinnhold(Bootcampdeltaker bootcampdeltaker) {
        Set<String> avdelingsinnhold = Collections.emptySet();

        if(bootcampdeltaker.getAvdeling().equals("Tech")){
            avdelingsinnhold.add("Clean Code");
        } else if(bootcampdeltaker.getAvdeling().equals("Interactive")){
            avdelingsinnhold.add("Just enouch research");
        }
        return avdelingsinnhold;
    }


    private List<Bootcampdeltaker> opprettDeltakere() {

        return Arrays.asList(
                Bootcampdeltaker.deltakerMedPc("Tech", "Tine"),
                Bootcampdeltaker.deltakerUtenPc("Interactive", "Linda")

        );
    }

    public static void main(String[] args) {
        MottakspakkerGenerator mottakspakker = new MottakspakkerGenerator();
        Map<String, Set<String>> pakker = mottakspakker.lagMottakspakker(mottakspakker.opprettDeltakere());
        System.out.println(pakker);
    }



    private static class Bootcampdeltaker{


        private final boolean pc;
        private final String navn;
        private final String avdeling;

        public static Bootcampdeltaker deltakerUtenPc(String navn, String avdeling){
            return new Bootcampdeltaker(avdeling, navn, false);
        }

        public static Bootcampdeltaker deltakerMedPc(String navn, String avdeling){
            return new Bootcampdeltaker(avdeling, navn, true);
        }

        private Bootcampdeltaker(String avdeling, String navn, boolean trengerPc) {
            this.avdeling = avdeling;
            this.navn = navn;
            this.pc = trengerPc;
        }

        public boolean trengerPc() {
            return pc;
        }

        public String getNavn() {
            return navn;
        }

        public String getAvdeling() {
            return avdeling;
        }
    }
}
