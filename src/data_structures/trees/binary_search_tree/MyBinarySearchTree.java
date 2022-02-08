package data_structures.trees.binary_search_tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class MyBinarySearchTree {

    enum SearchType{
        IN_ORDER,
        PRE_ORDER,
        POST_ORDER
    }


    private MyNode root;

    public MyBinarySearchTree() {
        this.root = null;
    }

    public void insert(int value){
        if(root == null){
            root = new MyNode(value);
            return;
        }
        MyNode currentNode = root;
        while(true){
            if(currentNode.getValue()>value){
                if(currentNode.getLeft() == null){
                    currentNode.setLeft(new MyNode(value));
                    return;
                }
                currentNode = currentNode.getLeft();
            }else {
                if(currentNode.getRight() == null){
                    currentNode.setRight(new MyNode(value));
                    return;
                }
                currentNode = currentNode.getRight();
            }

        }
    }

    public MyNode lookUp(int value){
        if(root == null) return null;
        MyNode currentNode = root;
        while(currentNode != null){
            if(value < currentNode.getValue()){
                currentNode = currentNode.getLeft();
            }else if (value > currentNode.getValue()){
                currentNode = currentNode.getRight();
            }else{
                return currentNode;
            }
        }
        return null;
    }

    int count = 0;
    public void printTree(){
        count = 0;
        printTreeFunc(root);
    }

    private void printTreeFunc(MyNode node){
        System.out.print(node.getValue());
        System.out.println();
        count++;
        if(node.getLeft() != null){
            System.out.print("\t".repeat(Math.max(0,count))+"Left: ");
            printTreeFunc(node.getLeft());
        }
        if (node.getRight() != null){
            System.out.print("\t".repeat(Math.max(0,count))+"Right: ");
            printTreeFunc(node.getRight());
        }
        count--;
    }

    public void remove(int value){
        if(root == null) return;

        MyNode nodeToRemove = root;
        MyNode parentNode = null;

        while(nodeToRemove.getValue() != value){
            parentNode = nodeToRemove;
            if(nodeToRemove.getValue() > value){
                nodeToRemove = nodeToRemove.getLeft();
            }else if(nodeToRemove.getValue() < value){
                nodeToRemove = nodeToRemove.getRight();
            }
        }

        MyNode replacementNode = null;
        if (nodeToRemove.getRight() != null) { //We have a right node
            replacementNode = nodeToRemove.getRight();
            if(replacementNode.getLeft() == null) { //We don't have a left node
                replacementNode.setLeft(nodeToRemove.getLeft());
            } else { //We have a have a left node, lets find the leftmost
                MyNode replacementParentNode = nodeToRemove;
                while (replacementNode.getLeft() != null) {
                    replacementParentNode = replacementNode;
                    replacementNode = replacementNode.getLeft();
                }
                replacementParentNode.setLeft(null);
                replacementNode.setLeft(nodeToRemove.getLeft());
                replacementNode.setRight(nodeToRemove.getRight());
            }
        } else if(nodeToRemove.getLeft() != null) {//We only have a left node
            replacementNode = nodeToRemove.getLeft();
        }

        if(parentNode == null) {
            root = replacementNode;
        } else if(parentNode.getLeft() == nodeToRemove) { //We are a left child
            parentNode.setLeft(replacementNode);
        } else { //We are a right child
            parentNode.setRight(replacementNode);
        }
    }

    public List<Integer> breadthFirstSearchIteratively(){
        MyNode currentNode = root;
        List<Integer> list = new ArrayList<>();
        Queue<MyNode> queue = new LinkedList<>();
        queue.add(currentNode);

        while (!queue.isEmpty()){
            currentNode = queue.poll();
            list.add(currentNode.getValue());
            if(currentNode.getLeft() != null){
                queue.add(currentNode.getLeft());
            }
            if(currentNode.getRight() != null){
                queue.add(currentNode.getRight());
            }
        }
        return list;
    }

    public List<Integer> breadthFirstSearchRecursion(){
        Queue<MyNode> queue = new LinkedList<>();
        queue.add(root);
        return breadthFirstSearchRecursion(queue, new ArrayList<>());
    }

    private List<Integer> breadthFirstSearchRecursion(Queue<MyNode> queue, List<Integer> list){
        if (queue.isEmpty()){
            return list;
        }

        MyNode currentNode = queue.poll();
        list.add(currentNode.getValue());
        if(currentNode.getLeft() != null){
            queue.add(currentNode.getLeft());
        }
        if(currentNode.getRight() != null){
            queue.add(currentNode.getRight());
        }
        return breadthFirstSearchRecursion(queue,list);
    }

    public List<Integer> depthFirstSearch(SearchType searchType){
        return depthFirstSearch(root, new ArrayList<>(), searchType);
    }

    private List<Integer> depthFirstSearch(MyNode node, List<Integer> list, SearchType searchType){
        if(searchType == SearchType.IN_ORDER){
            if(node.getLeft() != null){
                depthFirstSearch(node.getLeft(),list,searchType);
            }
            list.add(node.getValue());
            if (node.getRight() != null){
                depthFirstSearch(node.getRight(),list,searchType);
            }
        }

        if(searchType == SearchType.PRE_ORDER){
            list.add(node.getValue());
            if(node.getLeft() != null){
                depthFirstSearch(node.getLeft(),list,searchType);
            }
            if (node.getRight() != null){
                depthFirstSearch(node.getRight(),list,searchType);
            }
        }

        if(searchType == SearchType.POST_ORDER){
            if(node.getLeft() != null){
                depthFirstSearch(node.getLeft(),list,searchType);
            }
            if (node.getRight() != null){
                depthFirstSearch(node.getRight(),list,searchType);
            }
            list.add(node.getValue());
        }

        return list;
    }


    public static void main(String[] args) {
        MyBinarySearchTree tree = new MyBinarySearchTree();
        tree.insert(9);
        tree.insert(4);
        tree.insert(20);
        tree.insert(1);
        tree.insert(6);
        tree.insert(15);
        tree.insert(170);
        tree.printTree();
        tree.remove(20);
        tree.remove(4);
        tree.printTree();
        tree.insert(20);
        tree.insert(18);
        tree.insert(10);
        tree.printTree();
        tree.remove(170);
        tree.printTree();
        System.out.println("Tree Breadth First Search: " + tree.breadthFirstSearchIteratively().toString());
        System.out.println("Tree Breadth First Search Recursive: " + tree.breadthFirstSearchRecursion().toString());
        System.out.println("Tree Depth First Seach Inorder: " + tree.depthFirstSearch(SearchType.IN_ORDER).toString());
        System.out.println("Tree Depth First Seach PreOrder: " + tree.depthFirstSearch(SearchType.PRE_ORDER).toString());
        System.out.println("Tree Depth First Seach PostOrder: " + tree.depthFirstSearch(SearchType.POST_ORDER).toString());

    }
}
