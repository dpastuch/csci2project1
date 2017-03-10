package Nodes;

import Util.SymbolTable;

/**
 * Node that checks if one of its children is less than the other.
 */
public class LessThanNode extends BooleanOperatorNode {

    /**
     * Create a new less than node.
     *
     * @param left Left node
     */
    public LessThanNode(MerpNode left, MerpNode right) {
        super(left, right, "<");
    }

    /**
     * Evaulate this node.
     *
     * @param symbolTable the symbol table to use for variable processing
     * @return The integer value of this node
     */
    @Override
    public int evaluate(SymbolTable symbolTable) {
        if (leftChild.evaluate(symbolTable) <
                rightChild.evaluate(symbolTable)) {
            return 1;
        }
        return 0;
    }
}