import java.util.ArrayList;
/**
 * Class Playground controls of all playground and their available timeslots
 * @author Abdelaziz Khalid Kamil
 * Date: 6/9/2021
 */
public class Playground {

    private String name;
    private int capacity;
    private String location;
    private double hour_cost;
    private ArrayList<TimeSlot> slots = new ArrayList<TimeSlot>(2);
    private Owner owner;
    private boolean permission;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public double getHour_cost() {
        return hour_cost;
    }

    public void setHour_cost(double hour_cost) {
        this.hour_cost = hour_cost;
    }

    public ArrayList<TimeSlot> getSlots() {
        return slots;
    }

    public void setSlots(ArrayList<TimeSlot> slots) {
        this.slots = slots;
    }

    public Owner getOwner() {
        return owner;
    }

    public void setOwner(Owner owner) {
        this.owner = owner;
    }

    public void addSlot(TimeSlot ts){
        // add a new slot to the playground
        slots.add(ts);
    }


    public Playground(String name, int capacity, String location, double hour_cost, Owner owner) {
        this.name = name;
        this.capacity = capacity;
        this.location = location;
        this.hour_cost = hour_cost;
        this.owner = owner;
    }

    public Playground(String name, int capacity, String location, double hour_cost, ArrayList<TimeSlot> slots, Owner owner) {
        this.name = name;
        this.capacity = capacity;
        this.location = location;
        this.hour_cost = hour_cost;
        this.slots = slots;
        this.owner = owner;
    }

    /**
     *show playground's main info
     */
    public void showPlayground(){
        
        System.out.print( "Playground Name: " + name + "\nPlayground capacity: " + capacity
                +"\nPlayground location: " + location + "\nPlayground hour cost: " + hour_cost
                +"\nPlayground slots: ");

    }
    /**
     *show playground's available time slots
     */
    public void available_slots(){
        
        for(TimeSlot tms : slots){
            if(tms.isTaken()){
                continue;
            }
            else{
                System.out.println(tms.getTime());
            }
        }
    }
    /**
     *take a timeslot as booked
     * @param tms a String with the time to be taken
     * @return true if the operation succeeded, false otherwise
     */
    public boolean take(String tms){

        for(TimeSlot T : slots){
            if(T.getTime().equalsIgnoreCase(tms) && T.isTaken() == false){// the slot exists and is available
                T.take(); // to take the slot as booked
                return true;
            }
        }
        /*
         since we got here so the slot must be not exist
         */
        return false;
    }
    /**
     *to mark the playground as allowed by the admin
     * @param permission the admin is permission
     */
    public void setPermission(boolean permission){

        this.permission = permission;
    }
}
