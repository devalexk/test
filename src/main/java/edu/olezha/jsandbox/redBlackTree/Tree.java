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
        
        Node<T> currentNode = root;
        
        while (currentNode != null) {
            if (node.getValue().hashCode() > currentNode.getValue().hashCode()) {
                if (currentNode.getRightNode() == null)
                    node.setParentNode(currentNode);
                currentNode = currentNode.getRightNode();
            } else if (node.getValue().hashCode() < currentNode.getValue().hashCode()) {
                if (currentNode.getLeftNode() == null)
                    node.setParentNode(currentNode);
                currentNode = currentNode.getLeftNode();
            } else {
                if (currentNode.getRightNode() == null || currentNode.getLeftNode() == null) {
                    node.setParentNode(currentNode);
                    currentNode = null;
                } else
                    currentNode = currentNode.getLeftNode();
            }
        }
        
        if (node.getValue().hashCode() > node.getParentNode().getValue().hashCode())
            node.getParentNode().setRightNode(node);
        else if (node.getValue().hashCode() < node.getParentNode().getValue().hashCode())
            node.getParentNode().setLeftNode(node);
        else if (node.getParentNode().getLeftNode() == null)
            node.getParentNode().setLeftNode(node);
        else
            node.getParentNode().setRightNode(node);
        
        if (NodeColor.RED.equals(node.getParentNode().getColor()))
            balancing(node.getParentNode());
    }
    
    private void balancing(Node<T> node) {
        if (NodeColor.BLACK.equals(node.getColor()))
            return;
        
        if (node.getParentNode().getLeftNode() == null
                || NodeColor.BLACK.equals(node.getParentNode().getLeftNode().getColor())) {
            //TODO rotate left
        } else if (node.getParentNode().getRightNode() == null
                || NodeColor.BLACK.equals(node.getParentNode().getRightNode().getColor())) {
            //TODO rotate right
        } else if (node.getParentNode().getLeftNode().getColor().equals(node.getParentNode().getRightNode().getColor())) {
            //TODO repaint
            
            if (root.equals(node.getParentNode()))
                root.setColor(NodeColor.BLACK);
            else if (NodeColor.RED.equals(node.getParentNode().getParentNode().getColor()))
                balancing(node.getParentNode().getParentNode());
        }
    }

}
