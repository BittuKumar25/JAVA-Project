import java.util.*;
class Item {
    String itemId;
    String itemName;
    int quantity;
    Item(String itemId, String itemName, int quantity) {
        this.itemId = itemId;
        this.itemName = itemName;
        this.quantity = quantity;
    }

    void displayItem() {

      System.out.println("Item ID : " + itemId);
      System.out.println("Item Name : " + itemName);
      System.out.println("Quantity : " + quantity);
    }
}

class Warehouse {

    Item[][] grid;
    Warehouse(int rows, int cols) {
        grid = new Item[rows][cols];
    }
    void addItem(int row, int col, Item item) {
        grid[row][col] = item;
    }
    void searchItem(String id) {
        boolean found = false;
        System.out.println("Searching for item ID : " + id);
        for (int i = 0; i < grid.length; i++) {
         for (int j = 0; j < grid[i].length; j++) {
          if (grid[i][j] != null &&
           grid[i][j].itemId.equals(id)) {
               System.out.println("Item found at Row : "
                  + i + ", Column : " + j);
                 grid[i][j].displayItem();
                    found = true;
                }
            }
        }
        if (!found) {
            System.out.println("Item not found in warehouse");
        }
    }
    void displayWarehouse() {
        System.out.println("\nWarehouse Grid : ");
        for (int i = 0; i < grid.length; i++) {
         for (int j = 0; j < grid[i].length; j++) {
          if (grid[i][j] != null) {
           System.out.print(grid[i][j].itemId + "\t");
         } else {
          System.out.print("EMPTY\t");
        }
     }
          System.out.println();
        }
    }
}
public class main {
        public static void main(String[] args) {
        Warehouse warehouse = new Warehouse(5, 5);
         warehouse.addItem(0, 0,
          new Item("I101", "Laptop", 10));
          warehouse.addItem(1, 2,
            new Item("I102", "Phone", 25));
        warehouse.addItem(3, 1,
         new Item("I103", "Tablet", 15));
        warehouse.displayWarehouse();
        warehouse.searchItem("I102");
        warehouse.searchItem("I999");
    }
}
