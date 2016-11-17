package edu.olezha.jsandbox.redBlackTree;

import lombok.Data;

@Data
public class Node<T> {
    
    private T value;
    private NodeColor color;
    private Node<T> leftNode;
    private Node<T> rightNode;

}
