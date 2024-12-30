/**
 * Programming Challenge 21.6
 * Binary Tree Input and Display
 */
import java.util.*;

import java.io.*;
import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.stage.Stage;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

public class Main extends Application
{

    public static void main(String [] args) throws IOException
   {
      launch(args);
   }

    @Override
    public void start(Stage stage) throws Exception
    {
       BinaryTree bTree = new BinaryTree();
       bTree.buildTreeFromFile();  

       // Stage and scene stuff
       stage.setTitle("Binary Tree Display");
       stage.setScene(new Scene(bTree.getTreeView()));
       stage.show();

    }
}

class BinaryTree
{
    static class Node
    {
        private String name;
        private Node left, right;
        private Node(String name)
        {
            this.name = name;
            left = null; right = null;
        }
        private Node(String name, Node left, Node right)
        {
            this.name = name;
            this.left = left;
            this.right = right;
        }
    }
    private Node root = null;

    /**
     *
     * @return the TreeView corresponding to (the root of) this binary tree
     */
    Parent getTreeView()
    {
        if (root == null) 
            return new Label("Empty Tree");
        else
            return new TreeView<>(getTreeItems(root));
    }

    TreeItem<String>  getTreeItems(Node root)
    {
        if (root == null) return null;
        TreeItem<String> rootTreeItem = new TreeItem<String> (root.name);       
        if (root.left != null)
        {
            rootTreeItem.getChildren().add(getTreeItems(root.left));
        }
         if (root.right != null)
        {
            rootTreeItem.getChildren().add(getTreeItems(root.right));
        }
        rootTreeItem.setExpanded(true);
        return rootTreeItem;
    }


    /**
     * Builds the binary tree from data stored in a file.
     * The user is asked to choose the file.
     * @throws IOException
     */
    void buildTreeFromFile() throws IOException
    {
        // Use a map to help in building the binary tree
        // The name for a node is used a key in the map to locate the node

        }
    }
    /**
     * Gets or creates a node with a given name
     * Looks up the node in the given map, and returns it if found.
     * If the node is not found in the map, a new node with that name
     * is created, stored in the map, and returned.
     * @param name
     * @param nodeMap
     * @return a node in the map that has the given name
     */
    static Node getNode(String name, Map<String, Node> nodeMap)
    {
        Node aNode = nodeMap.get(name);
        if (aNode == null)
        {
            //Create  a new mode with this name, store it in the map
            aNode = new Node(name);
            nodeMap.put(name, aNode);
            return aNode;
        }
        return aNode;
    }
}
