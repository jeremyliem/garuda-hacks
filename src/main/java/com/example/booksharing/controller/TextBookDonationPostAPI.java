//package com.baeldung.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.async.DeferredResult;
import com.example.booksharing.model.TextBookDonationPost;
import com.example.booksharing.service.TextbookDonationPostService;

import java.util.Optional;

import java.util.concurrent.ForkJoinPool;

@RestController
public class TextBookDonationPostAPI {
    @GetMapping("/textbook-donation-post/{postId}")
	public Optional<TextBookDonationPost> getTextbookDonationPost(@PathVariable String postId) {
		TextbookDonationPostService textBookDonationPostService; //= new TextbookDonationPostService();
		Optional<TextBookDonationPost> output;
		try {
			output = textBookDonationPostService.getTextbookDonationPost(postId);
		} catch (InterruptedException e) {
		}
		return output; // What type am I expected to return? What are the list of functions that I need to prepare?
	}
}

// public interface TextbookDonationPostService {

//     TextBookDonationPost addTextbookDonationPost(TextBookDonationPost textBookDonationPost);
//     List<TextBookDonationPost> getAllTextbookDonationPost();
//     void deleteTextbookDonationPost(String postId);
//     Optional<TextBookDonationPost> getTextbookDonationPost(String postId);
//     void claimTextbookDonationPost(String postId);
//     List<TextBookDonationPost> searchTextbookDonationPost(String name, String subject, String author);

// }