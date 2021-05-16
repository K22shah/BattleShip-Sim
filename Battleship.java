	//---------------------------------------------------
    //Assignment 4
	//Written by: Kunal H Shah. Student ID  #40153500
	//Date:04-12-2020
	//For COMP 248 Section P- Fall2020
	//---------------------------------------------------



public class Battleship {
   private char grid[][] = new char[8][8];
   private int row;
   private int col;
   private int player1;
   private int player2;
  

   public Battleship() {
       row = 0;
       col = 0;
       for (int i = 0; i < grid.length; i++) {
           for (int j = 0; j < grid[i].length; j++) {
               grid[i][j] = '_';
           }
       }
   }

   public Battleship(Battleship copyGrid) {
       for (int i = 0; i < grid.length; i++) {
           for (int j = 0; j < grid[i].length; j++) {
               this.grid[i][j] = copyGrid.grid[i][j];
           }
       }
   }

   public int isRow(String coordinate) {    //taking user input of the first character from the string and assigning the coordinates of the rows of te grid accordingly
       switch (coordinate.charAt(0)) {
       case 'A':
       case 'a':
           row = 0;
           break;
       case 'B':
       case 'b':
           row = 1;
           break;
       case 'C':
       case 'c':
           row = 2;
           break;
       case 'D':
       case 'd':
           row = 3;
           break;
       case 'E':
       case 'e':
           row = 4;
           break;
       case 'F':
       case 'f':
           row = 5;
           break;
       case 'G':
       case 'g':
           row = 6;
           break;
       case 'H':
       case 'h':
           row = 7;
           break;

       }

       return (row);
   }

   public int isCol(String coordinate) {      //taking user input of the second character from the string and assigning the coordinates of the column of te grid accordingly
       switch (coordinate.charAt(1)) {
       case '1':
           col = 0;
           break;
       case '2':
           col = 1;
           break;
       case '3':
           col = 2;
           break;
       case '4':
           col = 3;
           break;
       case '5':
           col = 4;
           break;
       case '6':
           col = 5;
           break;
       case '7':
           col = 6;
           break;
       case '8':
           col = 7;
           break;

       }
       return (col);
   }

   public String toString() {                         //to String method to print the grid
       for (int i = 0; i < grid.length; i++) {
           for (int j = 0; j < grid[i].length; j++) {
               System.out.print(grid[i][j] + " ");
           }
           System.out.println();
       }
       return "";
   }

   public void setUShip() {                 //method to place user ships as 's'
       grid[this.col][this.row] = 's';
   }

   public void setCShip() {                //method to place computer ships as 'S'
       grid[this.col][this.row] = 'S';
   }

   public void setUGrenade() {             //method to place user grenades as 'g'
       grid[this.col][this.row] = 'g';
   }

   public void setCGrenade() {           //method to place computer grenades as 'G'
       grid[this.col][this.row] = 'G';
   }

   public boolean isOut(String coordinate) {          //method to check if the coordinates are out of bounds
       coordinate.toLowerCase();
       char first = coordinate.charAt(0);
       char second = coordinate.charAt(1);
       return ((first >= 'a' && first <= 'h'||first>='A' && first<='H') && second >= '1' && second < '9');

   }

   public boolean checkTile() {                                           //to check of empty space on the grid
       return (grid[this.col][this.row] == 'G' || grid[this.col][this.row] == 'S' || grid[this.col][this.row] == 'g'
               || grid[this.col][this.row] == 's');
   }

   public boolean countInput(String coordinate) {
       return (coordinate.length() > 2);
   }

   public int randomRow() {
       this.row = (int) (Math.random() * ((8 - 1) + 1) - 1);
       return row;
   }

   public int randomCol() {
       this.col = (int) (Math.random() * ((8 - 1) + 1) - 1);
       return col;
   }

   public void randomMove(Battleship gridCopy) {
     
       randomRow();
       randomCol();
       boolean valid = alreadyEnt();
       if (valid == true) {
           randomMove(gridCopy); // checking to see if the coordinate is already entered and if it is, then randomize again
                                  
           return;
       }
       if (gridCopy.grid[this.col][this.row] == 'S' || gridCopy.grid[this.col][this.row] == 'G') {
           randomRow();
           randomCol();
       }
       switch (this.row) {
       case 0: {
           System.out.print("position of my rocket: A");
           break;
       }
       case 1: {
           System.out.print("position of my rocket: B");
           break;
       }
       case 2: {
           System.out.print("position of my rocket: C");
           break;
       }

       case 3: {
           System.out.print("position of my rocket: D");
           break;
       }
       case 4: {
           System.out.print("position of my rocket: E");
           break;
       }
       case 5: {
           System.out.print("position of my rocket: F");
           break;
       }
       case 6: {
           System.out.print("position of my rocket: G");
           break;
       }
       case 7: {
           System.out.print("position of my rocket: H");
           break;
       }
       }

       switch (this.col) {
       case 0: {
           System.out.println("1");
           break;
       }
       case 1: {
           System.out.println("2");
           break;
       }
       case 2: {
           System.out.println("3");
           break;
       }

       case 3: {
           System.out.println("4");
           break;
       }
       case 4: {
           System.out.println("5");
           break;
       }
       case 5: {
           System.out.println("6");
           break;
       }
       case 6: {
           System.out.println("7");
           break;
       }
       case 7: {
           System.out.println("8");
           break;
       }
       }

   }

   public void board() {                                  //method to print the board
       for (int i = 0; i < grid.length; i++) {
           for (int j = 0; j < grid[i].length; j++) {
               System.out.print(grid[i][j] + " ");
           }
           System.out.println();
       }
   }

   public void board(Battleship realGrid) {
       for (int i = 0; i < grid.length; i++) {
           for (int j = 0; j < realGrid.grid[i].length; j++) {
               System.out.print(realGrid.grid[i][j] + " ");
           }
           System.out.println();
       }
   }

   public boolean alreadyEnt() {                                                         //method to check if the coordinate is empty
       return (grid[this.col][this.row] == '*' || grid[this.col][this.row] == 'G' || grid[this.col][this.row] == 'S'
               || grid[this.col][this.row] == 's' || grid[this.col][this.row] == 'g');
   }

   public void launchRocket(Battleship realGrid) {                                //method to launch the rocket
       if (realGrid.grid[this.col][this.row] == '_') {
           System.out.println("nothing.");
           System.out.println(" ");
           grid[this.col][this.row] = '*';                                       //if no grenade or ship at the coordinate entered print *
           board();
       } else if (realGrid.grid[this.col][this.row] == 's' || realGrid.grid[this.col][this.row] == 'S') {
           System.out.println("ship hit.");                                              //else :SHIP HIT
           System.out.println(" ");
           this.grid[this.col][this.row] = realGrid.grid[this.col][this.row];
           if (realGrid.grid[this.col][this.row] == 'S') {
               this.player1++;                    
               if (this.player1 == 6) {                             //if user hits 6 Computer ships- WINS
                   System.out.println("You win!");
                  System.out.println(" ");
                   board(realGrid);                           //printing the original grid with coordinates of all the ships and grenades
                   System.out.println("Thank You for playing!");
                   System.exit(0);   //GAME OVER - exiting
               }

           } else if (realGrid.grid[this.col][this.row] == 's') {
               this.player2++;
               if (this.player2 == 6) {
                   System.out.println("You lose!");            //if computer hits 6 User ships-WINS
                  System.out.println(" ");
                   board(realGrid);                           //printing the original grid with coordinates of all the ships and grenades
                  System.out.println("Thank You for playing!");
                   System.exit(0);  //GAME OVER - exiting
               }
           }
           board();
       }

       else if (realGrid.grid[this.col][this.row] == 'g' || realGrid.grid[this.col][this.row] == 'G') {  //else: GRENADE HIT
           System.out.println("boom! grenade.");
           System.out.println(" ");
           this.grid[this.col][this.row] = realGrid.grid[this.col][this.row];
           board();
       }
   }

   public void restartGrid() {                           
       for (int i = 0; i < grid.length; i++) {
           for (int j = 0; j < grid[i].length; j++) {
               grid[i][j] = '_';
           }
       }
   }

   public boolean hitGrenade(Battleship gridCopy) {                                              //method to check if grenade is hit
       return (gridCopy.grid[this.col][this.row] == 'G' || gridCopy.grid[this.col][this.row] == 'g');

   }

   public boolean equals(Battleship gridCopy) {  //playing the game on a grid copy so that I can print the original grid at the end showing the positions of everything
       return (this.grid == gridCopy.grid);
   }
}