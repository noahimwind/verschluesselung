package com.company;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.io.*;
import java.security.Key;

public class Rijndael {
    private static final String algorithmus = "AES";
    private static byte[] schluesselWert;
    BufferedReader br = null;
    BufferedWriter bw = null;
    File file = new File("C:\\Users\\noahd\\Documents\\SWD\\verschluesselung.txt");

    public Rijndael(String schluessel) {
        schluesselWert = schluessel.getBytes();
    }

    public String ausDateiLesen() throws IOException {
        br = new BufferedReader(new FileReader(file));
        String read = "";
        read = br.readLine();
        br.close();
        return read;
    }

    public void inDateiSchreiben(String text) throws IOException {
        bw = new BufferedWriter(new FileWriter(file));
        bw.write(text);
        bw.close();
    }

    public void verschluesseln() throws Exception{
        String daten = this.ausDateiLesen();
        Key schluessel = schluesselGenerieren();
        Cipher cipher = Cipher.getInstance(algorithmus);
        cipher.init(Cipher.ENCRYPT_MODE, schluessel);
        byte[] encVal = cipher.doFinal(daten.getBytes());
        String encryptedValue = java.util.Base64.getEncoder().encodeToString(encVal);
        this.inDateiSchreiben(encryptedValue);
    }

    public void entschluesseln() throws Exception{
        String verschlüsselteDaten = this.ausDateiLesen();
        System.out.println(verschlüsselteDaten);
        Key schluessel = schluesselGenerieren();
        Cipher cipher = Cipher.getInstance(algorithmus);
        cipher.init(Cipher.DECRYPT_MODE, schluessel);
        byte[] decodedValue = java.util.Base64.getDecoder().decode(verschlüsselteDaten);
        byte[] decValue = cipher.doFinal(decodedValue);
        String decryptedValue = new String(decValue);
        this.inDateiSchreiben(decryptedValue);
    }

    private static Key schluesselGenerieren() throws Exception{
        Key schluessel = new SecretKeySpec(schluesselWert, algorithmus);
        return schluessel;
    }

    public String auswahl(String choice) throws Exception {
        if (choice == "v"){
            this.verschluesseln();
            return choice;
        }
        else if (choice == "e"){
            this.entschluesseln();
            return choice;
        }
        return choice;
    }

}
