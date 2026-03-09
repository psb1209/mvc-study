package com.office.viewresolver;

import com.office.Config;

public class ViewResolver {

	final static public String viewResolverForJSP(String viewname) {
		return Config.VIEW_DEFAULT_PATH
				.concat(viewname)
				.concat(Config.VIEW_DEFAULT_EXTENTION);
	}
	
}
