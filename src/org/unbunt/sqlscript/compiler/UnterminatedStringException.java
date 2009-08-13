package org.unbunt.ella.compiler;

import org.antlr.runtime.IntStream;
import org.unbunt.ella.compiler.UnexpectedEOFException;

public class UnterminatedStringException extends UnexpectedEOFException {
    protected int stringType;

    public UnterminatedStringException(int stringType) {
        this.stringType = stringType;
    }

    public UnterminatedStringException(int expecting, IntStream input, int stringType) {
        super(expecting, input);
        this.stringType = stringType;
    }

    public int getStringType() {
        return stringType;
    }
}
