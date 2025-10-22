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