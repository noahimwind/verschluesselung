package com.company;
// TODO: Leerzeichen und Sonderzeichen fixen
// TODO: Groß und Kleinschreibung fixen
// TODO: Dateiein- und ausgabe

public class Caesar {

    private char[] alphabet = {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};

    private int verschiebung;

    // wandelt den Buchstaben in seine zugehörige Stelle im Alphabet an (Klartextalphabet)
    public int getNumberofChar(char buchstabe){
        for(int i = 0; i < 26; i = i + 1) {
            if(alphabet[i] == buchstabe) {
                return i;
            }
        }
        return 0;
    }

    // gibt den Buchstaben an der gewählten Stelle aus dem Alphabet aus
    public char getBuchstabe(int i){
        if (i >= 26){
            i = i - 26;
        }
        return alphabet[i];
    }

    // verschlüsselt den klartext
    public String verschluesseln(String klartext, int verschiebung){
        String chiffre = "";
        for (int i = 0; i < klartext.length(); i++){
            char buchstabe = klartext.charAt(i);    // der aktuelle Buchstabe aus dem Klartext
            int nrBuchstabe = getNumberofChar(buchstabe);
            char newBuchstabe = getBuchstabe(nrBuchstabe + verschiebung);
            chiffre += newBuchstabe;
        }
        return chiffre;
    }

    public String entschluesseln(String chiffre, int verschiebung){
        String klartext = "";
        for (int i = 0; i < chiffre.length(); i++){
            char buchstabe = chiffre.charAt(i);    // der aktuelle Buchstabe aus der Chiffre
            int nrBuchstabe = getNumberofChar(buchstabe);
            char newBuchstabe = getBuchstabe(nrBuchstabe - verschiebung);
            klartext += newBuchstabe;
        }
        return klartext;
    }
}
