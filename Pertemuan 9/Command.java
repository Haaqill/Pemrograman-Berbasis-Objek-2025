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