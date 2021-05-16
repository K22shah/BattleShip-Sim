import java.util.Scanner;

//---------------------------------------------------
//Assignment 4
//Written by: Kunal H Shah. Student ID  #40153500
//Date:04-12-2020
//For COMP 248 Section P- Fall2020
//---------------------------------------------------

public class BattleshipDriver {

   public static void main(String[] args) {
       Battleship grid = new Battleship();
       Scanner sc = new Scanner(System.in);

       System.out.println("Hi, let's play Battleship!");
       System.out.println();
       int number = 1;
       int i = 0;
       int j = 0;
       while (i < 6) { // user enters their ship coordinates
           System.out.print("Enter the coordinates of your ship #" + number + ": ");
           String coordinate = sc.next();
           coordinate.toLowerCase(); // turning everything to lower case 
                                       
           boolean isLong = grid.countInput(coordinate); // this is so that if the user types a big coordinate, it'll automatically be out of bounds
                                                          
           if (isLong == true) {
               System.out.println("sorry, coordinates out of the grid. try again.");
               continue;
           }
           boolean valid = grid.isOut(coordinate); // checking if the number they enter is greater than 8
           if (valid == false) {
               System.out.println("sorry, coordinates out of the grid. try again.");
               continue;
           }
           else {
               grid.isRow(coordinate);
               grid.isCol(coordinate);
               boolean tileCheck = grid.checkTile();
              
               if (tileCheck == true) { // if the user already entered these coordinates
                   System.out.println("sorry, coordinates already being used. try again.");
                   continue;
               } else {
                   grid.setUShip();
                   i++; // increment only if they put a valid coordinate
                   number++;
               }
           }
       }
       System.out.println();
       number = 1;
       while (j < 4) { // user now enters grenade coordinates
           System.out.print("Enter the coordinates of your grenade #" + number + ": ");
           String coordinate2 = sc.next();
           coordinate2.toLowerCase();
           
           boolean isLong = grid.countInput(coordinate2); // if they enter a huge coordinate, make them retype it
           if (isLong == true) {
               System.out.println("sorry, coordinates out of the grid. try again.");
               continue;
           }
           boolean valid = grid.isOut(coordinate2); // if the coordinate is out of bounds
        
           if (valid == false)
               System.out.println("sorry, coordinates out of the grid. try again.");
           else {
               grid.isRow(coordinate2);                          // if all of these conditions are not  met, then use the users input and put it  in the grid
             
               grid.isCol(coordinate2);
               boolean tileCheck = grid.checkTile();
               
               if (tileCheck == true) {
                   System.out.println("sorry, coordinates already being used. try again.");
                   continue;
               } else {
                   grid.setUGrenade();    //placing user grenades
                   j++; // increment only if they put a valid coordinate
                   number++;
               }
           }
       }
       System.out.println();
       
       //  setting the coordinates for the computer also checking if the coordinates are already taken
       int n = 0;
       int m = 0;
       while (n < 6) {
           grid.randomRow();
           grid.randomCol();
           boolean check = grid.checkTile();
           if (check == true) {
               continue;
           } else {
               grid.setCShip();
               n++;
           }
       }

       while (m < 4) { // same as above, but this is for grenades
           grid.randomRow();
           grid.randomCol();
           boolean check = grid.checkTile();
           if (check == true) {
               continue;
           } else {
               grid.setCGrenade();      //placing computer grenades
               m++;
           }
       }
       Battleship gridCopy = new Battleship(grid); //   making direct copy of the object so that
                                                                   // when a winner is declared, i can print out the
                                                                   // grid easily and since i have to print a
                                                                   // completely new grid at the start, i use this copy
                                                                   // to determine if the user entered a coordinate
                                                                   // where it hits a ship or grenade
      
       grid.restartGrid();                                         // completely deleting the initial grid since i already made a copy. im using
                                                                   // the initial object to print out a new fresh grid.
       System.out.println();
       System.out.println("OK, the computer placed its ships and grenades at random. Let's play.");
       System.out.println();
       int turns = 0;

       while (turns < 1000) { // now its time to play the game
           System.out.print("position of your rocket: "); // user enters a coordinate
           String pcoordinate = sc.next();
           boolean isLong = grid.countInput(pcoordinate); // see if they enter a coordinate way out of bounds
           if (isLong == true) {
               System.out.println("sorry, coordinates out of the grid. try again.");
               continue;
           }
           boolean valid = grid.isOut(pcoordinate); // see if the user enters a coordinate out of bounds
           if (valid == false) {
               System.out.println("sorry, coordinates out of the grid. try again.");
               continue;
           } else { // otherwise, set the coordinates they entered
               grid.isRow(pcoordinate);
               grid.isCol(pcoordinate);
               boolean tileCheck = grid.alreadyEnt(); // checking if the user already entered these coordinates
              
               if (tileCheck == true) {
                   System.out.println("position already called.");
                   grid.board();
                   continue;
               } else { // otherwise, launch a rocket
                   grid.launchRocket(gridCopy);
                   boolean hitGrenade = grid.hitGrenade(gridCopy);
                   if(hitGrenade == true) {
                       grid.randomMove(gridCopy);
                       grid.launchRocket(gridCopy);
                   }

               }
               grid.randomMove(gridCopy); // now its the computer's turn
               grid.launchRocket(gridCopy);
               boolean hitG = grid.hitGrenade(gridCopy);
               if (hitG == true) { // if the computer hits a grenade, his turn must be skipped, so ask the user for  coordinate twice. under here will be the first time
                                   
                   while (turns < 1000) {
                       System.out.print("position of your rocket: ");
                       String p2coordinate = sc.next();
                       boolean isLonge = grid.countInput(p2coordinate);
                       if (isLonge == true) {
                           System.out.println("This coordinate is out of bounds. Please enter another coordinate.");
                           continue;
                       }
                       boolean out = grid.isOut(p2coordinate);
                       if (out == false) {
                           System.out.println("This coordinate is out of bounds. Please enter a valid coordinate.");
                           continue;
                       } else {
                           grid.isRow(p2coordinate);
                           grid.isCol(p2coordinate);
                           boolean tileCheck2 = grid.alreadyEnt();
                           if (tileCheck2 == true) {
                               System.out.println("position already called");
                               grid.board();
                               continue;
                           } else {
                               grid.launchRocket(gridCopy);
                               boolean hitGrenadeE = grid.hitGrenade(gridCopy);
                               if(hitGrenadeE == true) {
                                   grid.randomMove(gridCopy);
                                   grid.launchRocket(gridCopy);
                               }
                           }

                       }
                       break;
                   }
               }

           }
           turns++; // increment the number of turns
       }
       sc.close();  //scanner closed
   }
   
}