package Nodes;

import Util.SymbolTable;

/**
 * Node that raises its left child to the power of its right child.
 *
 * @author dmp6637 (David Pastuch)
 */
public class PowerNode extends BinaryOperatorNode {

    /**
     * Create a new power node.
     * @param left Left node
     * @param right right node
     */
    public PowerNode(MerpNode left, MerpNode right) {
        super(left, right, Precedence.POWER, "^");
    }

    /**
     * Evaulate this node.
     * @param symbolTable the symbol table to use for variable processing
     * @return The integer value of this node
     */
    @Override
    public int evaluate(SymbolTable symbolTable) {
        return (int)Math.pow(leftChild.evaluate(symbolTable),
                rightChild.evaluate(symbolTable));
    }
}