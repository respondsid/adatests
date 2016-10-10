package com.xvitcoder.springmvcangularjs.controller;

import com.xvitcoder.springmvcangularjs.beans.Train;
import com.xvitcoder.springmvcangularjs.beans.Url;
import com.xvitcoder.springmvcangularjs.service.UrlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: xvitcoder
 * Date: 12/21/12
 * Time: 12:23 AM
 */
@Controller
@RequestMapping("/url")
public class UrlController {
	
    @Autowired
    private UrlService urlService;

    @RequestMapping("/urlslist.json")
    public @ResponseBody List<Url> getUrlList() {
        return urlService.getAllUrls();
    }

    
    @RequestMapping("/layout")
    public String getUrlPartialPage() {
        return "url/layout";
    }
    

}
