package com.br.sicc.enumerator;

public enum StatusEnum {

	ABERTO("A"), FECHADO("F");
	
	private String status;

	private StatusEnum(String status) {
		this.status = status;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	
}
