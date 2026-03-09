package SymbolTable;

import java.util.HashMap;
import java.util.Map;

public class InventoryManager {
    // Storage: Key = Item Name, Value = Quantity
    private Map<String, Integer> backpack = new HashMap<>();
    /**
     * TASK 1: Add items to the backpack.
     * If the item already exists, increase the count.
     * If it's new, add it to the map with the initial amount.
     */
    public void pickupItem(String name, int amount) {
        // TODO: Fill in the logic using backpack.put()
        if(backpack.containsKey(name)){
            int current = backpack.get(name);
            backpack.put(name, current + amount);
        }else{
            backpack.put(name, amount);
        }
    }

    /**
     * TASK 2: Use an item.
     * If the item exists and quantity > 1, decrease the count by 1.
     * If quantity is 1, remove the item from the map entirely.
     */
    public void consumeItem(String name) {
        // TODO: Fill in logic using backpack.get(), put(), or remove()
        if(backpack.containsKey(name)){
            if(backpack.get(name) >1){
                backpack.put(name, backpack.get(name) -1);
            }else{
                backpack.remove(name);
            }
        }
    }

    /**
     * TASK 3: Check if the player can craft something.
     * Returns true only if the backpack has at least the required amount.
     */
    public boolean hasEnough(String name, int required) {
        // TODO: Fill in logic using backpack.get()
        if(backpack.containsKey(name)){
            return backpack.get(name) >= required;
        }
        return false;
    }
}

