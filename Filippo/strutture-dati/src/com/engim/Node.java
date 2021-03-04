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
        if (this.value==x){
            return this.next;
        } else {
            this.next= this.next.remove(x);
        }
        return this;
    }

    @Override
    public List removeAtIndex(int i) {
        if (i<=-1){
            return this.next;
        } else{
            this.next= this.next.removeAtIndex(i-1);
        }
        return this;
    }

    @Override
    public List doppio() {
        this.next= new Node(this.value,this.next.doppio());
        return this;
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
    @Override
    public boolean ordinataCrescenteDecrescente(Ordine ordine, int value) {
        if(value==0 && ordine==ordine.Start && value== this.value){
            return this.next.ordinataCrescenteDecrescente(ordine.Start,this.value);
        }
        if(this.value>value && ordine==ordine.Start){
            return this.next.ordinataCrescenteDecrescente(ordine.Asc, this.value);
        }
        if(this.value<value && ordine==ordine.Start){
            return this.next.ordinataCrescenteDecrescente(ordine.Desc, this.value);
        }
        if(this.value>=value && ordine==ordine.Asc){
            return this.next.ordinataCrescenteDecrescente(ordine.Asc, this.value);
        }
        if(this.value<=value && ordine==ordine.Desc){
            return this.next.ordinataCrescenteDecrescente(ordine.Desc, this.value);
        }
        if(this.value>value && ordine==ordine.Desc){
            return false;
        }
        if(this.value<value && ordine==ordine.Asc){
            return false;
        }
        return false;
    }
}
