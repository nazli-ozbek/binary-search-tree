import java.util.ArrayList;
import java.util.Stack;

public class intTree {
    //this is the integer binary tree, uses student's IDs while sorting them
        protected intNode root;

        public intTree(){
            root = null;
        }

    protected void insertChild(intNode parent, intNode child){
        if (parent == null) {
            root = child;
        } else {
            if (child.ID < parent.ID) {
                parent.left = child;
            } else {
                parent.right = child;
            }
        }
    }
    //this method is used to insert a new node into the integer binary tree
    public void iterativeInsert(intNode node){
        intNode parent = null;
        intNode tmp = root;
        while (tmp != null) {
            parent = tmp;
            if (node.ID < tmp.ID){
                tmp = tmp.getLeft();
            } else {
                tmp = tmp.getRight();
            }
        }
        insertChild(parent, node);
    }

    protected intNode getParent(intNode node){
        intNode x = root, parent = null;
        while (x != node){
            parent = x;
            if (x.ID > node.ID){
                x = x.left;
            } else {
                x = x.right;
            }
        }
        return parent;
    }
    //this method is used to delete a specific node from the tree
    public void delete(int value) {
            try {
        intNode y, x = root, parent;
        while (x.ID != value) {
            if (x.ID > value) {
                x = x.left;
            } else {
                x = x.right;
            }
        }
        parent = getParent(x);
        while (true) {
            if (x.left != null) {
                y = x.left.recursiveMaxSearch();
                parent = getParent(y);
            } else {
                if (x.right != null) {
                    y = x.right.recursiveMinSearch();
                    parent = getParent(y);
                } else {
                    if (parent == null) {
                        root = null;
                    } else {
                        if (parent.left == x) {
                            parent.left = null;
                        } else {
                            parent.right = null;
                        }
                    }
                    break;
                }
            }
            x.data = y.data;
            x.ID = y .ID;
            x = y;
        }
    }catch(NullPointerException e){
        System.out.println("Student not found!");
            }
    }
    //this method is used to search for a specific student from the tree
    public intNode iterativeSearch(int value){
        intNode tmp = root;
        while (tmp != null){
            if (value < tmp.ID){
                tmp = tmp.getLeft();
            } else {
                if (value > tmp.ID){
                    tmp = tmp.getRight();
                } else {
                    return tmp;
                }
            }
        }
        return null;
    }
    //this method is used to search students between an interval and returns them as an arraylist
    public ArrayList<intNode> iterativeIntervalSearch (int lowerBound, int upperBound){
            ArrayList<intNode> results = new ArrayList<>();
            Stack<intNode> stack = new Stack<>();
            intNode tmp = root;
            while(tmp != null || !stack.isEmpty()){
                while(tmp != null){
                    stack.push(tmp);
                    tmp = tmp.left;
                }
                tmp = stack.pop();
                if(tmp.ID >= lowerBound && tmp.ID <= upperBound){
                    results.add(tmp);
                }
                tmp = tmp.right;
            }
            return results;
    }

        public void prettyPrint(){
            if (root != null){
                root.prettyPrint(0);
            }
    }
}
