package com.ggmartin.paperrockscissors.domain.util;

public class GameException extends Exception {
	private static final long serialVersionUID = -6229171683677438534L;

	private Integer code;

	public GameException(Throwable throwable) {
		super(throwable);
	}

	public GameException(Integer code, String message) {
		super(message);
		this.code = code;
	}

	public GameException( String message) {
		super(message);
		this.code = 500;
	}

	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

}
