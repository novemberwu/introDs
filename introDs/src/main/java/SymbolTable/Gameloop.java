package SymbolTable;

public class Gameloop {
    public static void main(String[] args) {
        InventoryManager myPlayer = new InventoryManager();


        // 1. Test Pickup
        myPlayer.pickupItem("Wood", 10);
        myPlayer.pickupItem("Wood", 5);
        System.out.println("Should have 15 Wood: " + myPlayer.hasEnough("Wood", 15));
        // 2. Test Consumption
        myPlayer.consumeItem("Wood");
        System.out.println("Should have 14 Wood: " + myPlayer.hasEnough("Wood", 14));
        // 3. Test Crafting Check
        if (myPlayer.hasEnough("Wood", 20)) {
            System.out.println("Built a house!");
        } else {
            System.out.println("Need more resources!");
        }
    }
}

