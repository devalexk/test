package edu.olezha.jsandbox.redBlackTree;

import lombok.Data;

@Data
public class Tree<T> {
    
    private Node<T> root;
    
    public void add(T value) {
        Node<T> node = new Node<T>();
        node.setValue(value);
        node.setColor(NodeColor.RED);
        
        if (root == null) {
            root = node;
            node.setColor(NodeColor.BLACK);
            return;
        }
        
        Node<T> currentNode = root, newParentNode = null;
        
        while (currentNode != null) {
            if (node.getValue().hashCode() > currentNode.getValue().hashCode()) {
                if (currentNode.getRightNode() == null)
                    newParentNode = currentNode;
                currentNode = currentNode.getRightNode();
            } else if (node.getValue().hashCode() < currentNode.getValue().hashCode()) {
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
        
        if (node.getValue().hashCode() > newParentNode.getValue().hashCode())
            newParentNode.setRightNode(node);
        else if (node.getValue().hashCode() < newParentNode.getValue().hashCode())
            newParentNode.setLeftNode(node);
        else if (newParentNode.getRightNode() == null)
            newParentNode.setRightNode(node);
        else
            newParentNode.setLeftNode(node);
        
        if (NodeColor.RED.equals(newParentNode.getColor()))
            balancing();
    }
    
    private void balancing() {}

}
