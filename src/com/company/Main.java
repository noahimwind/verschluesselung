package com.company;

public class Main {

    public static void main(String[] args) throws Exception {
        /*Rijndael x = new Rijndael("mZq4t7w!z%C*F)J@");
        System.out.println(x.verschluesseln());
        x.entschluesseln();*/

        Caesar x = new Caesar();
        x.verschluesseln(2);
        //x.entschluesseln(2);
    }
}
