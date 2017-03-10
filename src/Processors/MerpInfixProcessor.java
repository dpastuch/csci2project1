package Processors;

import Nodes.AdditionNode;
import Nodes.ConstantNode;
import Nodes.MerpNode;
import Util.SymbolTable;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * Equation processor for equations that use infix notation.
 *
 * @author dmp6637 (David Pastuch)
 */
public class MerpInfixProcessor extends MerpProcessor {

    @Override
    public void constructTree(ArrayList<String> tokens) {
        Stack s1 = new Stack<String>();
        Queue q1 = new LinkedList<String>();
        for (String t : tokens) {
            try{
                Integer.parseInt(t);
                q1.add(t);
                } catch(Exception e){}
            if(t == "+" || t == "-" || t == "*" || t== "/") {
                s1.add(t);
            }
            else if()
        }
    }

    private MerpNode processStack(Stack<MerpNode> stack) {

    }

}
