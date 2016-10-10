package com.xvitcoder.springmvcangularjs.beans;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.Assert;
import org.springframework.util.StringUtils;

// TODO: Auto-generated Javadoc
/**
 * The Class Parameter.
 */
public class Parameter implements Comparable<Parameter> {

	/** The param name. */
	private String paramName;

	/** The param value. */
	private String paramValue;

	/** The dynamic. */
	private boolean dynamic;

	/** The dynamic. */
	private boolean defaultParam;

	/**
	 * Checks if is default param.
	 *
	 * @return true, if is default param
	 */
	public boolean isDefaultParam() {
		return defaultParam;
	}

	/**
	 * Sets the default param.
	 *
	 * @param defaultParam
	 *            the new default param
	 */
	public void setDefaultParam(boolean defaultParam) {
		this.defaultParam = defaultParam;
	}

	/** The Constant DYNAMIC_PARAM_PATTERN_STR. */
	private static final String DYNAMIC_PARAM_PATTERN_STR = "\\$\\{(\\w+)\\}";

	/** The Constant DYNAMIC_PARAM_PATTERN. */
	private static final Pattern DYNAMIC_PARAM_PATTERN = Pattern.compile(DYNAMIC_PARAM_PATTERN_STR);

	/** The log. */
	private static Logger LOG = LoggerFactory.getLogger(Parameter.class);

	/**
	 * Instantiates a new parameter.
	 *
	 * @param paramName
	 *            the param name
	 * @param paramValue
	 *            the param value
	 */
	public Parameter(String paramName, String paramValue, boolean defaultParam) {
		// TODO Auto-generated constructor stub
		this.paramName = paramName;
		if (isDynamic(paramValue)) {
			this.paramValue = extractDynamicParamName(paramValue);
			this.dynamic = true;
		} else {
			this.paramValue = paramValue;
			this.dynamic = false;
		}
		this.defaultParam = defaultParam;

	}

	/**
	 * Instantiates a new parameter.
	 */
	public Parameter() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Parameter(String string, String string2) {
		// TODO Auto-generated constructor stub
	   this(string,string2,false);
	}

	/**
	 * Extract dynamic param name.
	 *
	 * @param paramValue2
	 *            the param value 2
	 * @return the string
	 */
	private static String extractDynamicParamName(String paramValue2) {

		Assert.notNull(paramValue2, "Dynamic param value is null or invalid!!");
		Matcher dynamicParamValueMAtcher = DYNAMIC_PARAM_PATTERN.matcher(paramValue2);
		if (dynamicParamValueMAtcher.matches()) {
			return dynamicParamValueMAtcher.group(1);
		}

		return paramValue2;
	}

	/**
	 * Checks if is dynamic.
	 *
	 * @param paramValue2
	 *            the param value 2
	 * @return true, if is dynamic
	 */
	private static boolean isDynamic(String paramValue2) {
		return !StringUtils.isEmpty(paramValue2) && paramValue2.matches(DYNAMIC_PARAM_PATTERN_STR);
	}

	/**
	 * Gets the param name.
	 *
	 * @return the param name
	 */
	public String getParamName() {
		return paramName;
	}

	/**
	 * Sets the param name.
	 *
	 * @param paramName
	 *            the new param name
	 */
	public void setParamName(String paramName) {
		this.paramName = paramName;
	}

	/**
	 * Gets the param value.
	 *
	 * @return the param value
	 */
	public String getParamValue() {
		return paramValue;
	}

	/**
	 * Sets the param value.
	 *
	 * @param paramValue
	 *            the new param value
	 */
	public void setParamValue(String paramValue) {
		this.paramValue = paramValue;
	}

	/**
	 * Checks if is dynamic.
	 *
	 * @return true, if is dynamic
	 */
	public boolean isDynamic() {
		return dynamic;
	}

	/**
	 * Sets the dynamic.
	 *
	 * @param dynamic
	 *            the new dynamic
	 */
	public void setDynamic(boolean dynamic) {
		this.dynamic = dynamic;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Comparable#compareTo(java.lang.Object)
	 */
	@Override
	public int compareTo(Parameter o) {
		if (o == null) {
			return -1;
		}
		if (o == this) {
			return 0;
		}
		return this.paramName.compareTo(o.paramName);
	}

	/**
	 * Parses the parameter.
	 *
	 * @param paramNameValueParameter
	 *            the param name value parameter
	 * @return the parameter
	 */
	public static Parameter parseParameter(String paramNameValueParameter) {
		Assert.notNull(paramNameValueParameter, "param name value pair is null or invalid!!");
		String[] params = paramNameValueParameter.split("=");
		Parameter parameter = null;
		if (params.length > 0) {
			parameter = new Parameter(params[0], params[1]);
		} else {

		}
		return parameter;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		StringBuilder parameterStr = new StringBuilder("");
		parameterStr.append(paramName).append("=");
		paramValue = dynamic ? "${" + paramValue + "}" : paramValue;
		parameterStr.append(paramValue);
		return parameterStr.toString();
	}

}
