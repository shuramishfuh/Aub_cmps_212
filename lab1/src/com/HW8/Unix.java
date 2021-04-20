package com.HW8;

import com.sun.source.tree.BinaryTree;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class FileDir {
    LinkedBinaryTree tree;
    public FileDir() {
        tree = new LinkedBinaryTree<String>();
        tree.addRoot("/");
    }


    public static void Compute(String filename){ // convert all command to individual command and operands

        FileDir file = new FileDir();
        Node node = file.tree.root();
        List<String> commands =readCommands( filename);
        for (String s: commands) {
            Dictionary dict =breakDownCommands(s);
            String key = String.valueOf(dict.keys());
            node = file.applyCommand(key, String.valueOf(dict.get(key)),node);
        }

    }

    public Node applyCommand(String command, String operand, Node node){
        switch (command) {
            case "cd":
                    if (operand == "-1") return tree.root();
                    else if (node.getRight().getElement() == operand) return node.getRight();
                    else if (node.getLeft().getElement() == operand) return node.getLeft();
                    else{
                        System.out.println("no such directory");
                        return node;
                }

            case " pwd":
                    System.out.println(node.getElement());
                    return node;

            case  "createfile":
                if (operand =="-1"){
                    System.out.println(" cannot create file if the createfile command was used without specifying a " +
                            "file name");
                    return node;
                }
                if (!node.getIsDirectory()){
                    System.out.println(node.getElement().toString() +
                            "is not a directory ");return node;}
                int count =  operand.compareTo(node.getLeft().getElement().toString());
                Node n;
                if (count >0) {
                    try{
                        n = tree.addRight(node, operand);
                        n.setIsDirectory(false);
                        return n;
                    }
                    catch (Exception e){
                        System.out.println("capacity exceeded");
                    }
                }
                else{
                    try {

                        n = tree.addLeft(node, operand);
                        n.setIsDirectory(false);
                        return n;
                    }
                    catch (Exception e) {
                        System.out.println("capacity exceeded");
                        return node;
                    }
                }

            case  "mkdir":
                if (operand =="-1"){
                    System.out.println(" cannot create directory if the mkdir command was used without specifying " +
                            "a directory name");
                    return node;
                }
                if (!node.getIsDirectory()){
                    System.out.println(node.getElement().toString() +
                            "is not a directory ");
                    return node;
                }
                int t =  operand.compareTo(node.getLeft().getElement().toString());
                Node b;
                if (t >0) {
                    try{
                        b = tree.addRight(node, operand);
                        b.setIsDirectory(true);
                        return b;
                    }catch (Exception e) {
                        System.out.println("capacity exceeded");
                    }
                }
                else{
                    try{
                        b = tree.addLeft(node, operand);
                        b.setIsDirectory(true);
                        return b;
                    }catch (Exception e) {
                        System.out.println("capacity exceeded");
                        return node;
                    }
                }


            case "rm":
                if (operand =="-1"){
                    System.out.println(" no such file or directory");
                    return node;
                }
                if(node == tree.root()){
                    System.out.println("you cant remove root folder");
                    return node;
                }
                try{
                    Node p = node.getParent();
                    String  c =(String) tree.remove(node);
                    return p;
                }catch ( Exception e ){
                    System.out.println(" the specified file or directory does not exist within the current directory");
                    return node;
                }

            case "quota":
                if (node == tree.root()){
                    System.out.println(" 3 byte");
                    return node;
                }
                int size = 0;
                if (node.getIsDirectory()) { // directory and list all files and dir counting
                    List<Node> ls = tree.inorder();
                    for (Node nd : ls) {
                        if (nd.getIsDirectory()) {
                            size += 3;
                        } else size += 7;
                    }
                    size +=3; // extra for current directory
                }

                if (!node.getIsDirectory()) {// file
                    size =3;
                }
                System.out.println(size + "byte");
                return node;


            default:{
                System.out.println("no such command ");
                return node;
            }
        }
    }


    public static List<String> readCommands(String fileName)  {
        List<String > commands =new ArrayList<>();
        try {
            File file = new File(fileName);
            Scanner sc = new Scanner(file);
            while (sc.hasNextLine())
                commands.add(sc.nextLine());

        }
        catch (Exception exception){
            System.out.println("could not read file");
            commands = null;
        }
        finally {
            return commands;
        }
    }


    public static Dictionary breakDownCommands(String s){ // convert line from file to dict @key =command
        //@value = operand
       Dictionary dict = new Hashtable();
        Scanner scan = new Scanner(s);
        String b = null;
        String a;
        while (scan.hasNext()){
            a = scan.next();
            if (scan.hasNext()) b = scan.next();

            if (b != null)dict.put(a,b);
            else dict.put(a,-1);
            a =null;
            b =null;
        }
        return dict;
    }


    public static void main(String[] args) {
        FileDir fileDir = new FileDir();
    }
}
