/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dicerollinggame;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author Jack
 */
public class Dice {
   



    protected int numShowing;
    protected int index = 0;


    public int getNumShowing() {
        return numShowing;
    }

    public void setNumShowing(int numShowing) {
        this.numShowing = numShowing;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }
    
    
    public int Roll(){
        Random random = new Random();
        numShowing = random.nextInt(6) + 1;
        return numShowing;
    }
    
    public static void Roll(ArrayList<Dice> dice){
        for(int a=0; a<dice.size(); a++){
        dice.get(a).Roll();
        }
    }
    
    public Dice(){}
    public Dice(int index){
        this.index = index;
    }
    
    
    public static void PlayerTurn(Player p, ArrayList<Dice> active, ArrayList<Dice> saved){
        Scanner in = new Scanner(System.in);
        Dice.Roll(active);        
        DisplayDice(active);
        
        System.out.println("Which die or dice do you want to save? You have 2 rolls left. "
                + System.getProperty("line.separator") + "Once you entered the dice you want to save, enter \"roll\". "
                + System.getProperty("line.separator") + "If you would like to end you turn with these dice, enter \"done\".");
        String input = in.next();
        input = CheckInput(input,active,saved);
        if(input.equals("done") | input.equals("Done")){
            System.out.println(p.getScoreCard());
            p.addScore(active, in.nextInt());
        }
        if(input.equals("roll") | input.equals("Roll")){
            Dice.Roll(active);
            for(int a=saved.size()-1; a>=0; a--){
                active.add(saved.get(a));
                saved.remove(a);
            }
            DisplayDice(active);
            System.out.println("Which die or dice do you want to save? You have 1 roll left. "
                + System.getProperty("line.separator") + "Once you entered the dice you want to save, enter \"roll\". "
                + System.getProperty("line.separator") + "If you would like to end you turn with these dice, enter \"done\".");
            input = in.next();
            input = CheckInput(input,active, saved);
            if(input.equals("done") | input.equals("Done")){
                System.out.println(p.getScoreCard());
                p.addScore(active, in.nextInt());
            }
            if(input.equals("roll") | input.equals("Roll")){
                Dice.Roll(active);
                for(int a=saved.size()-1; a>=0; a--){
                    active.add(saved.get(a));
                    saved.remove(a);
                }
                DisplayDice(active);
                System.out.println("You have no rolls left.");
                System.out.println(p.getScoreCard());
                p.addScore(active, in.nextInt());
            }

        }
        
    }
    
    //Methods in PlayerTurn
    private static boolean IsInteger(String s) {
        try { 
            Integer.parseInt(s); 
        } catch(NumberFormatException | NullPointerException e) { 
            return false; 
        }
        return true;
    }
    
    private static void SaveDice(String s, ArrayList<Dice> active, ArrayList<Dice> saved){
        int die = Integer.parseInt(s);
        Dice dieIndex = null;
        if(die<1 | die>6){
            System.out.println("That number is not showing on a die.");
        }
        else{
            for(int a=0; a<active.size(); a++){
                if(die == active.get(a).numShowing){
                    dieIndex = active.get(a);
                }
            }
            if(dieIndex == null){
                System.out.println("That number is not showing on a die.");
            }
            else{
                saved.add(dieIndex);
                active.remove(dieIndex);
            }    
        }
    }
    
    private static void DisplayDice(ArrayList<Dice> active){
        for (int a=0; a<active.size();a++){
            System.out.println(active.get(a).getNumShowing());
        }
    }
    
    private static String CheckInput(String input,ArrayList<Dice> active, ArrayList<Dice> saved){
        Scanner in = new Scanner(System.in);
        while(!input.equals("done") & !input.equals("Done") & !input.equals("roll") & !input.equals("Roll")){
           if(IsInteger(input) == true){
            SaveDice(input,active,saved);
            }
            else{
               System.out.println("Invalid input. Try again.");
            }
               input = in.next();
        }
        
        return input;
    }
      
}
    
