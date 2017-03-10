package Nodes;

import Util.SymbolTable;

/**
 * Node that checks if one of its children is greater than the other.
 *
 * @author dmp6637 (David Pastuch)
 */
public class GreaterThanNode extends BooleanOperatorNode {

    /**
     * Create a new greater than node.
     * @param left Left node
     * @param right right node
     */
    public GreaterThanNode(MerpNode left, MerpNode right) {
        super(left, right, ">");
    }

    public int evaluate(SymbolTable symbolTable) {
        if (leftChild.evaluate(symbolTable) >
                rightChild.evaluate(symbolTable)) {
            return 1;
        }
        return 0;
    }
}

