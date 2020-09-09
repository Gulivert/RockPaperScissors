package com.rockpaperscissors.web.utils;

public class WebException extends Exception {
	private static final long serialVersionUID = -2247628494944155007L;
	
    public WebException(Throwable throwable) {
        super(throwable);
    }

    public WebException(String message) {
        super(message);
    }

}
