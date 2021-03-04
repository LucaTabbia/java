package com.engim;

public class Main {

    public static void main(String[] args) {
        List l = new Node(1,new Node(2,new Node(3,new Nil())));
/*
        Nil nil = new Nil();
        Node n3 = new Node(3, nil);
        Node n2 = new Node(2, n3);
        Node n1 = new Node(1, n2);
        List l1 = n1;*/

        System.out.println(l);
        l = new Node(0, l);

        System.out.println(l);

        l = l.addLast(4);
        System.out.println(l);

    }
}
