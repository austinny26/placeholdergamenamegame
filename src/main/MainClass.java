package main;

public class MainClass {
    public static void main(String[] args) {
        int rand;
        rand = (int)(Math.random()*2);

        if(rand == 1){
            System.out.println("hello WORLD");
        }
        else {
            System.out.println("HELLOOOOOO WORLD");
        }


        new Game();

    }

}
