package org.vck.urlshortener.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.vck.urlshortener.domain.Url;
import org.vck.urlshortener.services.ShortUrlService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

/**
 * @author viswanath.ck
 */
@RestController
@RequestMapping("/shorten")
public class ShortUrlController {

    private static final Logger LOGGER = LoggerFactory.getLogger(ShortUrlController.class);

    @Autowired
    private ShortUrlService shortUrlService;

    @RequestMapping(value = "/", method= RequestMethod.POST, consumes = {"application/json"})
    public String shorten(@RequestBody final @Valid Url shortenRequest, HttpServletRequest request) throws
            Exception {

        LOGGER.info("Url to shorten : " + shortenRequest.getUrl());

        String shortenedUrl = shortUrlService.shortenUrl(shortenRequest.getUrl());
        LOGGER.info("Short url : " + shortenedUrl);
        return shortenedUrl;
    }

    @RequestMapping(value = "/{id}", method=RequestMethod.GET)
    public String longUrl(@PathVariable String id, HttpServletRequest request, HttpServletResponse response) throws
            Exception {

        LOGGER.info("Short url : " + id);
        String longUrl = shortUrlService.getLongUrl(id);
        LOGGER.info("Original URL: " + longUrl);

        return longUrl;
    }


}
