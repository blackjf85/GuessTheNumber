package com.company;

import java.util.Random;
import java.util.Scanner;

public class Main {

    public static Integer gen_number(){
        int min = 1;
        int max = 20;

        Random random = new Random();

        return random.nextInt(max + min) + min;
    }

    public static Integer user_guess(){
        Scanner guessObj = new Scanner(System.in);
        System.out.println("Take a guess.");

        try{
            int num = guessObj.nextInt();
            if(num >= 1 && num <= 20){
                return num;
            }else {
                return -1;
            }
        }catch (Exception e) {
            return -1;
        }
    }

    public static String get_name(){
        try{
            Scanner nameObj = new Scanner(System.in);
            System.out.println("Hello! What is your name?");
            return nameObj.nextLine();
        }catch (Exception e){
            return "-1";
        }
    }

    public static Boolean play_again(){
        Scanner playObj = new Scanner(System.in);
        System.out.println("Would you like to play again? (y or n)");

        try{
            return playObj.nextLine().equals("y");
        }catch(Exception e) {
            return null;
        }
    }

    public static void game(){

        String myGuess = String.valueOf(gen_number());
        int guessCounter = 1;

        while (guessCounter <= 6){
            String userGuess = String.valueOf(user_guess());
            if(userGuess.equals("-1")){
                System.out.println("Guess must be a number between 1 and 20.");
            }else if (!userGuess.equals(myGuess)){
                System.out.println("Not it!");
                guessCounter += 1;
            }else{
                System.out.println("You win!");
                break;
            }
        }
    }

    public static void main(String[] args) {
        boolean play = true;
        String name = get_name();
        if (name.equals("-1")){
            System.out.println("Something went wrong.");
            name = get_name();
        }else{
            System.out.println("Well, " + name + ", I am thinking of a number between 1 and 20.");
            game();
        }

        while(play) {
            boolean again = play_again();
            if(again){
                System.out.println("Well, " + name + ", I am thinking of a number between 1 and 20.");
                game();
            }else{
                play = false;
            }
        }
    }

}
