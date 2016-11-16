package edu.olezha.jsandbox.redBlackTree;

import lombok.Data;

@Data
public class Tree {
    
    private Node root;
    
    public void add(int value) {
        Node node = new Node();
        node.setValue(value);
        node.setColor("red");
        
        if (root == null) {
            root = node;
            node.setColor("black");
            return;
        }
        
        Node currentNode = root;
        
        while (currentNode != null) {
            if (node.getValue() > currentNode.getValue()) {
                if (currentNode.getRightNode() == null) {
                    currentNode.setRightNode(node);
                    currentNode = null;
                } else
                    currentNode = currentNode.getRightNode();
            } else if (node.getValue() < currentNode.getValue()) {
                if (currentNode.getLeftNode() == null) {
                    currentNode.setLeftNode(node);
                    currentNode = null;
                } else
                    currentNode = currentNode.getLeftNode();
            } else {
                if (currentNode.getRightNode() == null) {
                    currentNode.setRightNode(node);
                    currentNode = null;
                } else if (currentNode.getLeftNode() == null) {
                    currentNode.setLeftNode(node);
                    currentNode = null;
                } else
                    currentNode = currentNode.getRightNode();
            }
        }
        
        balancing();
    }
    
    private void balancing() {}

}
