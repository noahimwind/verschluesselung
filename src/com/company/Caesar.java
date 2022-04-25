package com.company;

import java.io.*;

public class Caesar {

    private char[] alphabet = {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};

    private int verschiebung;

    BufferedReader br = null;
    BufferedWriter bw = null;

    File file = new File("C:\\Users\\noahd\\Documents\\SWD\\verschluesselung.txt");

    public String ausDateiLesen() throws IOException {
        br = new BufferedReader(new FileReader(file));
        String auslesen = "";
        auslesen = br.readLine();
        br.close();
        return auslesen;
    }

    public void inDateiSchreiben(String text) throws IOException {
        bw = new BufferedWriter(new FileWriter(file));
        bw.write(text);
        bw.close();
    }

    // wandelt den Buchstaben in seine zugehörige Nummer im Alphabet an (Klartextalphabet)
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
        else if (i < 0){
            i = i + 26;
        }
        return alphabet[i];
    }

    // verschlüsselt den klartext
    public void verschluesseln(int verschiebung) throws IOException {

        String klartext = this.ausDateiLesen();     //  zu verschlüsselnder Text aus der Datei
        String chiffre = "";    //  hier drin wird der verschlüsselte Text gespeichert

        //  for Schleife geht durch den ganzen Klartext
        for (int i = 0; i < klartext.length(); i++){
            char buchstabe = klartext.charAt(i);    // der aktuelle Buchstabe aus dem Klartext
            int nrBuchstabe = getNumberofChar(buchstabe);   //   Nummer des aktuellen Buchstabens
            char newBuchstabe = getBuchstabe(nrBuchstabe + verschiebung);   //  verschlüsselter Buchstabe
            chiffre += newBuchstabe;    //  reiht die Buchstaben der Chiffre aneinander
        }

        this.inDateiSchreiben(chiffre); //  überschreibt den Klartext mit der Chiffre
    }

    public void entschluesseln(int verschiebung) throws IOException {
        String chiffre = this.ausDateiLesen();
        String klartext = "";
        for (int i = 0; i < chiffre.length(); i++){
            char buchstabe = chiffre.charAt(i);    // der aktuelle Buchstabe aus der Chiffre
            int nrBuchstabe = getNumberofChar(buchstabe);
            char newBuchstabe = getBuchstabe(nrBuchstabe - verschiebung);
            klartext += newBuchstabe;
        }
        this.inDateiSchreiben(klartext);
    }
}
