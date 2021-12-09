import java.io.FileWriter;
import java.io.FileReader;
import java.util.*;

public class election {

    static String students[][] = {
            /* sc cap 0 */ { "", "", "", "" },
            /* sc v cap 1 */ { "", "", "", "" },
            /* spo cap 2 */ { "", "", "", "" },
            /* spo v cap 3 */ { "", "", "", "" },
            /* green cap 4 */ { "", "", "", "" },
            /* green v cap 5 */{ "", "", "", "" },
            /* blue cap 6 */ { "", "", "", "" },
            /* blue v cap 7 */ { "", "", "", "" },
            /* yellow cap 8 */ { "", "", "", "" },
            /* yellow v cap 9 */{ "", "", "", "" },
            /* red cap 10 */ { "", "", "", "" },
            /* red v cap 11 */ { "", "", "", "" }
    };

    public static void newscroll(){
        for(int i=0;i<70;i++){
            System.out.println("\n");
        }
    }

    public static String[] positions = { "School Captain", "School Vice Captain",
            "Sports Captain", "Sports Vice Captain",
            "Green House Captain", "Green House Vice Captain",
            "Blue House Captain", "Blue House Vice Captain",
            "Yellow House Captain", "Yellow House Vice Captain",
            "Red House Captain", "Red House Vice Captain" };

    private static int[][] votes = {
            /* sc cap 0 */ { 0, 0, 0, 0 },
            /* sc v cap 1 */ { 0, 0, 0, 0 },
            /* spo cap 2 */ { 0, 0, 0, 0 },
            /* spo v cap 3 */ { 0, 0, 0, 0 },
            /* green cap 4 */ { 0, 0, 0, 0 },
            /* green v cap 5 */{ 0, 0, 0, 0 },
            /* blue cap 6 */ { 0, 0, 0, 0 },
            /* blue v cap 7 */ { 0, 0, 0, 0 },
            /* yellow cap 8 */ { 0, 0, 0, 0 },
            /* yellow v cap 9 */{ 0, 0, 0, 0 },
            /* red cap 10 */ { 0, 0, 0, 0 },
            /* red v cap 11 */ { 0, 0, 0, 0 }
    };
    // Green Blue Yellow Red

    public static void voting(int num) {
        Scanner sc = new Scanner(System.in);
        int vote;
        try {
            candidate(num);
            System.out.println();
            System.out.println("Enter your vote");
            System.out.print("> ");
            vote = sc.nextInt();
            newscroll();
            votes[num][vote - 1] += 1;
        } catch (Exception e) {
            System.out.println("RE-ENTER VOTE!");
            voting(num);
        }
    }

    public static void candidate(int ind) {
        int size = students[ind].length;
        System.out.println("Candidates for " + positions[ind] + ":");
        System.out.println();
        for (int i = 0; i < size; i++) {
            System.out.println(students[ind][i] + " is " + ((int) i + 1));
        }
    }

    private static void init() throws Exception {
        // dhod chungus
        FileReader fr = new FileReader(
                "C:\\Users\\yuvar\\OneDrive\\Desktop\\rithul\\CODE\\applicating\\main\\main\\src\\testout.txt");
        int i;
        int it1 = 0, it2 = 0;
        while ((i = fr.read()) != -1) {

            if ((char) i == ',') {
                it2 += 1;
            } else if ((char) i == '|') {
                it1 += 1;
                it2 = 0;
            } else
                students[it1][it2] = students[it1][it2] + (char) i;

        }
        fr.close();
        it1 = 0;
        it2 = 0;
        String temp = "";
        FileReader fr1 = new FileReader(
                "C:\\Users\\yuvar\\OneDrive\\Desktop\\rithul\\CODE\\applicating\\main\\main\\src\\result.pvtfile");
        while ((i = fr1.read()) != -1) {
            if ((char) i == ',') {
                it2 += 1;
                votes[it1][it2] = Integer.valueOf(temp);
                temp = "";
            } else if ((char) i == '|') {
                it1 += 1;
                it2 = 0;
            } else
                temp = temp + String.valueOf((char) i);
        }
        fr1.close();

    }

    public static void main(String args[]) throws Exception {
        Scanner sc = new Scanner(System.in);

        int stu;
        init();
        System.out.println("Enter the number of students in session");
        System.out.print("> ");
        stu = sc.nextInt();
        newscroll();
        for (int i = -1; i < stu; i++) {
            for (int x = 0; x < 12; x++) {
                voting(x);
            }
        }
        try {
            String temp = "";
            FileWriter fw = new FileWriter(
                    "C:\\Users\\yuvar\\OneDrive\\Desktop\\rithul\\CODE\\applicating\\main\\main\\src\\result.pvtfile");
            for (int i = 0; i < 11; i++) {
                for (int j = 0; j < votes[i].length; j++) {
                    temp = temp + votes[i][j];
                    if (j != 3) {
                        temp = temp + ",";
                    }
                    temp = temp + "|";
                }
            }
            fw.write(temp);
            fw.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
