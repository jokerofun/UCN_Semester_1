package Model;
import java.util.*;


/**
 * WarehouseContainer containing list of warehouses.
 *
 * @author Alexandru Krausz, Martin Benda, Sebastian Labuda, Simeon Kolev
 * @version 2019.12.8
 */
public class WarehouseContainer
{
    // instance variables
    private static WarehouseContainer instance;
    private ArrayList<Warehouse> warehouses;

    /**
     * Constructor for WarehouseContainer
     * @param warehouses containing warehouses 
     */
    private WarehouseContainer()
    {
        warehouses = new ArrayList<>();
        addWarehouse(new Warehouse("Diy","str 23.","500m2",1000));
        addWarehouse(new Warehouse("Timber","str 23.","500m2",1000));
        
    }
    
    /**
     * Creates and returns an instance of WarehouseContainer
     * @return warehouseContainer instance
     */
    public static WarehouseContainer getWarehouseContainer()
    {
        if(instance == null){
            instance = new WarehouseContainer();
        }
        return instance;
    }
    
    /**
     * Used to add a warehouse to the list of warehouses
     * @param warehouse Warehouse
     */
    public void addWarehouse(Warehouse warehouse)
    {
        warehouses.add(warehouse);
    }
    
    /**
     * Used to remove a warehouse from the list of warehouses
     * @param warehouse Warehouse
     */
    public void removeWarehouse(Warehouse warehouse)
    {
        warehouses.remove(warehouse);
    }
    
    /**
     * Used to find a warehouse from the list of warehouses by name
     * @param name String
     * @return warehouse Warehouse
     */
    public Warehouse findWarehouseByName(String name)
    {
        boolean found = false;
        int i = 0;
        while(i<warehouses.size() && !found){
            if(warehouses.get(i).getName().equalsIgnoreCase(name)){
                found = true;
            }else{
                i++;
            }
        }
        if(!found)
        {
            return null;
        }
        else
        {
            return warehouses.get(i);
        }
    }
}
