package Projects.Project2;


//  What I added in this project:
//  1. GUI for user input
//  2. JavaFX for KeyListener
//  3. New cases in InvalidMapException (Invalid map element, Player does not exist)
//  4. You can move in 4 directions
//  5. New map elements:
//      1. Points - If you move there, your score increases
//      2. Traps - If you move there, you lose immediately
//  6. Random generation of points and traps
//  7. User defined data structure MyMap using generics
//  8. The map will change after each move
//  9. At the end you will see your score and final map


public class Run {
    public static void main(String[] args) throws InterruptedException {
        MyFrame myFrame = new MyFrame();
        myFrame.run();
    }
}


