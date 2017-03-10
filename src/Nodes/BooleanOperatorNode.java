package Nodes;

import Util.SymbolTable;

/**
 * Node that performs a boolean operation.
 *
 * @author dmp6637 (David Pastuch)
 */
public abstract class BooleanOperatorNode extends BinaryOperatorNode {

    /**
     * Create a new boolean operator node.
     *
     * @param left     Left node
     * @param right    right node
     * @param operator arithmetic operator
     */
    public BooleanOperatorNode(MerpNode left, MerpNode right,
                               java.lang.String operator) {
        super(left, right, Precedence.BOOLEAN, operator);
    }

    /**
     * Get the precedence of this node.
     * @return precedence
     */
    public int getPrecedence() {
        return precedence.getPrecedence();
    }
}