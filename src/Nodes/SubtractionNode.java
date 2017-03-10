package Nodes;

import Util.SymbolTable;

/**
 * Node that subtracts its right child from its left child.
 *
 * @author dmp6637 (David Pastuch)
 */
public class SubtractionNode extends BinaryOperatorNode {

    /**
     * Create a new subtraction node.
     * @param left Left node
     * @param right right node
     */
    public SubtractionNode(MerpNode left, MerpNode right) {
        super(left, right, Precedence.ADD_SUBTRACT, "-");
    }

    /**
     * Evaulate this node.
     * @param symbolTable the symbol table to use for variable processing
     * @return The integer value of this node
     */
    @Override
    public int evaluate(SymbolTable symbolTable) {
        return leftChild.evaluate(symbolTable) -
                rightChild.evaluate(symbolTable);
    }
}