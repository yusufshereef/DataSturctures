import java.util.LinkedList;
import java.util.Queue;

class Node{
    int val;
    Node left;
    Node right;

    Node(int val){
        this.val = val;
    }
}

public class BinaryTree {
    public static int size(Node root){
        if(root == null) return 0;
        return 1 + size(root.left) + size(root.right);
    }

    public static void preorder(Node root){
        if(root == null) return;
        System.out.println(root.val);
        preorder(root.left);
        preorder(root.right);
    }

    public static void inorder(Node root){
        if(root == null) return;
        inorder(root.left);
        System.out.println(root.val);
        inorder(root.right);
    }

    public static void postorder(Node root){
        if(root == null) return;
        postorder(root.left);
        postorder(root.right);
        System.out.println(root.val);
    }

    public static int sumOfNodes(Node root){
        if(root == null) return 0;
        return root.val+sumOfNodes(root.left)+sumOfNodes(root.right);
    }

    public static int productOfNodes(Node root){
        if(root == null) return 1;
        int res = productOfNodes(root.left) * productOfNodes(root.right);
        if(root.val != 0){
            res *= root.val;
        }
        return res;
    }

    public static int maxOfNodes(Node root){
        if(root == null) return 0;
        return Math.max(root.val, Math.max(maxOfNodes(root.left), maxOfNodes(root.right)));
    }

    public static int levelsInATree(Node root){
        if(root == null) return 0;
        int lstLevels = levelsInATree(root.left);
        int rstLevels = levelsInATree(root.right);
        return 1 + Math.max(lstLevels, rstLevels);
    }

    public static void bfs(Node root){
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        q.add(null);
        while(q.size()>0){
            Node front = q.remove();
            if(front == null){
                System.out.println();
                if(q.size()>0) q.add(null);
                continue;
            }
            System.out.print(front.val+" ");
            if(front.left!=null) q.add(front.left);
            if(front.right!=null) q.add(front.right);
        }
        System.out.println();
    }

    // ** imp
    public static int countLeafNodes(Node root){
        if(root == null){
            return 0;
        }
        if(root.left == null && root.right == null){
            return 1;
        }
        return countLeafNodes(root.left) + countLeafNodes(root.right);
    }

    // **imp
    public static int countParentNodes(Node root){
        if((root == null) && (root.left==null && root.right == null)){
            return 0;
        }
        return 1 + countParentNodes(root.left) + countParentNodes(root.right);
    }

    public static int countParentsHavingOneChild(Node root){
        // root is null or leaf (not a parent)
        if(root == null || (root.left==null && root.right == null)){
            return 0;
        }
        // parent with 1 child cases
        if(root.right == null){
            return 1 + countParentsHavingOneChild(root.left);
        }
        if(root.left == null){
            return 1 + countParentsHavingOneChild(root.right);
        }
        //parent with two children
        return countParentsHavingOneChild(root.left) + countParentsHavingOneChild(root.right);
    }

    public static int countParentsHavingTwoChild(Node root){
        if(root == null || (root.left == null && root.right == null)){
            return 0;
        }
        if(root.right == null){
            return countParentsHavingTwoChild(root.left);
        }
        if(root.left == null){
            return countParentsHavingTwoChild(root.right);
        }
        return 1 + countParentsHavingTwoChild(root.left) + countParentsHavingTwoChild(root.right);
    }

    public static void main(String[] args) {
        Node a = new Node(3);
        Node b = new Node(4);
        Node c = new Node(2);
        Node d = new Node(-1);
        Node e = new Node(7);
        Node f = new Node(9);
        Node g = new Node(1);
        Node h = new Node(6);
        a.left = b;
        a.right=c;
        // b.left=d;
        b.right = g;
        c.left=e;
        c.right = f;
        g.left = h;
        g.right = new Node(17);
        // bfs(a);
        // System.out.println(5*10*15*20*11);
        // System.out.println(productOfNodes(a));
        // System.out.println(sumOfNodes(a));
        // System.err.println("max node val:"+ maxOfNodes(a));
        // System.out.println(levelsInATree(a));
        System.out.println(countParentsHavingOneChild(a));
        System.out.println(countParentsHavingTwoChild(a));
    }

}
