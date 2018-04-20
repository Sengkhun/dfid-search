/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dfidsearch;

/**
 *
 * @author sengkhunlim
 */
public class Node {
    
    Node leftChild, rightChild;
    int value;
        
    public Node( int n ) {
        
        leftChild = rightChild = null;
        value = n;
        
    }
    
}
