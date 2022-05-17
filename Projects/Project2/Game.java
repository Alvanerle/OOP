package Projects.Project2;

public class Game{
    private Map map;

    public Game(Map map){
        this.map = map;
    }

    public void setMap(Map map){
        this.map = map;
    }

    public void addPlayer(Player player){
        player.setMap(map);
    }
}