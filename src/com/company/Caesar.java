package com.company;
// TODO: Leerzeichen und Sonderzeichen fixen
// TODO: Groß und Kleinschreibung fixen
// TODO: Dateiein- und ausgabe

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

public class Caesar {

    private char[] alphabet = {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};

    private int verschiebung;

    RandomAccessFile raf = null;

    File file = new File("C:\\Users\\noahd\\Documents\\SWD\\caesarklartext.txt");  //caesarklartext.txt

    public String ausDateiLesen() throws IOException {
        raf = new RandomAccessFile(file, "r");
        String text = "";
        for (int i = 0; i < file.length(); i++){
            text += (char)raf.readByte();
        }
        raf.close();
        return text.replaceAll(" ", "");
    }

    public void inDateiSchreiben(String text) throws IOException {
        text = text.replaceAll(" ", "");
        raf = new RandomAccessFile(file, "rw");
        raf.setLength(0);
        raf.writeChars(text);
        raf.close();
    }

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
        else if (i < 0){
            i = i + 26;
        }
        return alphabet[i];
    }

    // verschlüsselt den klartext
    public void verschluesseln(int verschiebung) throws IOException {
        String klartext = this.ausDateiLesen();
        String chiffre = "";
        for (int i = 0; i < klartext.length(); i++){
            char buchstabe = klartext.charAt(i);    // der aktuelle Buchstabe aus dem Klartext
            int nrBuchstabe = getNumberofChar(buchstabe);
            char newBuchstabe = getBuchstabe(nrBuchstabe + verschiebung);
            chiffre += newBuchstabe;
        }
        this.inDateiSchreiben(chiffre);
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
        this.inDateiSchreiben(klartext.replaceAll(" ", ""));
    }
}
