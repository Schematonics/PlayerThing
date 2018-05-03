/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dicerollinggame;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
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
    
private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();
    
    
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
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }


    /**
     * Test of nameValidChars method, of class DiceRollingGame.
     */
    @Test
    public void testNameValidChars() {
        Scanner scan = new Scanner(System.in);
        System.out.println("nameValidChars");
        String input = scan.nextLine(); 
        
        Player[] initialArr = new Player[4];
        //Player[] takenArrray = initialArr; 
        Queue<Player> queue = new LinkedList();
        
        Player player1 = new Player("1", 0); 
        Player player2 = new Player("2", 0); 
        Player player3 = new Player("3", 0); 
        Player player4 = new Player("4", 0); 
        
        initialArr[0] = player1; 
        initialArr[1] = player2;
        initialArr[2] = player3;
        initialArr[3] = player4; 
        



         
        
        int count = 4;
   
        DiceRollingGame.nameValidChars(input, initialArr, queue, count);
        input = "hm"; 
        String expected = ("Your players are: " + System.lineSeparator() + "Charles" + System.lineSeparator() + "Charles" + System.lineSeparator() + "Charles" + System.lineSeparator() + "Charles");  
         assertEquals( expected, outContent.toString());
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
