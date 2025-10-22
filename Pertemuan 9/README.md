# Source code

### Command
```java
public class Command
{
    private String command_word;
    private String second_word;

    public Command(String first_word, String second_word){
        command_word = first_word;
        this.second_word = second_word;
    }

    public String getCommandWord(){
        return command_word;
    }

    public String getSecondWord(){
        return second_word;
    }

    public boolean isUnknown(){
        return (command_word == null);
    }

    public boolean hasSecondWord(){
        return (second_word != null);
    }
}
```

### CommandWord
```java
public class CommandWords
{
    private static final String valid_command[] = {"go", "quit", "help", "look"};

    public CommandWords(){

    }

    public boolean isCommand(String a_string){
        for (int i = 0; i < valid_command.length; i++){
            if(valid_command[i].equals(a_string)){
                return true;
            }
        }
        return false;
    }
}
```

### Parser
```java
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Parser
{
    private CommandWords commands;

    public Parser(){
        commands = new CommandWords();
    }

    public Command getCommand(){
        String input_line = "";
        String word1, word2;
        System.out.print("> ");
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try {
            input_line = reader.readLine();
        }
        catch(java.io.IOException exc){
            System.out.println("There was an error during reading: " + exc.getMessage());
        }

        StringTokenizer tokenizer = new StringTokenizer(input_line);
        if(tokenizer.hasMoreTokens()){
            word1 = tokenizer.nextToken();
        }
        else {
            word1 = null;
        }

        if(tokenizer.hasMoreTokens()){
            word2 = tokenizer.nextToken();
        }
        else {
            word2 = null;
        }

        if(commands.isCommand(word1)){
            return new Command(word1,word2);
        }
        else {
            return new Command(null, word2);
        }
    }
}
```

### Room
```java
public class Room
{
    public String description;
    public Room north_exit;
    public Room south_exit;
    public Room west_exit;
    public Room east_exit;

    public Room(String description){
        this.description = description;
    }

    public void setExit(Room north, Room east, Room south, Room west){
        if(north != null){
            north_exit = north;
        }
        if(east != null){
            east_exit = east;
        }
        if(south != null){
            south_exit = south;
        }
        if(west != null){
            west_exit = west;
        }
    }

    public String getDescription(){
        return description;
    }
}
```

### Game
```Java
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
```
