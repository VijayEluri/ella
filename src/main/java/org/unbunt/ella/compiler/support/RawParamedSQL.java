package org.unbunt.ella.compiler.support;

import java.util.List;
import java.util.Map;
import java.util.HashMap;
import java.util.ArrayList;

/**
 * Represents an SQL statement containing named parameters.
 */
public class RawParamedSQL {
    protected StringBuilder statement;
    protected Map<String, List<Integer>> paramIndices;
    protected int paramIndex;

    /**
     * Creates a new empty statement object.
     */
    public RawParamedSQL() {
        statement = new StringBuilder();
        paramIndices = new HashMap<String, List<Integer>>();
        paramIndex = 0;
    }

    public void appendToken(String text) {
        statement.append(text);
    }

    public void appendToken(char text) {
        statement.append(text);
    }

    public void addParam(String param) {
        List<Integer> indices = paramIndices.get(param);
        if (indices == null) {
            indices = new ArrayList<Integer>();
            paramIndices.put(param, indices);
        }
        indices.add(++paramIndex);
    }

    /**
     * Returns the statement text of the SQL statement with occurrances of named parameters replaced by positional
     * parameters.
     *
     * @return the statement text.
     */
    public String getStatement() {
        return statement.toString();
    }

    /**
     * Returns a mapping of parameters names to their corresponding positional parameter indices.
     *
     * @return the mapping.
     */
    public Map<String, List<Integer>> getParameters() {
        return paramIndices;
    }

    @Override
    public String toString() {
        StringBuilder buf = new StringBuilder();
        buf.append("RawParamedSQL[\n")
           .append("\tquery=[").append(statement).append("]\n")
           .append("\tparams=[\n");
        for (Map.Entry<String, List<Integer>> entry : paramIndices.entrySet()) {
            buf.append("\t\t").append(entry.getKey()).append("={");
            boolean first = true;
            for (Integer index : entry.getValue()) {
                if (first) {
                    first = false;
                }
                else {
                    buf.append(", ");
                }
                buf.append(index);
            }
            buf.append("}\n");
        }
        buf.append("\t]\n]\n");
        return buf.toString();
    }
}
