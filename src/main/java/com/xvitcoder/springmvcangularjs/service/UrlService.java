package com.xvitcoder.springmvcangularjs.service;

import java.util.List;

import com.xvitcoder.springmvcangularjs.beans.Url;

/**
 * Created with IntelliJ IDEA.
 * User: xvitcoder
 * Date: 12/20/12
 * Time: 11:12 PM
 */
public interface UrlService {
    public List<Url> getAllUrls();
    public Url getUrl(String urlCode);

    public void addUrl(Url url);
    
    public void editUrl(Url url);

    public void deleteUrl(String urlCode);

    public void deleteAll();
}
