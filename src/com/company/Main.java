package com.company;

public class Main {

    public static void main(String[] args) throws Exception {
        /*Rijndael x = new Rijndael("mZq4t7w!z%C*F)J@");
        System.out.println(x.verschluesseln());
        x.entschluesseln();*/

        Caesar x = new Caesar();
        System.out.println(x.verschluesseln("abc", 2));
        System.out.println(x.entschluesseln("cde", 2));
    }
}
