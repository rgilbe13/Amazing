/**
 * + The original program is by Jack Hauber, and the source is
 * "Basic Computer Games." Used with permission of David Ahl;
 * see www.SwapMeetDave.com.
 * + This exercise was inspired by Alan Hensel's use of Amazing
 * as a refactoring challenge.
 * + This transliteration to Java was created by Bill Wake, William.Wake@acm.org
 */
import java.util.Random;

public class Amazing {
    static int target = 0;      // where GOTO goes
    public static Random random = new Random(100);
    static StringBuffer result = new StringBuffer();
    public static int horizontal;
    public static int vertical;
    public static boolean [][] isCellComplete;
    public static int [][] maze;
    private static int q = 0;
    private static int x;

    public static void main(String[] args) {
    	horizontal = Integer.parseInt(args[0]);
    	vertical = Integer.parseInt(args[1]);
    	isCellComplete = new boolean[horizontal + 1][vertical + 1];
    	maze = new int [horizontal + 1][vertical + 1];
        doit();
        System.out.println(result);
        //System.out.println(random.nextFloat());
    }

    private static void clear() {
        result.setLength(0);
    }

    private static void println() {
        result.append("\n");
    }

    public static void print(String text) {
        result.append(text);
    }

    public static int rnd(int count) {
        return (int) (count * random.nextFloat()) + 1;
    }

    public static void GOTO(int lineno) {
        target = lineno;
    }

    public static void doit() {
        clear();
        print("Amazing - Copyright by Creative Computing, Morristown, NJ");
        println();

        if (horizontal == 1 || vertical == 1) return;

        
        int z = 0;
        x = rnd(horizontal);

        createEnterance(x);

        // 190
        int currentCellCount = 1;
        markCellComplete(x, 1);
        currentCellCount++;

        // 200
        int row = x;
        int column = 1;
        GOTO(270);

       loop: while (true) {
            switch (target) {
                case 210:
                    if (canMoveDown(row)) {
                    	row++;
                    } else {
                    	 if (canMoveRight(column)) {
                    		 row = 1;
                             column++;
                         } else {
                         	row = 1;
                         	column = 1;
                         }
                    }
                    if (isCellComplete(row, column))
                        GOTO(270);
                    else
                        GOTO(210);
                    continue;
                case 270:
                    if (canMoveUp(row)) // can go up
	                    if (isCellComplete(row-1, column)) //yes
	                        GOTO(600);
	                    else
	                    	if (canMoveLeft(column))
	                    		 if (isCellComplete(row, column-1))
	                                 GOTO(430);
	                             else
	                            	 if (isLastRow(row)) {
	                            		 if (canMoveRight(column)) {
	                                         if (isCellComplete(row, column+1))
	                                             GOTO(410);
	                                         else {
	                                        	 x = rnd(3);
	                                             if (x == 1)
	                                                 GOTO(940);
	                                             else if (x == 2)
	                                                 GOTO(980);
	                                             else if (x == 3)
	                                                 GOTO(1090);
	                                             else
	                                                 GOTO(410);
	                                         }
	                            		 }
	                                     else {
	                                    	 if (z == 1)
	                                             GOTO(410);
	                                         else {
	                                        	 method390();
	                                         }
	                                     }
	                            	 }
	                                 else
	                                	 if (isCellComplete(row+1, column)) {
	                                		 if (canMoveRight(column)) {
	                                             if (isCellComplete(row, column+1))
	                                                 GOTO(410);
	                                             else {
	                                            	 x = rnd(3);
	                                                 if (x == 1)
	                                                     GOTO(940);
	                                                 else if (x == 2)
	                                                     GOTO(980);
	                                                 else if (x == 3)
	                                                     GOTO(1090);
	                                                 else
	                                                     GOTO(410);
	                                             }
	                                		 }
	                                         else {
	                                        	 if (z == 1)
	                                                 GOTO(410);
	                                             else {
	                                            	 method390();
	                                             }
	                                         }
	                                	 }
	                                     else {
	                                    	  x = rnd(3);
	                                          if (x == 1)
	                                              GOTO(940);
	                                          else if (x == 2)
	                                              GOTO(980);
	                                          else if (x == 3)
	                                              GOTO(1020);
	                                          else {
	                                        	  if (canMoveRight(column)) {
	                                                  if (isCellComplete(row, column+1))
	                                                      GOTO(410);
	                                                  else {
	                                                	  x = rnd(3);
	                                                      if (x == 1)
	                                                          GOTO(940);
	                                                      else if (x == 2)
	                                                          GOTO(980);
	                                                      else if (x == 3)
	                                                          GOTO(1090);
	                                                      else
	                                                          GOTO(410);
	                                                  }
	                                        	  }
	                                              else {
	                                            	  if (z == 1)
	                                                      GOTO(410);
	                                                  else {
	                                                	  method390();
	                                                  }
	                                              }
	                                          }
	                                     }
	                        else
	                            GOTO(430);
                    else {
                    	GOTO(600); // no
                    }
                    continue;
                case 410:
                    x = rnd(2);
                    if (x == 1)
                        GOTO(940);
                    else if (x == 2)
                        GOTO(980);
                    else
                        GOTO(430);
                    continue;
                case 430:
                    if (isLastRow(row))
                        GOTO(530);
                    else
                        GOTO(440);
                    continue;
                case 440:
                    if (isCellComplete(row+1, column))
                        GOTO(530);
                    else
                        GOTO(450);
                    continue;
                case 450:
                    if (canMoveRight(column))
                        GOTO(480);
                    else
                        GOTO(460);
                    continue;
                case 460:
                    if (z == 1)
                        GOTO(510);
                    else
                        GOTO(470);
                    continue;
                case 470:
                    q = 1;
                    GOTO(490);
                    continue;
                case 480:
                    if (isCellComplete(row, column+1))
                        GOTO(510);
                    else
                        GOTO(490);
                    continue;
                case 490:
                    x = rnd(3);
                    GOTO(500);
                    continue;
                case 500:
                    if (x == 1)
                        GOTO(940);
                    else if (x == 2)
                        GOTO(1020);
                    else if (x == 3)
                        GOTO(1090);
                    else
                        GOTO(510);
                    continue;
                case 510:
                    x = rnd(2);
                    if (x == 1)
                        GOTO(940);
                    else if (x == 2)
                        GOTO(1020);
                    else
                        GOTO(530);
                    continue;
                case 530:
                    if (canMoveRight(column))
                        GOTO(560);
                    else
                        GOTO(540);
                    continue;
                case 540:
                    if (z == 1)
                        GOTO(940);
                    else
                        GOTO(550);
                    continue;
                case 550:
                    q = 1;
                    GOTO(570);
                    continue;
                case 560:
                    if (isCellComplete(row, column+1))
                        GOTO(940);
                    else
                        GOTO(570);
                    continue;
                case 570:
                    x = rnd(2);
                    if (x == 1)
                        GOTO(940);
                    else if (x == 2)
                        GOTO(1090);
                    else
                        GOTO(940);
                    continue;
                case 600:
                    if (canMoveLeft(column))
                        GOTO(610);
                    else
                        GOTO(790);
                    continue;
                case 610:
                    if (isCellComplete(row, column-1))
                        GOTO(790);
                    else
                        GOTO(620);
                    continue;
                case 620:
                    if (isLastRow(row))
                        GOTO(720);
                    else
                        GOTO(630);
                    continue;
                case 630:
                    if (isCellComplete(row+1, column))
                        GOTO(720);
                    else
                        GOTO(640);
                    continue;
                case 640:
                    if (canMoveRight(column))
                        GOTO(670);
                    else
                        GOTO(650);
                    continue;
                case 650:
                    if (z == 1)
                        GOTO(700);
                    else
                        GOTO(660);
                    continue;
                case 660:
                    q = 1;
                    GOTO(680);
                    continue;
                case 670:
                    if (isCellComplete(row, column+1))
                        GOTO(700);
                    else
                        GOTO(680);
                    continue;
                case 680:
                    x = rnd(3);
                    if (x == 1)
                        GOTO(980);
                    else if (x == 2)
                        GOTO(1020);
                    else if (x == 3)
                        GOTO(1090);
                    else
                        GOTO(700);
                    continue;
                case 700:
                    x = rnd(2);
                    if (x == 1)
                        GOTO(980);
                    else if (x == 2)
                        GOTO(1020);
                    else
                        GOTO(720);
                    continue;
                case 720:
                    if (canMoveRight(column))
                        GOTO(750);
                    else
                        GOTO(730);
                    continue;
                case 730:
                    if (z == 1)
                        GOTO(980);
                    else
                        GOTO(740);
                    continue;
                case 740:
                    q = 1;
                    GOTO(760);
                    continue;
                case 750:
                    if (isCellComplete(row, column+1))
                        GOTO(980);
                    else
                        GOTO(760);
                    continue;
                case 760:
                    x = rnd(2);
                    if (x == 1)
                        GOTO(980);
                    else if (x == 2)
                        GOTO(1090);
                    else
                        GOTO(980);
                    continue;
                case 790:
                    if (isLastRow(row))
                        GOTO(880);
                    else
                        GOTO(800);
                    continue;
                case 800:
                    if (isCellComplete(row+1, column))
                        GOTO(880);
                    else
                        GOTO(810);
                    continue;
                case 810:
                    if (canMoveRight(column))
                        GOTO(840);
                    else
                        GOTO(820);
                    continue;
                case 820:
                    if (z == 1)
                        GOTO(1020);
                    else
                        GOTO(830);
                    continue;
                case 830:
                    q = 1;
                    GOTO(990);
                    continue;
                case 840:
                    if (isCellComplete(row, column+1))
                        GOTO(1020);
                    else
                        GOTO(850);
                    continue;
                case 850:
                    x = rnd(2);
                    GOTO(860);
                    continue;
                case 860:
                    if (x == 1)
                        GOTO(1020);
                    else if (x == 2)
                        GOTO(1090);
                    else
                        GOTO(1020);
                    continue;
                case 880:
                    if (canMoveRight(column))
                        GOTO(910);
                    else
                        GOTO(890);
                    continue;
                case 890:
                    if (z == 1)
                        GOTO(210);
                    else
                        GOTO(900);
                    continue;
                case 900:
                    q = 1;
                    GOTO(1090);
                    continue;
                case 910:
                    if (isCellComplete(row, column+1))
                        GOTO(210);
                    else
                        GOTO(1090);
                    continue;
                case 940:
                	markCellComplete(row-1, column);
                    currentCellCount++;
                    maze[row - 1][column] = 2;
                    row--;
                    if (isMazeComplete(currentCellCount))
                        break loop;
                    else
                        GOTO(970);
                    continue;
                case 970:
                    q = 0;
                    GOTO(270);
                    continue;
                case 980:
                	markCellComplete(row, column-1);
                    GOTO(990);
                    continue;
                case 990:
                    currentCellCount++;
                    maze[row][column - 1] = 1;
                    column--;
                    if (isMazeComplete(currentCellCount))
                       ;
                    else
                        GOTO(1010);
                    continue;
                case 1010:
                    q = 0;
                    GOTO(270);
                    continue;
                case 1020:
                	markCellComplete(row+1, column);
                    currentCellCount++;
                    if (maze[row][column] == 0)
                        GOTO(1050);
                    else
                        GOTO(1040);
                    continue;
                case 1040:
                    maze[row][column] = 3;
                    GOTO(1060);
                    continue;
                case 1050:
                    maze[row][column] = 2;
                    GOTO(1060);
                    continue;
                case 1060:
                    row++;
                    if (isMazeComplete(currentCellCount))
                        break loop;
                    else
                        GOTO(600);
                    continue;
                case 1090:
                    if (q == 1)
                        GOTO(1150);
                    else
                        GOTO(1100);
                    continue;
                case 1100:
                	markCellComplete(row, column+1);
                    currentCellCount++;
                    if (maze[row][column] == 0)
                        GOTO(1120);
                    else
                        GOTO(1110);
                    continue;
                case 1110:
                    maze[row][column] = 3;
                    GOTO(1130);
                    continue;
                case 1120:
                    maze[row][column] = 1;
                    GOTO(1130);
                    continue;
                case 1130:
                    column++;
                    if (isMazeComplete(currentCellCount))
                        break loop;
                    else
                        GOTO(270);
                    continue;
                case 1150:
                    z = 1;
                    if (maze[row][column] == 0)
                        GOTO(1180);
                    else
                        GOTO(1170);
                    continue;
                case 1170:
                    maze[row][column] = 3;
                    q = 0;
                    GOTO(210);
                    continue;
                case 1180:
                    maze[row][column] = 1;
                    q = 0;
                    row = 1;
                    column = 1;
                    if (!isCellComplete(row, column))
                        GOTO(210);
                    else
                        GOTO(270);
                    continue;
            }
        }
        mazeToString();
    }
    
    // i'll break this out then I';; figure out what it does
	private static void method390() {
		q = 1;
		 x = rnd(3);
		 if (x == 1)
		     GOTO(940);
		 else if (x == 2)
		     GOTO(980);
		 else if (x == 3)
		     GOTO(1090);
		 else
		     GOTO(410);
	}

	private static boolean canMoveRight(int column) {
		return column != vertical;
	}

	private static boolean isLastRow(int row) {
		return row == horizontal;
	}

	private static boolean canMoveLeft(int column) {
		return column - 1 != 0;
	}

	private static boolean canMoveUp(int row) {
		return row - 1 != 0;
	}

	private static boolean canMoveDown(int row) {
		return row != horizontal;
	}

	private static boolean isMazeComplete(int currentCellCount) {
		return currentCellCount == vertical * horizontal + 1;
	}

	private static void mazeToString() {
		for (int j = 1; j <= vertical; j++) {
            print("I");        // 1210

            for (int i = 1; i <= horizontal; i++) {
                if (maze[i][j] >= 2)
                    print("   ");  // 1240
                else
                    print("  I");  // 1260
            }

            print(" ");   // 1280
            println();

            for (int i = 1; i <= horizontal; i++) {
                if (maze[i][j] == 0)
                    print(":--");   // 1300, 1340
                else if (maze[i][j] == 2)
                    print(":--");  // 1310, 1340
                else
                    print(":  "); // 1320
            }

            print(":");    // 1360
            println();
        }
	}
    
    private static void createEnterance(int x) {
    	// 130:170
        for (int i = 1; i <= horizontal; i++) {
            if (i == x)
                print(":  ");
            else
                print(":--");
        }
        // 180
        print(":");
        println();
    }
    private static void markCellComplete(int x, int y) {
    	isCellComplete[x][y] = true;
    }
    
    private static boolean isCellComplete(int x, int y) {
    	return isCellComplete[x][y];
    }
}
