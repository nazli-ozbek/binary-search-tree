import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
public class Reader {
    //this class is used to read a file and it contains test cases
    public static void main(String[]args){
    intTree it = new intTree();
    strTree st = new strTree();
    String filepath = "C:\\Users\\TEMP\\Desktop\\datafile.txt";
    try(BufferedReader br = new BufferedReader(new FileReader(filepath))){
        String line;
        while((line = br.readLine()) != null){
            String[] parts = line.split(",");
            String part1 = parts[0].trim();
            String part2 = parts[1].trim();
            String part3 = parts[2].trim();
            String part4 = parts[3].trim();
            String part5 = parts[4].trim();

            Student student = new Student(Integer.parseInt(part1), part2,part3,Integer.parseInt(part4),Double.parseDouble(part5));
            intNode in = new intNode(student);
            strNode sn = new strNode(student);

            it.iterativeInsert(in);
            st.iterativeInsert(sn);

        }
    }catch(IOException e){
        e.printStackTrace();
    }
        System.out.println("********** Deleting From ID Tree **********");
        //it.prettyPrint();
        it.delete(999882);
        //it.prettyPrint();
        System.out.println("********** Deleting From Name Tree **********");
        //st.prettyPrint();
        st.delete("Acosta Valerie Caldwell");
        //st.prettyPrint();

        System.out.println("********** Search **********");
        intNode.toString(it.iterativeSearch(999881));
        strNode.toString(st.iterativeSearch("Johnson Chris Garrett"));

        System.out.println("********** Interval Search For ID **********");
        intNode.multipleToString(it.iterativeIntervalSearch(797774,797781));
        System.out.println("**********");
        intNode.multipleToString(it.iterativeIntervalSearch(999871,999999));
        System.out.println("**********");
        intNode.multipleToString(it.iterativeIntervalSearch(314107,314110));

        System.out.println("********** Interval Search For Name **********");
        strNode.multipleToString(st.iterativeIntervalSearch("Johnson Chris Garrett","Johnson Christine Tate"));
        System.out.println("**********");
        strNode.multipleToString(st.iterativeIntervalSearch("Richardson David Cox","Richardson David Moore"));
        System.out.println("**********");
        strNode.multipleToString(st.iterativeIntervalSearch("Zuniga Arash","Zuniga Arda"));
    }
}
