//KEVIN DU, 10/30/2021

import java.util.Scanner;
import java.util.StringTokenizer;

public class InvTracker {
    InvItem[] items;
    Scanner scanner = new Scanner(System.in);
    StringTokenizer st;


    public void name(long num, String str) {
        //Assigns the String as the name field for every element in items with id equal to the parameter long
        //make a for each loop that will assign str to every items element
        for (InvItem s : items) {
            if (s.getId() == num) {
                s.setName(str);


            }


        }


    }

    public void add(long num, int n) {
        for (InvItem s : items) {
            if (s.getId() == num) {
                s.add(n);


            } else {
                new InvItem(num).add(n);
                InvItem[] newSize = new InvItem[items.length + 1];
                //create new Array with size of original array+1
                //loop will copy everything from items into newSize
                for (int i = 0; i < items.length; i++) {
                    newSize[i] = items[i];
                    //put newly sized array into old array
                    items = newSize;


                }


            }


        }


    }

    public void remove(long num, int n) {
        for (InvItem s : items) {
            if (s.getId() == num && s.getQuantity() >= n) {
                //substract n from s' quantity variable
                s.drop(n);
            } else {
                System.out.println("no matching record found");


            }


        }


    }

    public void list(){



    }


    public static void main(String[] args) {

    }


}

class InvItem {
    private long id;
    private String name;
    private int quantity;

    public InvItem(long id) {
        this.id = id;
        this.name = "";
        this.quantity = 0;


    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;


    }

    public long getId() {
        return this.id;


    }

    public void setId(long id) {
        this.id = id;


    }

    public int getQuantity() {
        return this.quantity;


    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;


    }

    public void add(int add) {
        this.quantity += add;

    }

    public void drop(int drop) {
        this.quantity -= drop;


    }


}



