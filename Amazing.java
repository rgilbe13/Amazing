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

    public static void main(String[] args) {
    	horizontal = Integer.parseInt(args[0]);
    	vertical = Integer.parseInt(args[1]);
    	isCellComplete = new boolean[horizontal + 1][vertical + 1];
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

        
        int[][] vArray = new int[horizontal + 1][vertical + 1];

        int q = 0;
        int z = 0;
        int x = rnd(horizontal);

        createEnterance(x);

        // 190
        int currentCellCount = 1;
        markCellComplete(x, 1);
        currentCellCount++;

        // 200
        int r = x;
        int s = 1;
        GOTO(270);

        while (target != -1) {
            switch (target) {
                case 210:
                    if (r != horizontal)
                        GOTO(250);
                    else
                        GOTO(220);
                    continue;
                case 220:
                    if (s != vertical)
                        GOTO(240);
                    else
                        GOTO(230);
                    continue;
                case 230:
                    r = 1;
                    s = 1;
                    GOTO(260);
                    continue;
                case 240:
                    r = 1;
                    s++;
                    GOTO(260);
                    continue;
                case 250:
                    r++;
                    GOTO(260);
                    continue;
                case 260:
                    if (!isCellComplete(r, s))
                        GOTO(210);
                    else
                        GOTO(270);
                    continue;
                case 270:
                    if (r - 1 == 0)
                        GOTO(600);
                    else
                        GOTO(280);
                    continue;
                case 280:
                    if (isCellComplete(r-1, s))
                        GOTO(600);
                    else
                        GOTO(290);
                    continue;
                case 290:
                    if (s - 1 == 0)
                        GOTO(430);
                    else
                        GOTO(300);
                    continue;
                case 300:
                    if (isCellComplete(r, s-1))
                        GOTO(430);
                    else
                        GOTO(310);
                    continue;
                case 310:
                    if (r == horizontal)
                        GOTO(350);
                    else
                        GOTO(320);
                    continue;
                case 320:
                    if (isCellComplete(r+1, s))
                        GOTO(350);
                    else
                        GOTO(330);
                    continue;
                case 330:
                    x = rnd(3);
                    if (x == 1)
                        GOTO(940);
                    else if (x == 2)
                        GOTO(980);
                    else if (x == 3)
                        GOTO(1020);
                    else
                        GOTO(350);
                    continue;
                case 350:
                    if (s != vertical)
                        GOTO(380);
                    else
                        GOTO(360);
                    continue;
                case 360:
                    if (z == 1)
                        GOTO(410);
                    else
                        GOTO(370);
                    continue;
                case 370:
                    q = 1;
                    GOTO(390);
                    continue;
                case 380:
                    if (isCellComplete(r, s+1))
                        GOTO(410);
                    else
                        GOTO(390);
                    continue;
                case 390:
                    x = rnd(3);
                    if (x == 1)
                        GOTO(940);
                    else if (x == 2)
                        GOTO(980);
                    else if (x == 3)
                        GOTO(1090);
                    else
                        GOTO(410);
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
                    if (r == horizontal)
                        GOTO(530);
                    else
                        GOTO(440);
                    continue;
                case 440:
                    if (isCellComplete(r+1, s))
                        GOTO(530);
                    else
                        GOTO(450);
                    continue;
                case 450:
                    if (s != vertical)
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
                    if (isCellComplete(r, s+1))
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
                    if (s != vertical)
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
                    if (isCellComplete(r, s+1))
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
                    if (s - 1 == 0)
                        GOTO(790);
                    else
                        GOTO(610);
                    continue;
                case 610:
                    if (isCellComplete(r, s-1))
                        GOTO(790);
                    else
                        GOTO(620);
                    continue;
                case 620:
                    if (r == horizontal)
                        GOTO(720);
                    else
                        GOTO(630);
                    continue;
                case 630:
                    if (isCellComplete(r+1, s))
                        GOTO(720);
                    else
                        GOTO(640);
                    continue;
                case 640:
                    if (s != vertical)
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
                    if (isCellComplete(r, s+1))
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
                    if (s != vertical)
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
                    if (isCellComplete(r, s+1))
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
                    if (r == horizontal)
                        GOTO(880);
                    else
                        GOTO(800);
                    continue;
                case 800:
                    if (isCellComplete(r+1, s))
                        GOTO(880);
                    else
                        GOTO(810);
                    continue;
                case 810:
                    if (s != vertical)
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
                    if (isCellComplete(r, s+1))
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
                    if (s != vertical)
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
                    if (isCellComplete(r, s+1))
                        GOTO(210);
                    else
                        GOTO(1090);
                    continue;
                case 940:
                	markCellComplete(r-1, s);
                    currentCellCount++;
                    vArray[r - 1][s] = 2;
                    r--;
                    if (currentCellCount == horizontal * vertical + 1)
                        GOTO(1200);
                    else
                        GOTO(970);
                    continue;
                case 970:
                    q = 0;
                    GOTO(270);
                    continue;
                case 980:
                	markCellComplete(r, s-1);
                    GOTO(990);
                    continue;
                case 990:
                    currentCellCount++;
                    vArray[r][s - 1] = 1;
                    s--;
                    if (currentCellCount == horizontal * vertical + 1)
                        GOTO(1200);
                    else
                        GOTO(1010);
                    continue;
                case 1010:
                    q = 0;
                    GOTO(270);
                    continue;
                case 1020:
                	markCellComplete(r+1, s);
                    currentCellCount++;
                    if (vArray[r][s] == 0)
                        GOTO(1050);
                    else
                        GOTO(1040);
                    continue;
                case 1040:
                    vArray[r][s] = 3;
                    GOTO(1060);
                    continue;
                case 1050:
                    vArray[r][s] = 2;
                    GOTO(1060);
                    continue;
                case 1060:
                    r++;
                    if (currentCellCount == horizontal * vertical + 1)
                        GOTO(1200);
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
                	markCellComplete(r, s+1);
                    currentCellCount++;
                    if (vArray[r][s] == 0)
                        GOTO(1120);
                    else
                        GOTO(1110);
                    continue;
                case 1110:
                    vArray[r][s] = 3;
                    GOTO(1130);
                    continue;
                case 1120:
                    vArray[r][s] = 1;
                    GOTO(1130);
                    continue;
                case 1130:
                    s++;
                    if (currentCellCount == vertical * horizontal + 1)
                        GOTO(1200);
                    else
                        GOTO(270);
                    continue;
                case 1150:
                    z = 1;
                    if (vArray[r][s] == 0)
                        GOTO(1180);
                    else
                        GOTO(1170);
                    continue;
                case 1170:
                    vArray[r][s] = 3;
                    q = 0;
                    GOTO(210);
                    continue;
                case 1180:
                    vArray[r][s] = 1;
                    q = 0;
                    r = 1;
                    s = 1;
                    GOTO(260);
                    continue;
                case 1200:
                    target = -1;
                    continue;
            }

        }

        // 1200:
        for (int j = 1; j <= vertical; j++) {
            print("I");        // 1210

            for (int i = 1; i <= horizontal; i++) {
                if (vArray[i][j] >= 2)
                    print("   ");  // 1240
                else
                    print("  I");  // 1260
            }

            print(" ");   // 1280
            println();

            for (int i = 1; i <= horizontal; i++) {
                if (vArray[i][j] == 0)
                    print(":--");   // 1300, 1340
                else if (vArray[i][j] == 2)
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
