package com.spring.common.util;

public class CommonUtil {

	public static String getSelect() {
		String sComboScript = "<select id='searchdate'>"
				   + "<option value='all' selected=''>-select-</option>"
				   + "<option value='1d'>1일</option>"
				   + "<option value='1w'>1주</option>"
				   + "<option value='1m'>1달</option>"
				   + "<option value='1y'>1년</option>"
				   + "</select>";
		return sComboScript;
	}
}
