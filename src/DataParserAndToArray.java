import java.util.ArrayList;
import java.util.List;

public class DataParserAndToArray {
	//private final List<char[]> charlist = new ArrayList<>();
	private final List<Double> charlist = new ArrayList<>();
    private final List<Integer> intlist = new ArrayList<>();

    public void parseLine(String line) {
        int charpos = line.indexOf(' '); //find the position of blank
        //System.out.println(" blank position >>> " + charpos);
        if (charpos >= 0) { 
            //charlist.add(line.substring(0, charpos).toCharArray());
            charlist.add(Double.parseDouble(line.substring(0,charpos))); //derive the char from 0 to charpos
            intlist.add(Integer.parseInt(line.substring(charpos + 1))); //derive the char after charpos+1
        } else {
            // the line does not have a >
            // throw an exception?
        }
    }

    //public char[][] getChars() {
    public double[] getChars() {
        //return charlist.toArray(new char[charlist.size()][]);
        double[] ch = new double[charlist.size()];
        int cnt = 0;
        for (Double d : charlist) {
            ch[cnt++] = d;
        }
        return ch;
    }

    public int[] getInts() {
        int[] ret = new int[intlist.size()];
        int cnt = 0;
        for (int d : intlist) {
            ret[cnt++] = d;
        }
        return ret;
    }
/*
    public static void main(String[] args) throws IOException {
        Path inputpath = Paths.get("D:\\hello-1.txt");
        List<String> inputlines = Files.readAllLines(inputpath, StandardCharsets.UTF_8);

        DataParserAndToArray parser = new DataParserAndToArray();
        // set up a loop over the input data
        for (String line : inputlines) {
            parser.parseLine(line);
        }
        //char[][] chars = parser.getChars();
        double[] chars = parser.getChars();
        int[] ints = parser.getInts();

        //System.out.println(Arrays.deepToString(chars));
        System.out.println(Arrays.toString(chars));
        System.out.println(Arrays.toString(ints));
    }

*/
}
