//KEVIN DU, 11/01/2021

import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.StringTokenizer;

public class InvTracker {
    InvItem[] items;
    Scanner scanner = new Scanner(System.in);
    StringTokenizer st;

    public InvTracker() {
        scanner = new Scanner(System.in);
        items = new InvItem[0];
    }

    public static void main(String[] args) {


        InvTracker inv = new InvTracker();
        Scanner scanner = new Scanner(System.in);


        //"method()" [value1] [value2]
        while (true) {
            String[] arr = new String[3];
            String input = scanner.nextLine();
            StringTokenizer st = new StringTokenizer(input, " ");
            int numTokens = st.countTokens();

            try {
                if (numTokens > 3) {
                    throw new ArrayIndexOutOfBoundsException();


                }
                //while st has more tokens, store them in the array, so we can call the elements later

                for (int i = 0; i < numTokens; i++) {


                    arr[i] = st.nextToken();


                    if (!"name".equals(arr[0]) && !"add".equals(arr[0]) && !"remove".equals(arr[0]) && !"list".equals(arr[0])) {
                        throw new ArrayIndexOutOfBoundsException();

                    }


                }


                if (arr[0].equalsIgnoreCase("name")) {
                    inv.name(Long.parseLong(arr[1]), arr[2]);


                }
                if (arr[0].equalsIgnoreCase("add")) {
                    inv.add(Long.parseLong(arr[1]), Integer.parseInt(arr[2]));

                }
                if (arr[0].equalsIgnoreCase("remove")) {
                    inv.remove(Long.parseLong(arr[1]), Integer.parseInt(arr[2]));


                }
                if (arr[0].equalsIgnoreCase("list")) {
                    inv.list();


                }


            } catch (Exception e) {
                System.out.println("Invalid command");


            }
        }


    }


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
                    return;


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

    public void list() {
        if (items.length == 0) {
            System.out.println("no records to display");


        } else {
            for (InvItem item : items) {
                System.out.println(item.getId() + " " + item.getName() + " " + item.getQuantity() + "\n");


            }

        }
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



