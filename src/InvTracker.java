import java.util.Scanner;
import java.util.StringTokenizer;

public class InvTracker {
    InvItem[] items;
    Scanner scanner = new Scanner(System.in);
    StringTokenizer st;


}

class InvItem {
    private long id;
    private String name;
    private int quantity;

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



}



