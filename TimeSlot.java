 /**
 *Timeslot class to hold the time slot of the playground and has attribute taken to know if the slot is booked or not
 *using 24 hours format 00:00
 *@author Abdelaziz Khalid Kamil
 *Date: 6/9/2021
 */
public class TimeSlot {
    private String time;
    private boolean taken = false;
    public  TimeSlot(String time){
        this.time = time;
    }
    public void setTime(String Time){
        this.time = Time;
    }
    public String getTime(){
        return time;
    }

    /**
     * to mark the time slot as taken by a player
     */
    public void take(){
        taken = true;
    }

    /**
     * return false if the time slot is free, true otherwise
     * @return boolean
     */
    public boolean isTaken() {
        return taken;
    }
}

