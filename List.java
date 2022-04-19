import java.util.ArrayList;
import java.util.Scanner;

/**
 * Class List works like a data base for the program
 * It stores all information of players, owners, playgrounds and requests and return them if needed
 * @author Mohammed Hany Fattoh
 * Date: 6/8/2021
 */

public class List {
    /**
     * Player list is an array list which stores all players information
     */
    static public ArrayList<Player> playerList = new ArrayList<Player>(5);

    /**
     * Owner list is an array list which stores all owners information
     */
    static public ArrayList<Owner> ownerList = new ArrayList<Owner>(5);

    /**
     * Playground list is an array list which stores all playgrounds information
     */
    static public ArrayList<Playground> playgroundList = new ArrayList<Playground>(5);

    /**
     * Admin list is an array list which stores all admins information
     */
    static public ArrayList<Admin> adminList = new ArrayList<Admin>(5);

    /**
     * Player Requests list is an array list which stores all players Requests for booking information
     */
    static public ArrayList<Playground> playerRequests = new ArrayList<Playground>(5);

    /**
     * Owner Requests list is an array list which stores all owners Requests for booking information
     */
    static public ArrayList<Playground> ownerRequests = new ArrayList<Playground>(10);

    /**
     * Allowed list is an array list which stores all allowed playgrounds by admin information
     */
    static public ArrayList<Playground> allowed = new ArrayList<Playground>(10);

    /**
     * Booked Requests list is an array list which stores all booked playground information
     */
    static public ArrayList<Playground> booked = new ArrayList<Playground>(5);

    /**
     * Count for owner adding new playground requests
     */
    static public int requestCount = 0;

    /**
     * Count for player booking requests
     */
    static public int playerRequestsCount = 0;

    /**
     * Creates new admin and add them into adminList
     */
    public void createAdmin(){
        Admin admin = new Admin();
        adminList.add(admin);
    }

    /**
     * Call createAdmin method to create new admin when list object is created
     */
    List(){
        createAdmin();
    }

    /**
     * gets playerList arraylist
     * @return playerList
     */
    ArrayList<Player> getPlayerList(){
        return playerList;
    }

    /**
     * gets ownerList arraylist
     * @return ownerList
     */
    ArrayList<Owner> getOwnerList(){
        return ownerList;
    }

    /**
     * gets playgroundList arraylist
     * @return playgroundList
     */
    ArrayList<Playground> getPlaygroundList(){
        return playgroundList;
    }

    /**
     * gets adminList arraylist
     * @return adminList
     */
    ArrayList<Admin> getAdminList(){
        return adminList;
    }

    /**
     * Sign in to any account in playerList, ownerList or adminList
     * @param email account email
     * @param password account password
     */
    public void signIn(String email, String password){
        if(findByEmail(email)){
            for(int i = 0; i < playerList.size(); i++){
                if(playerList.get(i).getEmail().equals(email) && playerList.get(i).getPassword().equals(password)){
                    playerList.get(i).homeScreen();
                }
            }
            for(int i = 0; i < ownerList.size(); i++){
                if(ownerList.get(i).getEmail().equals(email) && ownerList.get(i).getPassword().equals(password)){
                    ownerList.get(i).homeScreen();
                }
            }
            for(int i = 0; i < adminList.size(); i++){
                if(adminList.get(i).getEmail().equals(email) && adminList.get(i).getPassword().equals(password)){
                    adminList.get(i).homeScreen();
                }
            }
            System.out.println("Password is invalid!");
            WelcomeScreen welcomeScreen = new WelcomeScreen();
        }
        else{
            System.out.println("Email is invalid!");
            WelcomeScreen welcomeScreen = new WelcomeScreen();
        }

    }

    /**
     * Add new user to playerList or ownerList by calling addPlayer and addOwner methods
     * @param type user type (player or owner)
     * @param newUser new user information
     */
    public void addUser(int type, User newUser){
        if(type == 1){
            addPlayer(newUser);
        }
        else if(type == 2){
            addOwner(newUser);
        }
        else {
            System.out.println("Error: Wrong value");
            System.exit(0);
        }
    }

    /**
     * Add new player to playerList
     * @param newUser new player information
     */
    public void addPlayer(User newUser){
        Player newPlayer = new Player(newUser);
        playerList.add(newPlayer);
        System.out.println("GoFo.User created successfully");
        newPlayer.homeScreen();
    }

    /**
     * Add new owner to ownerList
     * @param newUser new owner information
     */
    public void addOwner(User newUser){
        Owner newOwner = new Owner(newUser);
        ownerList.add(newOwner);
        System.out.println("GoFo.User created successfully");
        newOwner.homeScreen();
    }

    /**
     * Search for specific email to check if it is stored before
     * @param email email to search for
     * @return result of check
     */
    public boolean findByEmail(String email){
        for(int i = 0; i < playerList.size(); i++){
            if(playerList.get(i).getEmail().equals(email)){
                return true;
            }
        }
        for(int i = 0; i < ownerList.size(); i++){
            if(ownerList.get(i).getEmail().equals(email)){
                return true;
            }
        }
        for(int i = 0; i < adminList.size(); i++){
            if(adminList.get(i).getEmail().equals(email)){
                return true;
            }
        }
        return false;
    }

    /**
     * Add request to book a playground by player to owner
     * @param pg booked playground information
     */
    public void addPlayerRequest(Playground pg){
        playerRequestsCount++;
        playerRequests.add(pg);
    }

    /**
     * Show players booking requests to owner
     */
    public void  showPlayerRequests(){
        int i = 0;
        for (i = 0; i < playerRequestsCount; i++){
            playerRequests.get(i).showPlayground();
            playerRequests.get(i).available_slots();
            System.out.println("Do you want to accept this Playground booking request\n1- Yes\n2- No");
            Scanner input = new Scanner(System.in);
            int choice = input.nextInt();
            switch (choice){
                case 1:
                    booked.add(playerRequests.get(i));
                    playerRequests.remove(i);
                    playerRequestsCount--;
                    break;
                case 2:
                    playerRequests.remove(i);
                    playerRequestsCount--;
                    break;
                default:
                    System.out.println("Error: Wrong choice");
                    break;
            }
        }
    }

    /**
     * Add request to add new playground by owner to admin
     * @param pg new playground information
     */
    public void addOwnerRequest(Playground pg){
        requestCount++;
        ownerRequests.add(pg);
    }

    /**
     * Show owners adding playgrounds requests to admin
     */
    public void showOwnerRequests(){
        int i = 0;
        for (i = 0; i < requestCount; i++){
            ownerRequests.get(i).showPlayground();
            ownerRequests.get(i).available_slots();
            System.out.println("Do you want to give permission to this Playground\n1- Yes\n2- No");
            Scanner input = new Scanner(System.in);
            int choice = input.nextInt();
            switch (choice){
                case 1:
                    ownerRequests.get(i).setPermission(true);
                    allowed.add(ownerRequests.get(i));
                    playgroundList.add(ownerRequests.get(i));
                    ownerRequests.remove(i);
                    requestCount--;

                    break;
                case 2:
                    ownerRequests.get(i).setPermission(false);
                    ownerRequests.remove(i);
                    requestCount--;
                    break;
                default:
                    System.out.println("Error: Wrong choice");
                    ownerRequests.get(i).setPermission(false);
                    break;
            }
        }
    }
}
