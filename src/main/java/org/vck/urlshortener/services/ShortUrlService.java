package org.vck.urlshortener.services;

import org.apache.ignite.Ignite;
import org.apache.ignite.IgniteCache;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author viswanath.ck
 */

@Service
public class ShortUrlService {

    @Autowired
    Ignite ignite;

    public String shortenUrl(String url) {

        IgniteCache<Integer, String> igniteCache = ignite.cache("urlCache");
        igniteCache.put(1, "www.ha");
        return "test";
    }

    public String getLongUrl(String id) {

        return "really-long";
    }
}
