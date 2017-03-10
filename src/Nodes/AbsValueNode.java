package Nodes;

import Util.SymbolTable;

import java.util.function.UnaryOperator;

/**
 * Class for processing mathematical expressions in prefix form.
 */
public class AbsValueNode extends UnaryOperatorNode {

    /**
     * Create a new absolute value node.
     *
     * @param child Child of node
     */
    public AbsValueNode(MerpNode child) {
        super(child, Precedence.MULT_DIVIDE, "|");
    }

    /**
     * Evaulate this node.
     *
     * @param symbolTable the symbol table to use for variable processing
     * @return The integer value of this node
     */
    @Override
    public int evaluate(SymbolTable symbolTable) {
        return Math.abs(child.evaluate(symbolTable));
    }
}

