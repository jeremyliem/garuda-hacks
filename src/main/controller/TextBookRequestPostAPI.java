package com.baeldung.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.async.DeferredResult;

import com.example.booksharing.model.TextBookDonationPost;

@RestController
public class TextBookRequestPostAPI {
    @GetMapping("/textbook-donation-post/{postId}")
	public TextBookDonationPost getTextbookDonationPost(@PathVariable String postId) {
		TextBookDonationPost output = new TextBookDonationPost();
		
		return output;
    }
}
}

