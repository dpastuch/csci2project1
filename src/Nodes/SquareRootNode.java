package Nodes;

import Util.SymbolTable;

/**
 * Node that calculates the square root of its child.
 *
 * @author dmp6637 (David Pastuch)
 */
public class SquareRootNode extends UnaryOperatorNode {

    /**
     * Create a new square root node.
     * @param child Child node
     */
    public SquareRootNode(MerpNode child) {
        super(child, Precedence.POWER, "@");
    }

    /**
     * Evaulate this node.
     * @param symbolTable the symbol table to use for variable processing
     * @return The integer value of this node
     */
    @Override
    public int evaluate(SymbolTable symbolTable) {
        return (int)Math.pow(child.evaluate(symbolTable), 0.5);
    }
}