package Projects.Project2;

import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class MyFrame extends JFrame implements KeyListener {
    private Player player;
    private static final int WIDTH = 100;
    private static final int HEIGHT = 100;
    private boolean run = true;
    private static final String ANSI_GREEN = "\u001B[32m";


    MyFrame(){
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(WIDTH, HEIGHT);
        this.addKeyListener(this);
        this.setVisible(true);
    }

    public static String mapInput(){
        String input = JOptionPane.showInputDialog("Enter file or map size: ");
        if(input.equals("file")){
            input = "";
            try {
                File file = new File("C:\\Users\\Imangaly\\IdeaProjects\\OOP\\src\\Projects\\Project2\\map.txt");
                Scanner scanner = new Scanner(file);
                while (scanner.hasNextLine()) {
                    input += '\n' + scanner.nextLine();
                }
                scanner.close();
            } catch (FileNotFoundException e) {
                System.out.println("Something wrong with the file.");
                e.printStackTrace();
            }
        }
        else {
            int size = Integer.parseInt(input);

            for (int i = 0; i < size; i++) {
                input += '\n' + JOptionPane.showInputDialog(String.format("Enter %s row: ", i));
            }
        }

        return input;
    }

    public void run() throws InterruptedException {
        Scanner input = new Scanner(mapInput());

        player = new MyPlayer();
        Game game = null;
        Map map = null;

        try{
            map = new Map(input);
            game = new Game(map);
        }
        catch(InvalidMapException e){
            System.out.println(e.getMessage());
            System.exit(0);
        }
        game.addPlayer(player);

        while(run){
            System.out.println(ANSI_GREEN + "Score: " + player.getScore());
            System.out.println("");
            player.updateMap();
            map.print();
            TimeUnit.MILLISECONDS.sleep(200);
//            Thread.sleep(250);
            cls();
        }

        System.out.println("Your score: " + player.getScore());
        System.out.println("Final map:");
        map.print();

        System.exit(0);
    }

    public static void cls() {
        try {
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        }
        catch(Exception E) {
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {
        if(e.getKeyChar() == 'w'){
            player.up();
        }
        if(e.getKeyChar() == 's'){
            player.down();
        }
        if(e.getKeyChar() == 'a'){
            player.left();
        }
        if(e.getKeyChar() == 'd'){
            player.right();
        }
        if(e.getKeyChar() == 'x'){
            run = false;
        }
    }

    @Override
    public void keyPressed(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}

