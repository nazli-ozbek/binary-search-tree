import java.util.ArrayList;
import java.util.Stack;
public class strTree {
    //this is the string binary tree, uses student's "surname+name"s while sorting them
    protected strNode root;

    public strTree() {
        root = null;
    }

    protected void insertChild(strNode parent, strNode child) {
        if (parent == null) {
            root = child;
        } else {
            if (child.namesur.compareTo(parent.namesur) < 0) {
                parent.left = child;
            } else {
                parent.right = child;
            }
        }
    }

    //this method is used to insert a new node into the string binary tree
    public void iterativeInsert(strNode node) {
        strNode parent = null;
        strNode tmp = root;
        while (tmp != null) {
            parent = tmp;
            if (node.namesur.compareTo(tmp.namesur) < 0) {
                tmp = tmp.getLeft();
            } else {
                tmp = tmp.getRight();
            }
        }
        insertChild(parent, node);
    }

    protected strNode getParent(strNode node) {
        strNode x = root, parent = null;
        while (x != node) {
            parent = x;
            if (x.namesur.compareTo(node.namesur) > 0) {
                x = x.left;
            } else {
                x = x.right;
            }
        }
        return parent;
    }

    //this method is used to delete a specific node from the tree
    public void delete(String value) {
        try {
            strNode y, x = root, parent;
            while (!x.namesur.equals(value)) {
                if (x.namesur.compareTo(value) > 0) {
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
                x.namesur = y.namesur;
                x = y;
            }
        } catch (NullPointerException e) {
            System.out.println("Student not found!");
        }
    }

    //this method is used to search for a specific student from the tree
    public strNode iterativeSearch(String value) {
        strNode tmp = root;
        while (tmp != null) {
            if (value.compareTo(tmp.namesur) < 0) {
                tmp = tmp.getLeft();
            } else {
                if (value.compareTo(tmp.namesur) > 0) {
                    tmp = tmp.getRight();
                } else {
                    return tmp;
                }
            }
        }
        return null;
    }

    //this method is used to search students between an interval and returns them as an arraylist
    public ArrayList<strNode> iterativeIntervalSearch(String lowerBound, String upperBound) {
        ArrayList<strNode> results = new ArrayList<>();
        Stack<strNode> stack = new Stack<>();
        strNode tmp = root;
        while (tmp != null || !stack.isEmpty()) {
            while (tmp != null) {
                stack.push(tmp);
                tmp = tmp.left;
            }
            tmp = stack.pop();
            if (tmp.namesur.compareTo(lowerBound) >= 0 && tmp.namesur.compareTo(upperBound) <= 0) {
                results.add(tmp);
            }
            tmp = tmp.right;
        }
        return results;
    }

    public void prettyPrint() {
        if (root != null) {
            root.prettyPrint(0);
        }
    }
}

