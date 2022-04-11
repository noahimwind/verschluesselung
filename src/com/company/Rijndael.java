package com.company;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.security.Key;

public class Rijndael {
    private static final String algorithmus = "AES";
    private static byte[] schluesselWert;
    RandomAccessFile raf = null;
    File file = new File("C:\\Users\\noahd\\Documents\\SWD\\rijndael.txt");

    public Rijndael(String schluessel) {
        schluesselWert = schluessel.getBytes();
    }

    public String auslesen() throws IOException {
        raf = new RandomAccessFile(file, "r");
        String read = "";
        for (int i = 0; i < file.length(); i++){
            read += (char)raf.readByte();
        }
        raf.close();
        return read;
    }

    /*public void schreiben(String choice) throws Exception {
        raf = new RandomAccessFile(file, "rw");
        if (choice == "v"){
            raf.write(this.verschluesseln());
        }
        else if (choice == "e"){
            raf.write(this.entschluesseln());
        }
    }*/

    public String verschluesseln() throws Exception{
        String daten = this.auslesen();
        Key schluessel = schluesselGenerieren();
        Cipher cipher = Cipher.getInstance(algorithmus);
        cipher.init(Cipher.ENCRYPT_MODE, schluessel);
        byte[] encVal = cipher.doFinal(daten.getBytes());
        String encryptedValue = java.util.Base64.getEncoder().encodeToString(encVal);
        return encryptedValue;
    }

    public String entschluesseln() throws Exception{
        String verschlüsselteDaten = this.auslesen();
        System.out.println(verschlüsselteDaten);
        Key schluessel = schluesselGenerieren();
        Cipher cipher = Cipher.getInstance(algorithmus);
        cipher.init(Cipher.DECRYPT_MODE, schluessel);
        byte[] decodedValue = java.util.Base64.getDecoder().decode(verschlüsselteDaten);
        byte[] decValue = cipher.doFinal(decodedValue);
        String decryptedValue = new String(decValue);
        return decryptedValue;
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
