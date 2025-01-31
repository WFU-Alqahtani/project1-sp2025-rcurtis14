import java.util.ArrayList;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.

// Ryan Curtis
// 1/30/25
// Lab 1

public class Main {
    public static void main(String[] args) {

        printReceiptInOrder(setupStore(), createCart(setupStore(), args), args); //calls the receipt and passes in the information from the store
        // as well as the created cart
        emptyCartReverseOrder(createCart(setupStore(), args), args); // Prints the receipt in reverse order
    }
    //creates a store of items, which can be referenced by the index of the item in the array Item[]
    public static Item[] setupStore (){
        Item[] store = new Item[5];
        store [0] = new Item("Chips   ", 3.00);
        store [1] = new Item("Gum     ", 1.50);
        store [2] = new Item("Candy   ", 2.50);
        store [3] = new Item("Iced Tea", 2.00);
        store [4] = new Item("Milk    ", 5.00);
        return store;
    }

    public static ArrayList<Item> createCart (Item[] store, String[] args) {
        // initializes the cart array list which will be used throughout the process of the code
        ArrayList<Item> cart = new ArrayList<Item>();
        int amountItemsPurchased = 0;
        //checks the first item in the args list and makes sure it is an integer
        try{amountItemsPurchased = Integer.parseInt(args[0]);}
            catch(NumberFormatException e){
                System.out.println(" Please enter an integer amount of items. ");
            }
        //adds items to cart Arraylist with a for loop that runs based on the amount of items given by the user

            for (int i = 1; i < amountItemsPurchased; i++) {
                int itemIndex = 0;
                try{itemIndex  = Integer.parseInt(args[i]);}
                catch (NumberFormatException e) {
                    System.out.println(" Please enter an integer. ");}
                Item selectedItem = store[itemIndex];
                cart.add(selectedItem);
            }
            //returns the cart arrayList to be used or not if the user does not input an integer amount of items.
        return cart;
    }
    public static void printReceiptInOrder(Item[] store, ArrayList<Item> cart, String[] args){
        int num = args.length;

        int userCartSize = 0;
        //
        try{ userCartSize = Integer.parseInt(args[0]);} // tries to parse the first argument of items in the cart
        catch(NumberFormatException e){
            System.out.println(" Please enter an integer amount of items. ");
        }
        //Checks if the declared number of items is greater than the actual number of items
        if (userCartSize > num -1){
            System.out.println("There are less items in cart than originally declared.");
        }
        System.out.println("Receipt:\n==============================");
        System.out.println("Item           Price");

        // Prints the formatted receipt starting from after the first argument in case the first element is not an integer or throws an error
        for (int i = 1; i < num ; i++) {
           int itemNum = Integer.parseInt(args[i]);
            System.out.println(store[itemNum].getItemName() + "        $" + store[itemNum].getItemPrice());
        }
        double subtotal = 0;
        for (int i = 1; i < num ; i++) {
            int itemNum = Integer.parseInt(args[i]);
            subtotal += store[itemNum].getItemPrice();
        }

        //calculates and prints total and subtotal
        System.out.println("==============================");
        System.out.printf("Subtotal: %.2f", subtotal);
        double salesTax = subtotal * .05;
        System.out.printf("\nSales tax: %.2f", salesTax );
        double Total = subtotal + salesTax;
        System.out.printf("\nTotal = %.2f", Total);
    }

    public static void emptyCartReverseOrder (ArrayList<Item> cart, String[] args){
    System.out.println("\nRemoving all items from the cart in ''Last In First Out'' order...");
     //prints the receipt in reverse order by starting at the last element in the array list and counting down
    for (int i = cart.size(); i > 0; i--) {
            try{int itemNum = Integer.parseInt(args[i]);}
            catch (NumberFormatException e){
                System.out.println(" Please enter an integer selection of item. ");
            }
            System.out.println("Removing: " + cart.get(i-1).getItemName());
        }
        System.out.println("Cart has been emptied");
    }
}