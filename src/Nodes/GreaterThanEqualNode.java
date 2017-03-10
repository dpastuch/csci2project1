package Nodes;

import Util.SymbolTable;

/**
 * Node that checks if one of its children is greater than or equal to the
 * other.
 *
 * @author dmp6637 (David Pastuch)
 */
public class GreaterThanEqualNode extends BooleanOperatorNode {

    /**
     * Create a new greater than or equal node.
     * @param left Left node
     * @param right right node
     */
    public GreaterThanEqualNode(MerpNode left, MerpNode right) {
        super(left, right, ">=");
    }

    /**
     * Evaulate this node.
     * @param symbolTable the symbol table to use for variable processing
     * @return The integer value of this node
     */
    @Override
    public int evaluate(SymbolTable symbolTable) {
        if(leftChild.evaluate(symbolTable) >=
                rightChild.evaluate(symbolTable)) {
            return 1;
        }
        return 0;
    }
}