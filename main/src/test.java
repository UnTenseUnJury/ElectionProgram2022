import java.io.FileReader;
// import java.io.FileWriter;

public class test {

    public static void main(String[] args) throws Exception {
        // dhod chungus
        FileReader fr = new FileReader(
                "C:\\Users\\yuvar\\OneDrive\\Desktop\\rithul\\CODE\\applicating\\main\\main\\src\\testout.txt");
        int i;
        int it1 = 0, it2 = 0;
        String students[][] = {
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
    }
}
