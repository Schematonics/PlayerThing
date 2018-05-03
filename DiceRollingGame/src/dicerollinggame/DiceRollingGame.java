package dicerollinggame;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 *
 * @author Jack, Mads
 */
public class DiceRollingGame {

    /**
     * Plays a dice game similar to Yahtzee 
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String input = "";  
        rollDice();
        
        Player[] initialArr = new Player[4]; 
            
        Player player1 = new Player("1", 0); 
        Player player2 = new Player("2", 0); 
        Player player3 = new Player("3", 0); 
        Player player4 = new Player("4", 0); 
        
        initialArr[0] = player1; 
        initialArr[1] = player2;
        initialArr[2] = player3;
        initialArr[3] = player4; 
         
        System.out.println("How many players are there? Player limit: " +initialArr.length); 
        String input2 = scan.nextLine();
       int count = Integer.parseInt(input2);
        
        
        Queue<Player> playerQueue = new LinkedList(); 
        nameValidChars(input, initialArr, playerQueue, count); 
       
        

        
        
        
        
        
    }

    /**
     * Names the players that will be participating in the game.
     * @param input the name given by the users
     * @param array the array the player belongs to
     * @param queue the player queue used for turns
     * @param count the amount of players playing
     */
    public static void nameValidChars(String input, Player[] array, Queue<Player> queue, int count){
        Scanner scan = new Scanner(System.in);     
                
        int initial = 0;   
         while(initial < count ){
            System.out.println("Enter player " + (initial+1) +  "'s name.");
            input = scan.nextLine(); 
            array[initial].setName(input);    
            queue.add(array[initial]); 
            initial ++;         
        }   
         System.out.println("Your players are: " );
         initial = 0; 
         while(initial < count ){
             System.out.println(array[initial].getName()); 
             initial++;
         }
    }  

    /**
     * Changes the turn by removing and re-adding the character to the queue
     * @param queue the player queue
     * @param player the player who just completed their turn
     */
    public static void changeTurn(Queue<Player> queue, Player player){
        queue.remove(player);
        queue.add(player);
    }
    
/*  public int checkInput(String input2){
        Scanner scan = new Scanner(System.in);
         
        int count = 0; 
        if(input2.equalsIgnoreCase("four")){
           count = 4; 
        }
        else if(input2.equalsIgnoreCase("three")){
          count = 3; 
        }
        else if(input2.equalsIgnoreCase("two")){
            count = 2; 
        }
        else if(input2.equalsIgnoreCase("one")){
            count = 1; 
        }
        else if( (input2.equals("1")) || (input2.equals("1")) || (input2.equals("1")) || (input2.equals("1")) ){
        count = Integer.parseInt(input2); 
        }
        else {
            System.out.println("That's not valid input. Try again.");
            input2 = scan.nextLine(); 
        }
        return count; 
    } */
    
    public static void rollDice(){
        Dice dice1 = new Dice();
        Dice dice2 = new Dice();
        Dice dice3 = new Dice();
        Dice dice4 = new Dice();
        Dice dice5 = new Dice();
        
        System.out.println(dice1.Roll());
        System.out.println(dice2.Roll());
        System.out.println(dice3.Roll());
        System.out.println(dice4.Roll());
        System.out.println(dice5.Roll());
    }
    
}
