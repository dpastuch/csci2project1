package Nodes;

import Util.SymbolTable;

/**
 * Node that negates its child.
 *
 * @author dmp6637 (David Pastuch)
 */
public class NegationNode extends UnaryOperatorNode {

    /**
     * Create a new negation node.
     *
     * @param child Child node
     */
    public NegationNode(MerpNode child) {
        super(child, Precedence.MULT_DIVIDE, "_");
    }

    /**
     * Evaulate this node.
     *
     * @param symbolTable the symbol table to use for variable processing
     * @return The integer value of this node
     */
    @Override
    public int evaluate(SymbolTable symbolTable) {
        return -(child.evaluate(symbolTable));
    }
}