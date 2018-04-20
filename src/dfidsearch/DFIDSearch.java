/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dfidsearch;

import java.util.Stack;

/**
 *
 * @author sengkhunlim
 */
public class DFIDSearch {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        int[] initVal = { 5, 6, 1, 2, 10, 7, 3, 20, 15 };
        
        // Create Tree
        Tree t = new Tree( initVal[0] );
        Node current = t.root;
        
        // First Level
        current.leftChild = new Node( initVal[1] ); // root->left
        current.rightChild = new Node( initVal[2] ); // root->right
        
        // Second Level
        current = t.root.leftChild;
        current.leftChild = new Node( initVal[3] ); // root->left->left
        current.leftChild.leftChild = new Node( initVal[4] ); // root->left->left->left
        current.leftChild.rightChild = new Node( initVal[5] ); // root->left->left->right
        
        current = t.root.rightChild;
        current.leftChild = new Node( initVal[6] ); // root->right->left
        current.rightChild = new Node( initVal[7] ); // root->right->right
        current.leftChild.rightChild = new Node( initVal[8] ); // root->right->left->right
        
        int limit = 3, goal = 5;
                
        if ( DFID( t, goal, limit ) ) {
            
            System.out.println("Found");
            
        } else {
            
            System.out.println("Not Found");
            
        }
        
    }
    
    public static boolean DFID( Tree t, int goal, int limit ) {
        
        for (int i = 0; i <= limit; i++) {
            
            if ( DLS( t.root, goal, i ) ) return true;
            
        }
        
        return false;
        
    }
        
    public static boolean DLS( Node node, int goal, int limit ) {
        
        if ( limit == 0 && node.value == goal ) return true;
        
        if ( limit > 0 ) {
            
            if ( node.leftChild != null )
                if ( DLS( node.leftChild, goal, limit -1 ) )
                    return true;
            
            if ( node.rightChild != null )
                if ( DLS( node.rightChild, goal, limit -1 ) )
                    return true;
            
        }
        
        return false;
        
    }
    
}
