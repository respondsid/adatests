package com.xvitcoder.springmvcangularjs.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.xvitcoder.springmvcangularjs.beans.Url;

// TODO: Auto-generated Javadoc
/**
 * The Class UrlServiceImpl.
 */
@Service("UrlService")
public class UrlServiceImpl implements UrlService {

	/** The url list. */
	private static List<Url> urlList = new ArrayList<Url>();

	/** The id. */
	private static Long id = 0L;

	/**
	 * Find url by id.
	 *
	 * @param id
	 *            the id
	 * @return the url
	 */
	private Url findUrlById(String id) {
		for (Url rs : urlList) {
			if (rs.getUrlCode().equalsIgnoreCase(id)) {
				return rs;
			}
		}

		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.xvitcoder.springmvcangularjs.service.UrlService#getAllUrls()
	 */
	@Override
	public List<Url> getAllUrls() {
		// TODO Auto-generated method stub
		if (urlList.isEmpty()) {
			Url tempUrl=Url.parseUrl("http://test.fidelity.com?testParam1=paramVal&param2=${paramValue2}");
			tempUrl.setApplication("test");
			tempUrl.setUrlCode("test");
			urlList.add(tempUrl);
			
		}
		return urlList;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.xvitcoder.springmvcangularjs.service.UrlService#addUrl(com.xvitcoder.
	 * springmvcangularjs.beans.Url)
	 */
	@Override
	public void addUrl(Url url) {
		// TODO Auto-generated method stub
		urlList.add(url);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.xvitcoder.springmvcangularjs.service.UrlService#editUrl(com.xvitcoder
	 * .springmvcangularjs.beans.Url)
	 */
	@Override
	public void editUrl(Url url) {
		Url found = findUrlById(url.getUrlCode());
		if (found != null) {
			urlList.remove(found);
			urlList.add(url);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.xvitcoder.springmvcangularjs.service.UrlService#deleteUrl(java.lang.
	 * String)
	 */
	@Override
	public void deleteUrl(String urlCode) {
		// TODO Auto-generated method stub

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.xvitcoder.springmvcangularjs.service.UrlService#deleteAll()
	 */
	@Override
	public void deleteAll() {
		// TODO Auto-generated method stub

	}

	@Override
	public Url getUrl(String urlCode) {
		// TODO Auto-generated method stub
		return findUrlById(urlCode);
	}

}
