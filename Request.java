import java.util.ArrayList;
/**
 * Class Request to control requests between two classes
 * @author Abdelaziz Khalid Kamil
 * Date: 6/9/2021
 */
public class Request {
    private String timeSlot;
    private Playground pg;
    static int count =0;
    private int ID;
    private String Email;
    /**
     *constructs a new request with specified time slot and playground and assigning an ID to the request
     * @param timeSlot Time slot to be taken
     * @param pg Playground to request
     */
    public Request(String timeSlot, Playground pg) {

        ID = ++count;
        this.timeSlot = timeSlot;
        this.pg = pg;
    }
    /**
     *constructs a new request with specified time slot, playground and player email and assigning an ID to the request
     * @param timeSlot Time slot to be taken
     * @param pg Playground to request
     * @param email Player Email
     */
    public Request(String timeSlot, Playground pg, String email) {

        Email = email;
        ID = ++count;
        this.timeSlot = timeSlot;
        this.pg = pg;
    }
    /**
     *constructs a new request with the specified playground
     * @param pg Playground to request
     */
    public  Request(Playground pg) {
        this.pg = pg;
    }

    /**
     * @return String contains the time slot of the request
     */
    public String getTimeSlot() {

        return timeSlot;
    }

    /**
     * sets the time slot of a request
     * @param timeSlot Time slot of the request
     */
    public void setTimeSlot(String timeSlot) {
        this.timeSlot = timeSlot;
    }

    /**
     * returns the playground in the request
     * @return Playground
     */
    public Playground getPlayground() {

        return pg;
    }

    /**
     *sets a playground for the request
     * @param pg Playground
     */
    public void setPlayground(Playground pg) {

        this.pg = pg;
    }

    /**
     * prints the request's information
     */
    public void show(){

        System.out.println("ID: " + ID);
        pg.showPlayground();
        System.out.println(timeSlot);
    }

    /**
     * return request ID
     * @return ID
     */
    public int getID(){
        return ID;
    }

    /**
     * the owner accepts the request and returns true if the request if valid, false otherwise
     * @return TRUE IF THE OPERATION SUCCEEDED FALSE OTHERWISE
     */
    public boolean activate(){

        for(int i=0 ;i < List.playerList.size(); i++){
            if(List.playerList.get(i).getEmail().equalsIgnoreCase(Email)){
                // add the booking to the player
                List.playerList.get(i).addToBooks(ID);
                break;
            }
        }
        return pg.take(timeSlot);
    }
}
