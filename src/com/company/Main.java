package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws Exception {
        Rijndael r = new Rijndael("mZq4t7w!z%C*F)J@");
        Caesar c = new Caesar();
        Scanner sc = new Scanner(System.in);

        System.out.println("v Verschluesseln oder e Entschluesseln? ");
        String modus = sc.next();
        if (modus.equals("v")){
            System.out.println("Mit welchem Algorithmus moechten Sie die Datei verschluesseln?");
            System.out.println("r = rijndael; c = caesar");
            String eingabe = sc.next();
            if (eingabe.equals("r")){
                r.verschluesseln();
                System.out.println("Text wurde mit Rijndael verschlüsselt");
            }
            else if (eingabe.equals("c")){
                System.out.println("Geben Sie einen Schluessel ein (1-25):");
                int verschiebung = Integer.parseInt(sc.next());
                c.verschluesseln(verschiebung);
                System.out.println("Text wurde mit Caesar verschlüsselt");
            }
        }
        else if (modus.equals("e")){
            System.out.println("Mit welchem Algorithmus moechten Sie die Datei entschluesseln?");
            System.out.println("r = rijndael; c = caesar");
            String eingabe = sc.next();
            if (eingabe.equals("r")){
                r.entschluesseln();
                System.out.println("Text wurde mit Rijndael entschlüsselt");
            }
            else if (eingabe.equals("c")){
                System.out.println("Geben Sie einen Schluessel ein (1-25):");
                int verschiebung = Integer.parseInt(sc.next());
                c.entschluesseln(verschiebung);
                System.out.println("Text wurde mit Caesar entschlüsselt");
            }
        }

    }
}
