package com.xvitcoder.springmvcangularjs.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.xvitcoder.springmvcangularjs.beans.Parameter;
import com.xvitcoder.springmvcangularjs.beans.Url;
import com.xvitcoder.springmvcangularjs.service.UrlService;

/**
 * Created with IntelliJ IDEA. User: xvitcoder Date: 12/21/12 Time: 12:23 AM
 */
@Controller
@RequestMapping("/urls")
public class UrlsController {

	static Map<String, List<Parameter>> appCodeParamMap = new HashMap<String, List<Parameter>>();
	static {
		initializeAppParamMap();
	}

	private static void initializeAppParamMap() {
		// TODO Auto-generated method stub
		List<Parameter> parameters = new ArrayList<Parameter>();
		Parameter param = new Parameter("SSODVendorID", "", true);
		parameters.add(param);
		param = new Parameter("ClientID", "", true);
		parameters.add(param);
		appCodeParamMap.put("ssod", parameters);
		parameters = new ArrayList<Parameter>();
		param = new Parameter("NBVendorID", "", true);
		parameters.add(param);
		param = new Parameter("NBClientID", "", true);
		parameters.add(param);
		appCodeParamMap.put("nb", parameters);

	}

	@Autowired
	private UrlService urlService;

	@RequestMapping("/urlslist.json")
	public @ResponseBody List<Url> getUrlList() {
		return urlService.getAllUrls();
	}

	@RequestMapping(value = "/{application}/appCodeParameters.json", method = RequestMethod.GET)
	public @ResponseBody List<Parameter> getParameters(@PathVariable("application") String application) {
		return appCodeParamMap.get(application);
	}

	@RequestMapping(value = "/{urlCode}", method = RequestMethod.GET)
	public @ResponseBody Url getUrl(@PathVariable("urlCode") String urlCode) {
		return urlService.getUrl(urlCode);
	}

	@RequestMapping(method = RequestMethod.POST)
	public @ResponseBody void addUrl(@RequestBody Url url) {
		urlService.addUrl(url);
	}

	@RequestMapping(method = RequestMethod.PUT)
	public @ResponseBody void updateUrl(@RequestBody Url url) {
		urlService.editUrl(url);
	}

	@RequestMapping("/layout")
	public String getUrlPartialPage() {
		return "urls/layout";
	}

	/*
	 * @RequestMapping(value = "/addUrl", method = RequestMethod.POST)
	 * public @ResponseBody void addCar(@PathVariable("car") String car) {
	 * carService.addCar(car); }
	 * 
	 * @RequestMapping(value = "/removeCar/{car}", method =
	 * RequestMethod.DELETE) public @ResponseBody void
	 * removeCar(@PathVariable("car") String car) { carService.deleteCar(car); }
	 * 
	 * @RequestMapping(value = "/removeAllCars", method = RequestMethod.DELETE)
	 * public @ResponseBody void removeAllCars() { carService.deleteAll(); }
	 * 
	 * @RequestMapping("/layout") public String getCarPartialPage() { return
	 * "cars/layout"; }
	 */
}
