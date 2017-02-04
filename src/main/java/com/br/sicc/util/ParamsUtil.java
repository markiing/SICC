package com.br.sicc.util;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean
@SessionScoped
public class ParamsUtil {

	public static String CELLPHONE_VALUE = "C";
	public static String FIXPHONE_VALUE="F";
	public static String CLIENT_TYPE = "C";
	public static String VENDOR_TYPE = "V";
	
	public String getCLIENT_TYPE() {
		return CLIENT_TYPE;
	}
	
	public String getVENDOR_TYPE() {
		return VENDOR_TYPE;
	}
	
	public String getCellphoneValue() {
		return CELLPHONE_VALUE;
	}

	public String getFixphoneValue() {
		return FIXPHONE_VALUE;
	}
}
