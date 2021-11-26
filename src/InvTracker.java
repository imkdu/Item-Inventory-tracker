//KEVIN DU, 11/26/2021

import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.StringTokenizer;

public class InvTracker {
    InvItem[] items;
    Scanner scanner;
    StringTokenizer st;

    public InvTracker() {
        scanner = new Scanner(System.in);
        items = new InvItem[0];
    }

    public static void main(String[] args) {
        InvTracker tracker = new InvTracker();
        while (true) {
            try {
                System.out.print("please enter your command\n>");
                String s = tracker.scanner.nextLine();
                tracker.st = new StringTokenizer(s);
                String t = tracker.st.nextToken();
                if (t.equals("list")) tracker.list();
                else if (t.equals("add")) {
                    String u = tracker.st.nextToken();
                    String v = tracker.st.nextToken();
                    tracker.add(Long.parseLong(u), Integer.parseInt(v));
                } else if (t.equals("name")) {
                    String u = tracker.st.nextToken();
                    String v = tracker.st.nextToken();
                    tracker.name(Long.parseLong(u), v);
                } else if (t.equals("remove")) {
                    String u = tracker.st.nextToken();
                    String v = tracker.st.nextToken();
                    tracker.remove(Long.parseLong(u), Integer.parseInt(v));
                } else if (t.equals("exit")) System.exit(0);
                else throw new Exception();
            } catch (Exception e) {
                System.out.println("invalid command");
            }
            System.out.println();
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


    void add(long id, int amount) {
        boolean isFound = false;
        for (int i = 0; i < items.length; i++) {
            if (items[i].getId() == id) {
                isFound = true;
                try {
                    items[i].add(amount);
                } catch (Exception e) {
                    System.out.println("invalid quantity change");
                }
                return;
            }
        }
        InvItem item = new InvItem(id);
        try {
            item.add(amount);
            InvItem[] items2 = new InvItem[items.length + 1];
            for (int j = 0; j < items.length; j++) items2[j] = items[j];
            items2[items.length] = item;
            items = items2;
        } catch (Exception e) {
            System.out.println("invalid quantity change");
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
        if (this.quantity + add > 9999 || this.quantity + add < 1) {
            System.out.println("invalid quantity change");

        } else quantity += add;

    }

    public void drop(int drop) {
        if (this.quantity + drop > 9999 || this.quantity + drop < 1) {
            System.out.println("invalid quantity change");

        } else quantity += drop;


    }


}



