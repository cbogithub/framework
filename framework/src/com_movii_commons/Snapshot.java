package com_movii_commons;
import java.util.ArrayList;

public class Snapshot {
    private ArrayList<Integer> data;
    private ArrayList<Integer> data2;

    public Snapshot(ArrayList<Integer> data) {
    	System.out.println("hi");
        this.data = data;
        data2=data;
    }

    public ArrayList<Integer> restore() {
    	System.out.println("fy" +data);
    	System.out.println(data2);
        return data;
    }

    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        System.out.println("FI");
        list.add(1);
        list.add(2);
        
        Snapshot snap = new Snapshot(list);
        System.out.println();
        list.set(0, 3);
        list = snap.restore();
        System.out.println(list); //It should log "[1,2]"
        list.add(4);
        list = snap.restore();
        System.out.println(list); //It should log "[1,2]"
    }
}