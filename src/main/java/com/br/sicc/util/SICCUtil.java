package com.br.sicc.util;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;


public class SICCUtil {

	public static void exibirMensagem(FacesMessage.Severity severity, String mensagem){
		if(severity.equals(FacesMessage.SEVERITY_ERROR)){
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(severity,"Atenção !"+mensagem,null));			
		}else{
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(severity,"Atenção !",mensagem));		
		}
	}
	
	
}
