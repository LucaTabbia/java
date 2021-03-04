package com.engim;

public class Node extends List{
    private int value;
    private List next;

    public Node(int value, List next) {
        this.value = value;
        this.next = next;
    }

    @Override
    public String toString() {
        return value + " " + next.toString();
    }

    @Override
    public List addLast(int x) {
        this.next = this.next.addLast(x);
        return this;
    }

    public void addLast2(int x){
        if(this.next instanceof Nil)
            this.next = new Node(x, this.next);
        else
            this.next.addLast2(x);
    }

    @Override
    public List add(int x, int i) {
        if (i==0 ||i<0){
            return new Node(x, this);
        }
        else {
            this.next = next.add(x, i-1);
        }
        return this;
    }

    @Override
    public List remove(int x) {
        if (x==this.value){

        } else {
            this.next= next.remove(x);
        }
    }

    @Override
    public List removeAtIndex(int i) {
        if (i==0 || i<0){
            this= this.next;
        }
    }

    @Override
    public List doppio() {
        return null;
    }

    @Override
    public boolean pari() {
        if (this.value%2==0 || this.value==0){
            this.next.pari();
        } else {
            return false;
        }
        return false;
    }

    @Override
    public boolean ordinata(int next) {
        if(next==0) {
            next = this.value;
        }
        if (next <= this.value){
            next= this.value;
            this.next.ordinata(next);
        } else {
            return false;
        }
        return false;
    }
}
