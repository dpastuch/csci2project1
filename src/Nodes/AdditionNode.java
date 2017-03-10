package Nodes;

import Util.SymbolTable;

/**
 * Node that performs addition on its children.
 *
 * @author dmp6637 (David Pastuch)
 */
public class AdditionNode extends BinaryOperatorNode {

    /**
     * Create a new addition node.
     *
     * @param left  Left node
     * @param right Right node
     */
    public AdditionNode(MerpNode left, MerpNode right) {
        super(left, right, Precedence.ADD_SUBTRACT, "+");
    }

    /**
     * Evaulate this node.
     *
     * @param symbolTable the symbol table to use for variable processing
     * @return The integer value of this node
     */
    @Override
    public int evaluate(SymbolTable symbolTable) {
        return leftChild.evaluate(symbolTable) +
                rightChild.evaluate(symbolTable);
    }
}