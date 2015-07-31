package main;

public class Ansatt {

    private String fornavnString;
    private String etternavnString;
    private String ssnNumber;
    private int mob;

    public Ansatt(String ssn, String fornavn, String etternavn){
        this.ssnNumber = ssn;
        this.fornavnString = fornavn;
        this.etternavnString = etternavn;
    }

    public String ansattnavn(){
        return this.fornavnString + " " +  this.etternavnString;
    }

    public void setMob(int mob) {
        this.mob = mob;
    }

    public static void main(String[] args) {
        Ansatt nora = new Ansatt("29028409638", "Nora", "Hansen");
        nora.setMob(23357701);
        System.out.println(nora.ansattnavn());
    }



}
