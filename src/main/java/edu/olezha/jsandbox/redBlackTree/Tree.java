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
        
        Node currentNode = root, newParentNode = null;
        
        while (currentNode != null) {
            if (node.getValue() > currentNode.getValue()) {
                if (currentNode.getRightNode() == null)
                    newParentNode = currentNode;
                currentNode = currentNode.getRightNode();
            } else if (node.getValue() < currentNode.getValue()) {
                if (currentNode.getLeftNode() == null)
                    newParentNode = currentNode;
                currentNode = currentNode.getLeftNode();
            } else {
                if (currentNode.getRightNode() == null || currentNode.getLeftNode() == null) {
                    newParentNode = currentNode;
                    currentNode = null;
                } else
                    currentNode = currentNode.getRightNode();
            }
        }
        
        if (node.getValue() > newParentNode.getValue())
            newParentNode.setRightNode(node);
        else if (node.getValue() < newParentNode.getValue())
            newParentNode.setLeftNode(node);
        else if (newParentNode.getRightNode() == null)
            newParentNode.setRightNode(node);
        else
            newParentNode.setLeftNode(node);
        
        if ("red".equals(newParentNode.getColor()))
            balancing();
    }
    
    private void balancing() {}

}
