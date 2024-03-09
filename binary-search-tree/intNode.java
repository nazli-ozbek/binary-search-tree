import java.util.ArrayList;
public class intNode {
    //integer node class that takes a student as data and stores the ID as a different attribute  to use in the binary tree
        protected intNode left;
        protected intNode right;
        protected Student data;
        protected int ID;

        public intNode(Student s){
            data = s;
            ID = s.getId();
            this.left = null;
            this.right = null;
        }
    //recursive min and max search classes are used in the deleting method
    public intNode recursiveMinSearch(){
        if (left == null){
            return this;
        }
        return left.recursiveMinSearch();
    }

    public intNode recursiveMaxSearch(){
        if (right == null){
            return this;
        }
        return right.recursiveMaxSearch();
    }

    public void prettyPrint(int level){
        for (int i = 0; i < level; i++){
            System.out.print("\t");
        }
        System.out.println(ID);
        if (left != null){
            left.prettyPrint(level + 1);
        }
        if (right != null){
            right.prettyPrint(level + 1);
        }
    }

    public static void toString(intNode n){
            try {
                System.out.println(n.data.toString());
    }catch(NullPointerException e){
                System.out.println("Student not found!");
            }
    }

    public static void multipleToString(ArrayList<intNode> a){
        if(a.size() != 0){
            for (int i = 0; i < a.size(); i++) {
                System.out.println(a.get(i).data.toString());
            }
        }else{
            System.out.println("Student not found!");
        }
    }


    public intNode getLeft(){
            return left;
        }

        public intNode getRight(){
            return right;
        }
}
