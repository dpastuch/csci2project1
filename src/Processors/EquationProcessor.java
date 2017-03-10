package Processors;

import Util.SymbolTable;

import java.util.ArrayList;

/**
 * Node that calculates an absolute value.
 *
 * @author dmp6637 (David Pastuch)
 */
public class EquationProcessor {

    ArrayList<String> equations;
    MerpProcessor processor;
    SymbolTable symbolTable;
    /**
     * Create a new equation processor.
     * @param equations ArrayList of equations
     * @param processor Merp processor to use
     */
    public EquationProcessor(ArrayList<String> equations,
                             MerpProcessor processor) {
        this.equations = equations;
        this.processor = processor;
        this.symbolTable = new SymbolTable();
    }

    public void processEquations() {

    }

    private void processEquation(String eq) {

    }
}
