package Projects.Project2;

public interface Player{
    void moveRight();
    void moveLeft();
    void moveUp();
    void moveDown();
    void right();
    void left();
    void up();
    void down();
    void setMap(Map map);
    int getScore();
    void updateMap();
    void moveTraps();
    Position getPosition();
}
