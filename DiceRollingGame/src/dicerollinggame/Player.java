/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dicerollinggame;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;
import java.util.Scanner;

/**
 *
 * @author User
 */
public class Player {
    
    protected String name = ""; 
        public String getName() {return name;}
        public void setName(String name) {this.name = name;}
    
       private int score = 0; 
        public int getScore() {return score;}
        public void setScore(int playerScore) {this.score = playerScore;}
        
      protected ArrayList<String> scoreCard = new ArrayList<>();
    public ArrayList<String> getScoreCard() {
        return scoreCard;
    }
    
        public void setScoreCard(ArrayList<String> scoreCard) {
        this.scoreCard = scoreCard;
    }
        
    public Player(){}
    
    public Player(String name, int score){
        setName(name);
        this.score = score;
        scoreCard.add("1. Total 1's");
        scoreCard.add("2. Total 2's");
        scoreCard.add("3. Total 3's");
        scoreCard.add("4. Total 4's");
        scoreCard.add("5. Total 5's");
        scoreCard.add("6. Total 6's");
        scoreCard.add("7. Three of a kind");
        scoreCard.add("8. Four of a kind");
        scoreCard.add("9. Full house");
        scoreCard.add("10. Small straight");
        scoreCard.add("11. Large straight");
        scoreCard.add("12. Dice Rolling Game!");
        scoreCard.add("13. Chance");
    }

    
    
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
    }
    
    public static void changeTurn(Queue<Player> queue, Player player){
        queue.remove(player);
        queue.add(player);
    }
    
    public void addScore(ArrayList<Dice> dice, int option) {
        
        Map<Integer, Integer> map = new HashMap<>();
        
        switch(option){
            case 1:
                if(scoreCard.contains("1. Total 1's")){
                    for(Dice i : dice){
                        if(i.getNumShowing() == 1){
                            score += 1;
                        }
                    }
                    scoreCard.remove("1. Total 1's");
                }else{
                    System.out.println(chooseAnotherOption("Total 1's"));
                }
            break;
            case 2:
                if(scoreCard.contains("2. Total 2's")){
                    for(Dice i : dice){
                        if(i.getNumShowing() == 2){
                            score += 2;
                        }
                    }
                    scoreCard.remove("2. Total 2's");
                }else{
                    System.out.println(chooseAnotherOption("Total 2's"));
                }
            break;
            case 3:
                if(scoreCard.contains("3. Total 3's")){
                    for(Dice i : dice){
                        if(i.getNumShowing() == 3){
                            score += 3;
                        }
                    }
                    scoreCard.remove("3. Total 3's");
                }else{
                    System.out.println(chooseAnotherOption("Total 3's"));
                }
            break;
            case 4:
                if(scoreCard.contains("4. Total 4's")){
                    for(Dice i : dice){
                        if(i.getNumShowing() == 4){
                            score += 4;
                        }
                    }
                    scoreCard.remove("4. Total 4's");
                }else{
                    System.out.println(chooseAnotherOption("Total 4's"));
                }
            break;
            case 5:
                if(scoreCard.contains("5. Total 5's")){
                    for(Dice i : dice){
                        if(i.getNumShowing() == 5){
                            score += 5;
                        }
                    }
                    scoreCard.remove("5. Total 5's");
                }else{
                    System.out.println(chooseAnotherOption("Total 5's"));
                }
            break;
            case 6:
                if(scoreCard.contains("6. Total 6's")){
                    for(Dice i : dice){
                        if(i.getNumShowing() == 6){
                            score += 6;
                        }
                    }
                    scoreCard.remove("6. Total 6's");
                }else{
                    System.out.println(chooseAnotherOption("Total 6's"));
                }
            break;
            case 7:
                if(scoreCard.contains("7. Three of a kind")){
                    for(Dice temp : dice){
                        Integer count = map.get(temp);
                        map.put(temp.getNumShowing(), (count == null) ? 1 : count + 1);
                        if(((count == null) ? 1 : count + 1) == 3){
                            score = temp.getNumShowing() * 3;
                        }
                    }
                    scoreCard.remove("7. Three of a kind");
                }else{
                    System.out.println(chooseAnotherOption("Three of a kind"));
                }
            break;        
            case 8:
                if(scoreCard.contains("8. Four of a kind")){
                    for(Dice temp : dice){
                        Integer count = map.get(temp.getNumShowing());
                        map.put(temp.getNumShowing(), (count == null) ? 1 : count + 1);
                        if(((count == null) ? 1 : count + 1) == 4){
                            score = temp.getNumShowing() * 4;
                        }
                    }
                    scoreCard.remove("8. Four of a kind");
                }else{
                    System.out.println(chooseAnotherOption("Four of a kind"));
                }
            break;
            case 9:
                if(scoreCard.contains("9. Full house")){
                    for(Dice temp : dice){
                        Integer count = map.get(temp);
                        map.put(temp.getNumShowing(), (count == null) ? 1 : count + 1);
                        if(((count == null) ? 1 : count + 1) == 3){
                            for(Dice temp2 : dice){
                                Integer count2 = map.get(temp2);
                                map.put(temp2.getNumShowing(), (count2 == null) ? 1 : count2 + 1);
                                if(((count2 == null) ? 1 : count2 + 1) == 2){
                                    score += 25;       
                                }
                            }
                        }
                    }
                    scoreCard.remove("9. Full house");
                }else{
                    System.out.println(chooseAnotherOption("Full house"));
                }
            break;
            case 10:
                if(scoreCard.contains("10. Small straight")){
                    if((Collections.frequency(dice, 1) == 1 && Collections.frequency(dice, 2) == 1
                        && Collections.frequency(dice, 3) == 1 && Collections.frequency(dice, 4) == 1)
                        || (Collections.frequency(dice, 2) == 1 && Collections.frequency(dice, 3) == 1
                        && Collections.frequency(dice, 4) == 1 && Collections.frequency(dice, 4) == 1)
                        || (Collections.frequency(dice, 3) == 1 && Collections.frequency(dice, 4) == 1
                        && Collections.frequency(dice, 5) == 1 && Collections.frequency(dice, 6) == 1)){
                            score += 30; 
                    }
                    scoreCard.remove("10. Small straight");
                }else{
                    System.out.println(chooseAnotherOption("Small straight"));
                }
            break;
            case 11:
                if(scoreCard.contains("11. Large straight")){
                    if((Collections.frequency(dice, 1) == 1 && Collections.frequency(dice, 2) == 1
                        && Collections.frequency(dice, 3) == 1 && Collections.frequency(dice, 4) == 1 
                        && Collections.frequency(dice, 5) == 1) || (Collections.frequency(dice, 2) == 1 
                        && Collections.frequency(dice, 3) == 1 && Collections.frequency(dice, 4) == 1 
                        && Collections.frequency(dice, 5) == 1 && Collections.frequency(dice, 6) == 1)){
                            score += 40;
                    }
                    scoreCard.remove("11. Large straight");
                }else{
                    System.out.println(chooseAnotherOption("Large straight"));   
                }
            break;
            case 12:
                if(scoreCard.contains("12. Dice Rolling Game!")){
                    for (Dice temp : dice){
                        Integer count = map.get(temp);
                        map.put(temp.getNumShowing(), (count == null) ? 1 : count + 1);
                        if(((count == null) ? 1 : count + 1) == 5){
                            score += 50;
                        }
                    }
                    scoreCard.remove("12. Dice Rolling Game!");
                }else{
                    System.out.println(chooseAnotherOption("Dice Rolling Game!"));
                }
            break;
            case 13:
                if(scoreCard.contains("13. Chance")){
                    for(Dice i : dice){
                        score += i.getNumShowing();
                    }
                    scoreCard.remove("13. Chance");
                }else{
                    System.out.println(chooseAnotherOption("Chance"));
                }
            break;
        }
        
        System.out.println("Your score is now: " + score);

    }
    
    public static String chooseAnotherOption(String option){
        return "You already chose " + option + ". Pick another option";
    }
        
}
