import java.util.ArrayList;
public class strNode {
    //string node class that takes a student as data and stores the name and surname as a different attribute to use in the binary tree
    protected strNode left;
    protected strNode right;
    protected Student data;
    protected String namesur;

    public strNode(Student s){
        data = s;
        namesur = s.getSurname() + " "+ s.getName();
        this.left = null;
        this.right = null;
    }
    //recursive min and max search classes are used in the deleting method
    public strNode recursiveMinSearch(){
        if (left == null){
            return this;
        }
        return left.recursiveMinSearch();
    }

    public strNode recursiveMaxSearch(){
        if (right == null){
            return this;
        }
        return right.recursiveMaxSearch();
    }

    public void prettyPrint(int level){
        for (int i = 0; i < level; i++){
            System.out.print("\t");
        }
        System.out.println(namesur);
        if (left != null){
            left.prettyPrint(level + 1);
        }
        if (right != null){
            right.prettyPrint(level + 1);
        }
    }

    public static void toString(strNode n){
        try {
            System.out.println(n.data.toString());
        }catch(NullPointerException e){
            System.out.println("Student not found!");
        }
    }

    public static void multipleToString(ArrayList<strNode> a){
        if(a.size() != 0){
            for (int i = 0; i < a.size(); i++) {
                System.out.println(a.get(i).data.toString());
            }
        }else{
            System.out.println("Student not found!");
        }
    }



    public strNode getLeft(){
        return left;
    }

    public strNode getRight() {
        return right;
        }
    }
