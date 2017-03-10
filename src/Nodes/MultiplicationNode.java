package Nodes;

import Util.SymbolTable;

/**
 * Node that multiplies its children.
 *
 * @author dmp6637 (David Pastuch)
 */
public class MultiplicationNode extends BinaryOperatorNode {

    /**
     * Create a new multiplication node.
     * @param left Left node
     * @param right right node
     */
    public MultiplicationNode(MerpNode left, MerpNode right) {
        super(left, right, Precedence.MULT_DIVIDE, "*");
    }

    /**
     * Evaulate this node.
     * @param symbolTable the symbol table to use for variable processing
     * @return The integer value of this node
     */
    @Override
    public int evaluate(SymbolTable symbolTable) {
        return leftChild.evaluate(symbolTable) *
                rightChild.evaluate(symbolTable);
    }
}