package Processors;

import Nodes.*;
import Util.Errors;

import java.util.ArrayList;

/**
 * Class for processing mathematical expressions in prefix form.
 *
 * @author dmp6637 (David Pastuch)
 */
public class MerpPrefixProcessor extends MerpProcessor {

    @Override
    public void constructTree(java.util.ArrayList<java.lang.String> tokens) {
        tree = constructTreeHelper(tokens);
    }

    private MerpNode constructTreeHelper(ArrayList<String> tokens) {
        MerpNode n = createMerpNode(tokens.get(0));
        tokens.remove(tokens.get(0));
        if(n instanceof BinaryOperatorNode) {
            ((BinaryOperatorNode) n).setLeftChild(constructTreeHelper(tokens));
            ((BinaryOperatorNode) n).setRightChild(constructTreeHelper(tokens));
        }
        else if(n instanceof UnaryOperatorNode) {
            ((UnaryOperatorNode) n).setChild(constructTreeHelper(tokens));
        }
        else if(n instanceof ConstantNode || n instanceof VariableNode)
            return n;
        else {
            Errors.error("String not in proper prefix format",
                    System.err);
            return null;
        }
        return n;
    }
}
