package Nodes;

import Util.SymbolTable;

/**
 * Node that checks if one of its children is less than or equal to the other.
 *
 * @author dmp6637 (David Pastuch)
 */
public class LessThanEqualNode extends BooleanOperatorNode {

    /**
     * Create a new less than or equal to node.
     * @param left Left node
     * @param right right node
     */
    public LessThanEqualNode(MerpNode left, MerpNode right) {
        super(left, right, "<=");
    }

    /**
     * Evaulate this node.
     * @param symbolTable the symbol table to use for variable processing
     * @return The integer value of this node
     */
    @Override
    public int evaluate(SymbolTable symbolTable) {
        if(leftChild.evaluate(symbolTable) <=
                rightChild.evaluate(symbolTable)) {
            return 1;
        }
        return 0;
    }
}