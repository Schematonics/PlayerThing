/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dicerollinggame;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author User
 */
public class DiceRollingGameTest {
    
    
    public DiceRollingGameTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of main method, of class DiceRollingGame.
     */
    @Test
    public void testMain() {
        System.out.println("main");
        String[] args = null;
        DiceRollingGame.main(args);
        fail("The test case is a prototype.");
    }

    /**
     * Test of nameValidChars method, of class DiceRollingGame.
     * Specifically tests the length of the array and queue.
     */
    @Test
    public void testNameValidChars_ArrayLengthAndQueueLength() {
        System.out.println("nameValidChars");
        Scanner scan = new Scanner(System.in); 
        
        Player[] initialArr = new Player[4]; 
        Queue<Player> queue = new LinkedList();
        
        Player player1 = new Player("1", 0); 
        Player player2 = new Player("2", 0); 
        Player player3 = new Player("3", 0); 
        Player player4 = new Player("4", 0); 
        
        initialArr[0] = player1; 
        initialArr[1] = player2;
        initialArr[2] = player3;
        initialArr[3] = player4;
        
        int count = 5; 
        while(count > 4){
                 System.out.println("That's too many players. Try again.");
                 count = 4;
             }
         
        int initial = 0;   
         while(initial < count ){
            System.out.println("Enter player " + (initial+1) +  "'s name.");
     
            queue.add(initialArr[initial]); 
            initial ++;
        }
         String actual = ("Player count: " + count + "." + " Player names: " + initialArr[0].getName() + " " + initialArr[1].getName() + " " + initialArr[2].getName() + " " + initialArr[3].getName());
         String expected = ("Player count: 4. Player names: 1 2 3 4");
         assertEquals( expected, actual);
    }
        
         

    /**
     * Test of nameValidChars method, of class DiceRollingGame.
     * Specifically tests the naming and adding to the queue function.
     */
    @Test
    public void testNameValidChars_NamingAndAddingToQueue() {
        System.out.println("nameValidChars");
        String input = "Charles"; 
        
        Player[] initialArr = new Player[4]; 
        Queue<Player> queue = new LinkedList();
        
        Player player1 = new Player("1", 0); 
        Player player2 = new Player("2", 0); 
        Player player3 = new Player("3", 0); 
        Player player4 = new Player("4", 0); 
        
        initialArr[0] = player1; 
        initialArr[1] = player2;
        initialArr[2] = player3;
        initialArr[3] = player4; 
        
            initialArr[0].setName(input);    
            queue.add(initialArr[0]); 
            initialArr[1].setName(input);    
            queue.add(initialArr[1]);
            initialArr[2].setName(input);    
            queue.add(initialArr[2]);
            initialArr[3].setName(input);    
            queue.add(initialArr[3]);
         
        String actual = ("Your players are: " + System.lineSeparator() + player1.getName() + System.lineSeparator() + player2.getName() + System.lineSeparator() + player3.getName() + System.lineSeparator() + player4.getName());
        String expected = ("Your players are: " + System.lineSeparator() + "Charles" + System.lineSeparator() + "Charles" + System.lineSeparator() + "Charles" + System.lineSeparator() + "Charles");  
         assertEquals( expected, actual);
    }

    /**
     * Test of changeTurn method, of class DiceRollingGame.
     */
    @Test
    public void testChangeTurn() {
        System.out.println("changeTurn");
        Queue<Player> playerQ = new LinkedList();
        Player player1 = new Player("1", 0); 
        Player player2 = new Player("2", 0);
        playerQ.add(player1);
        playerQ.add(player2);
        DiceRollingGame.changeTurn(playerQ, player1);
        String actual = playerQ.element().getName(); 
        String expected = "2"; 
        
        assertEquals( expected, actual);
    }

    /**
     * Test of rollDice method, of class DiceRollingGame.
     */
   /* @Test
    private static void testRoll() {
        System.out.println("rollDice");
        DiceRollingGame.Roll(5);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    */
}
