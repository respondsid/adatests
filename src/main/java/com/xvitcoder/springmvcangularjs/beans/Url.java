package com.xvitcoder.springmvcangularjs.beans;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.Assert;
import org.springframework.util.StringUtils;

// TODO: Auto-generated Javadoc
/**
 * The Class Url.
 */
public class Url {

	/** The log. */
	private static Logger LOG = LoggerFactory.getLogger(Url.class);

	/** The url code. */
	private String urlCode;

	/** The url. */
	private String baseUrl;

	/** The parameters. */
	private List<Parameter> parameters;

	/** The application. */
	private String application;

	/** The inser user. */
	private String inserUser;

	private String fullUrl;
	
	
	/**
	 * Gets the base url.
	 *
	 * @return the base url
	 */
	public String getFullUrl() {
		return fullUrl=toString();
	}
	
	/**
	 * Gets the base url.
	 *
	 * @return the base url
	 */
	public String getBaseUrl() {
		return baseUrl;
	}

	/**
	 * Sets the base url.
	 *
	 * @param baseUrl
	 *            the new base url
	 */
	public void setBaseUrl(String baseUrl) {
		this.baseUrl = baseUrl;
	}

	/**
	 * Gets the parameters.
	 *
	 * @return the parameters
	 */
	public List<Parameter> getParameters() {
		return parameters;
	}

	/**
	 * Sets the parameters.
	 *
	 * @param parameters
	 *            the new parameters
	 */
	public void setParameters(List<Parameter> parameters) {
		this.parameters = parameters;
	}

	/**
	 * Gets the url code.
	 *
	 * @return the url code
	 */
	public String getUrlCode() {
		return urlCode;
	}

	/**
	 * Sets the url code.
	 *
	 * @param urlCode
	 *            the new url code
	 */
	public void setUrlCode(String urlCode) {
		this.urlCode = urlCode;
	}

	/**
	 * Parses the url.
	 *
	 * @param urlWithParams
	 *            the url with params
	 * @return the url
	 */
	public static Url parseUrl(String urlWithParams) {
		Url tempUrl = new Url();
		tempUrl.initialize(urlWithParams);
		return tempUrl;
	}

	/**
	 * Initialize.
	 *
	 * @param fullUrl
	 *            the full url
	 */
	private void initialize(String fullUrl) {
		Assert.notNull(fullUrl, "Url is null or invalid");
		//this.fullURL=fullUrl;
		int queryParamIndex = fullUrl == null ? -1 : fullUrl.indexOf("?");
		if (queryParamIndex > 0) {
			this.baseUrl = fullUrl.substring(0, queryParamIndex);
			this.parameters = initializeParams(fullUrl.substring(queryParamIndex + 1).split("&"));
		} else {
			this.baseUrl = fullUrl;
		}
	}

	/**
	 * Initialize params.
	 *
	 * @param params
	 *            the params
	 * @return the list
	 */
	private List<Parameter> initializeParams(String[] params) {
		// TODO Auto-generated method stub
		if (params == null) {
			return null;
		}
		List<Parameter> parameters = new ArrayList<Parameter>();
		for (int i = 0; i < params.length; i++) {
			parameters.add(Parameter.parseParameter(params[i]));
		}
		Collections.sort(parameters);
		return parameters;
	}

	/**
	 * Gets the application.
	 *
	 * @return the application
	 */
	public String getApplication() {
		return application;
	}

	/**
	 * Sets the application.
	 *
	 * @param application
	 *            the new application
	 */
	public void setApplication(String application) {
		this.application = application;
	}

	/**
	 * Gets the inser user.
	 *
	 * @return the inser user
	 */
	public String getInserUser() {
		return inserUser;
	}

	/**
	 * Sets the inser user.
	 *
	 * @param inserUser
	 *            the new inser user
	 */
	public void setInserUser(String inserUser) {
		this.inserUser = inserUser;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder urlBuilder = new StringBuilder("");
		if (!StringUtils.isEmpty(baseUrl)) {
			urlBuilder.append(baseUrl);
			if (parameters != null) {
				Collections.sort(parameters);
				urlBuilder.append("?");
				String seperator = "";
				for (Parameter p : parameters) {
					urlBuilder.append(seperator).append(p.toString());
					seperator = "&";
				}
			}
		}
		return urlBuilder.toString();
	}

	/**
	 * The main method.
	 *
	 * @param args
	 *            the arguments
	 */
	public static void main(String[] args) {
		Url url = Url.parseUrl("abc.com?time=name&minute=${dynamic}&absolute=vodka");
		System.out.println(url.toString());
		url= new Url();
		url.setBaseUrl("fidelity.com/mybenefits");
		List<Parameter> parameters= new ArrayList<Parameter>();
		Parameter p= new Parameter();
		p.setDynamic(true);
		p.setParamName("testParam1");
		p.setParamValue("paramDynamicValue1");
		parameters.add(p);
		p= new Parameter();
		p.setDynamic(false);
		p.setParamName("abcParam1");
		p.setParamValue("StaticValue1");
		parameters.add(p);
		url.setParameters(parameters);
		System.out.println(url.toString());
		
	}
}
