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