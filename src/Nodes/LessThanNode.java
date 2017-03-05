package Nodes;

import Util.SymbolTable;

/**
 * Created by David on 3/5/2017.
 */
public class LessThanNode implements MerpNode {

    /**
     * Create a new constant node.
     * @param left Left node
     */
    public LessThanNode(MerpNode left, MerpNode right) {

    }

    /**
     * Determine if this node is an operation node.
     * @return True if this is an operation node, otherwise false
     */
    @Override
    public boolean isOperation() {
        return false;
    }

    /**
     * Evaulate this node.
     * @param symbolTable the symbol table to use for variable processing
     * @return The integer value of this node
     */
    @Override
    public int evaluate(SymbolTable symbolTable) {
        return 0;
    }

    /**
     * Get the precedence of this node.
     * @return The precedence of [ this ]
     */
    @Override
    public int getPrecedence() {
        return 0;
    }

    /**
     * Get this node's type.
     * @return Type of node
     */
    @Override
    public NodeType getNodeType() {
        return null;
    }

    /**
     * Convert this node to an infix string.
     * @return node in string format
     */
    @Override
    public String toInfixString() {
        return null;
    }

    /**
     * Convert this node to a postfix string.
     * @return node in string format
     */
    @Override
    public String toPostfixString() {
        return null;
    }

    /**
     * Convert this node to an prefix string.
     * @return node in string format
     */
    @Override
    public String toPrefixString() {
        return null;
    }
}
