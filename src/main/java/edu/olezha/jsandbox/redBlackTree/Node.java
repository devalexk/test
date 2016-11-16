package edu.olezha.jsandbox.redBlackTree;

import lombok.Data;

@Data
public class Node {
    
    private int value;
    private String color;
    private Node leftNode;
    private Node rightNode;

}
