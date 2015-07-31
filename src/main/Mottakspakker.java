package main;

import java.util.*;

public class Mottakspakker {

    public void lagMottakspakker(Map<String, Set<String>> pakker){

        ArrayList<Bootcampdeltaker> bootcampdeltakere = new ArrayList<>();
        bootcampdeltakere.add(new Bootcampdeltaker("Tech", "Tine", false));
        bootcampdeltakere.add(new Bootcampdeltaker("Interactive", "Linda", true));

        for (Bootcampdeltaker bootcampdeltaker : bootcampdeltakere) {

            HashSet<String> innhold = new HashSet<>();

            if(bootcampdeltaker.getAvdeling().equals("Tech")){
                innhold.add("Clean Code");
            }else if(bootcampdeltaker.getAvdeling().equals("Interactive")){
                innhold.add("Just enouch research");
            }

            if (bootcampdeltaker.isPc()) {
                innhold.add("PC eller MAC");
            }
            pakker.put(bootcampdeltaker.getNavn(), innhold);
        }

    }

    public static void main(String[] args) {
        Map<String, Set<String>> pakker = new HashMap<>();
        Mottakspakker mottakspakker = new Mottakspakker();
        mottakspakker.lagMottakspakker(pakker);
        System.out.println(pakker);
    }



    private class Bootcampdeltaker{


        private final boolean pc;
        private final String navn;
        private final String avdeling;

        public Bootcampdeltaker(String avdeling, String navn, boolean pc) {
            this.avdeling = avdeling;
            this.navn = navn;
            this.pc = pc;
        }

        public boolean isPc() {
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
