public class Game
{
    private Parser parser;
    private Room current_room;

    public Game(){
        createRoom();
        parser = new Parser();
    }

    private void createRoom(){
        Room outside, theatre, pub, lab, office;
        outside = new Room("outside the main enterance of the university");
        theatre = new Room("in a lecture theatre");
        pub = new Room("in the campus pub");
        lab = new Room("in the computing lab");
        office = new Room("in the computing admin lab");

        outside.setExit(null, theatre, lab, pub);
        theatre.setExit(null, null, null, outside);
        pub.setExit(null, outside, null, null);
        lab.setExit(outside, office, null, null);
        office.setExit(null, null,null, lab);

        current_room = outside;
    }

    public void play(){
        printWelcome();
        boolean finished = false;
        while(!finished){
            Command command = parser.getCommand();
            finished = processCommand(command);
        } 
        System.out.println("Thank you for playing. Good bye!");
    }

    private void printWelcome(){
        System.out.println();
        System.out.println("Welcome to Adventure!");
        System.out.println("Adventure is a new, incredibly boring adventure game.");
        System.out.println("Type 'help' if you need help.");
        System.out.println();
        System.out.println("You are " + current_room.getDescription());
        System.out.print("Exits: ");
        if(current_room.north_exit != null){
            System.out.print("north ");
        }
        if(current_room.east_exit != null){
            System.out.print("east ");
        }
        if(current_room.south_exit != null){
            System.out.print("south ");        
        }
        if(current_room.west_exit != null){
            System.out.print("west ");
        }
        System.out.println();
    }
    
    private boolean processCommand(Command command){
        boolean want_to_quit = false;
        if(command.isUnknown()){
            System.out.println("I don't know what you mean...");
            return false;
        }
        String command_word = command.getCommandWord();
        if(command_word.equals("help")){
            printHelp();
        }
        else if(command_word.equals("go")){
            goRoom(command);
        }
        else if(command_word.equals("quit")){
            want_to_quit = quit(command);
            return want_to_quit;
        }
        return want_to_quit;
    }
    
    private void printHelp(){
        System.out.println("You are lost. You are alone. You wander");
        System.out.println("around at the university.");
        System.out.println();
        System.out.println("your command words are: ");
        System.out.println("go quit help");
    }
    
    private void goRoom(Command command){
        if(!command.hasSecondWord()){
            System.out.println("Go where?");
            return;
        }
        
        String direction = command.getSecondWord();
        Room next_room = null;
        if(direction.equals("north")){
            next_room = current_room.north_exit;
        }
        if(direction.equals("east")){
            next_room = current_room.east_exit;
        }
        if(direction.equals("south")){
            next_room = current_room.south_exit;
        }
        if(direction.equals("west")){
            next_room = current_room.west_exit;
        }
        
        if(next_room == null){
            System.out.println("There are no door!");
        }
        else {
            current_room = next_room;
            System.out.println("You are " + current_room.getDescription());
            System.out.print("Exits: ");
            if(current_room.north_exit != null){
                System.out.print("north ");
            }
            if(current_room.east_exit != null){
                System.out.print("east ");
            }
            if(current_room.south_exit != null){
                System.out.print("south ");        
            }
            if(current_room.west_exit != null){
                System.out.print("west ");
            }
            System.out.println();
        }
    }

    private boolean quit(Command command){
        if(command.hasSecondWord()){
            System.out.println("Quit what?");
            return false;
        }
        return true;
    }
}