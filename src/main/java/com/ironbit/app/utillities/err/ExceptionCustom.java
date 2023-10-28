package com.ironbit.app.utillities.err;

public class ExceptionCustom extends RuntimeException {
    private static final long serialVersionUID = 4195580573786431934L;

	public ExceptionCustom(String mensaje) {
        super(mensaje);
    }

}
