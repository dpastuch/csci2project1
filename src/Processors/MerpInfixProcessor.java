package Processors;

import Nodes.*;
import Util.Errors;
import Util.SymbolTable;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

import static com.sun.org.apache.xalan.internal.xsltc.compiler.sym.error;

/**
 * Equation processor for equations that use infix notation.
 *
 * @author dmp6637 (David Pastuch)
 */
public class MerpInfixProcessor extends MerpProcessor {

    /**
     * Construct a tree from an infix expression.
     * @param tokens list of IerpNodes used to create the pares tree
     */
    @Override
    public void constructTree(ArrayList<String> tokens) {
        Stack<MerpNode> s1 = new Stack();
        Stack<MerpNode> nodeStack = new Stack();
        Stack<MerpNode> s2 = new Stack();
        Stack<MerpNode> operatorStack = new Stack();
        for (String t : tokens) {
            s1.push(createMerpNode(t));
        }
        while(!(s1.empty())) {
            nodeStack.push(s1.pop());
        }
        for(MerpNode n : nodeStack) {
            switch(n.getNodeType()) {
                case Constant: s2.push(n); break;
                case Variable: s2.push(n); break;
                case BinaryOperation:
                    if(operatorStack.empty()) {
                        operatorStack.push(n);
                    }
                    else {
                        if(n.getPrecedence() >=
                                operatorStack.peek().getPrecedence()) {
                            s2.push(operatorStack.pop());
                        }
                        operatorStack.push(n);
                    } break;
                case UnaryOperation:
                    if(operatorStack.empty()) {
                        operatorStack.push(n);
                    }
                    else {
                        if(n.getPrecedence() >
                                operatorStack.peek().getPrecedence()) {
                            s2.push(operatorStack.pop());
                        }
                        operatorStack.push(n);
                    } break;
                default:
                    Errors.error("Not a MerpNode",
                            System.err);
            }
        }
        while(!(operatorStack.empty())){
            s2.push(operatorStack.pop());
        }

        tree = processStack(s2);
    }

    /**
     * Helper method for constructTree.
     * @param stack stack
     * @return root node
     */
    private MerpNode processStack(Stack<MerpNode> stack) {
        MerpNode n = stack.get(stack.size() - 1);
        stack.remove(n);
        if(n instanceof BinaryOperatorNode) {
            ((BinaryOperatorNode) n).setLeftChild(processStack(stack));
            ((BinaryOperatorNode) n).setRightChild(processStack(stack));
        }
        else if(n instanceof UnaryOperatorNode) {
            ((UnaryOperatorNode) n).setChild(processStack(stack));
        }
        else if(n instanceof ConstantNode || n instanceof VariableNode)
            return n;
        else {
            Errors.error("String not in proper infix format",
                    System.err);
            return null;
        }
        return n;
    }
}
