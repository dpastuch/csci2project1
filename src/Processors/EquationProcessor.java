package Processors;

import java.util.ArrayList;
import Util.SymbolTable;

import java.util.Arrays;

/**
 * Class that processes incoming equations.
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

    /**
     * Process all the equations.
     */
    public void processEquations() {
        for(String e : equations) {
            processEquation(e);
        }
    }

    /**
     * Process an equation.
     * @param eq equation
     */
    private void processEquation(String eq) {
        String[] tokens = eq.split(" ");
        ArrayList<String> tokenList = new ArrayList<>(Arrays.asList(tokens));
        if(tokenList.get(0).equals("while(")) {
            whileLoop(eq.substring(6));
        }
        else if(tokenList.get(0).equals("if(")) {
            ifStatement(eq.substring(3));
        }
        else {
            evalStatement(eq);
        }

    }

    /**
     * Assign a value to a variable.
     * @param var variable name
     * @param tokenList expression
     */
    private void assignVar(String var, ArrayList<String> tokenList) {
        symbolTable.put(var, evaluate(tokenList));
    }

    /**
     * Print the hashmap containing all variables.
     */
    private void printVars() {
        symbolTable.dump();
    }

    /**
     * Print a statement.
     * @param tokenString expression
     */
    private void print(String tokenString) {
        String tokens = tokenString.trim();
        tokens = tokens.replace("(", "");
        tokens = tokens.replace(")", "");
        String[] tokenList = tokens.split(" ");
        ArrayList<String> tokenList2 =
                new ArrayList<>(Arrays.asList(tokenList));
        System.out.println(evaluate(tokenList2));
    }

    /**
     * Call an if statement.
     * @param tokenString expression
     */
    private void ifStatement(String tokenString) {
        String tokens = tokenString.trim();
        String[] tokenList = tokens.split(",");
        ArrayList<String> tokenList2 =
                new ArrayList<>(Arrays.asList(tokenList));
        if(evalStatement(tokenList2.get(0)) == 1) {
            evalStatement(tokenList2.get(1));
        }
        else {
            evalStatement(tokenList2.get(2));
        }
    }

    /**
     * Call a while loop.
     * @param tokenString expression
     */
    private void whileLoop(String tokenString) {
        String tokens = tokenString.trim();
        String[] tokenList = tokens.split(", ");
        String[] expList = tokenList[1].split("; ");
        for(String i : tokenList) {
            i.trim();
        }
        for(String i : expList) {
            i.trim();
        }
        ArrayList<String> tokenList2 =
                new ArrayList<>(Arrays.asList(tokenList));
        ArrayList<String> expList2 =
                new ArrayList<>(Arrays.asList(expList));
        while(evalStatement(tokenList2.get(0)) == 1) {
            for(String t : expList2) {
                evalStatement(t);
            }
        }
    }

    /**
     * Evaluate a string of tokens.
     * @param tokens expression
     * @return integer result
     */
    private int evaluate(String tokens) {
        String[] tokenArray = tokens.split(" ");
        ArrayList<String> tokenList =
                new ArrayList<>(Arrays.asList(tokenArray));
        processor.constructTree(tokenList);
        return processor.evaluateTree(symbolTable);
    }

    /**
     * Evaluate a list of tokens.
     * @param tokenList list of expression tokens
     * @return integer result
     */
    private int evaluate(ArrayList<String> tokenList) {
        processor.constructTree(tokenList);
        return processor.evaluateTree(symbolTable);
    }

    /**
     * Evaluate a statement.
     * @param tokens expression
     * @return integer result
     */
    private int evalStatement(String tokens) {
        String tokensTrimmed = tokens.trim();
        String[] tokenArray = tokensTrimmed.split(" ");
        ArrayList<String> tokenList =
                new ArrayList<>(Arrays.asList(tokenArray));
            if (tokens.contains("print(")) {
                print(tokens.substring(6));
            }
            else if (tokens.contains("printVariables()")) {
                printVars();
            }
            else if(tokenList.size() > 2 && tokenList.get(1).equals("=")) {
                String exp = tokens.substring(tokenList.get(0).length() + 3);
                exp = exp.replace(")", "");
                String[] expArray = exp.split(" ");
                ArrayList<String> expList = new ArrayList(Arrays.asList(expArray));
                    assignVar(tokenList.get(0), expList);
            }
            else {
                return evaluate(tokenList);
            }
            return 0;
    }
}
