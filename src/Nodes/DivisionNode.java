package Nodes;

import Util.SymbolTable;

/**
 * Node that divides its children.
 *
 * @author dmp6637 (David Pastuch)
 */
public class DivisionNode extends BinaryOperatorNode {

    /**
     * Create a new division node.
     *
     * @param left  Left node
     * @param right right node
     */
    public DivisionNode(MerpNode left, MerpNode right) {
        super(left, right, Precedence.MULT_DIVIDE, "/");
    }

    /**
     * Evaulate this node.
     *
     * @param symbolTable the symbol table to use for variable processing
     * @return The integer value of this node
     */
    @Override
    public int evaluate(SymbolTable symbolTable) {
        if(rightChild.evaluate(symbolTable) == 0) {
            throw new IllegalArgumentException("Right child is 0");
        }
        return leftChild.evaluate(symbolTable) /
                rightChild.evaluate(symbolTable);
    }
}
