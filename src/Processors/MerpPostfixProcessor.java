package Processors;

import Nodes.*;
import Util.Errors;

import java.util.ArrayList;

/**
 * Created by David on 3/5/2017.
 */
public class MerpPostfixProcessor extends MerpProcessor {

    /**
     * Construct a tree from a postfix expression.
     * @param tokens list of IerpNodes used to create the pares tree
     */
    @Override
    public void constructTree(java.util.ArrayList<java.lang.String> tokens) {
        tree = constructTreeHelper(tokens);
    }

    /**
     * Helper method for constructTree.
     * @param tokens list of string tokens
     * @return root node
     */
    private MerpNode constructTreeHelper(ArrayList<String> tokens) {
        MerpNode n = createMerpNode(tokens.get(tokens.size() - 1));
        tokens.remove(tokens.get(tokens.size() - 1));
        if(n instanceof BinaryOperatorNode) {
            ((BinaryOperatorNode) n).setRightChild(constructTreeHelper(tokens));
            ((BinaryOperatorNode) n).setLeftChild(constructTreeHelper(tokens));
        }
        else if(n instanceof UnaryOperatorNode) {
            ((UnaryOperatorNode) n).setChild(constructTreeHelper(tokens));
        }
        else if(n instanceof ConstantNode || n instanceof VariableNode)
            return n;
        else {
            Errors.error("String not in proper postfix format",
                    System.err);
            return null;
        }
        return n;
    }
}
