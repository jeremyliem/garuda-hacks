package com.example.booksharing.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpServerErrorException;
import com.example.booksharing.model.TextBookDonationPost;
import com.example.booksharing.service.TextbookDonationPostService;
import java.util.Optional;
import java.util.List;

// Unused imports

// import org.slf4j.Logger;
// import org.slf4j.LoggerFactory;
// import org.springframework.ui.Model;
// import org.springframework.web.context.request.async.DeferredResult;
// import com.example.booksharing.model.TextBookRequestPost;
// import java.util.concurrent.ForkJoinPool;

@RestController
public class TextBookDonationPostAPI {

	private TextbookDonationPostService textbookDonationPostService;


    @GetMapping("/textbook-donation-post/{postId}")
	public Optional<TextBookDonationPost> getTextBookDonationPost(@PathVariable String postId) throws HttpServerErrorException {
		try {
			Optional<TextBookDonationPost> output;
			output = textbookDonationPostService.getTextbookDonationPost(postId);
			return output;
		} catch (Exception e) {
			throw new HttpServerErrorException(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PutMapping("/textbook-donation-post/{postId}")
	public ResponseEntity<TextBookDonationPost> putTextBookDonationPost(@PathVariable String postId, @RequestBody TextBookDonationPost requestedRequest) throws HttpServerErrorException {
		try{
			return new ResponseEntity<>(textbookDonationPostService.addTextbookDonationPost(requestedRequest), HttpStatus.OK);
		} catch (Exception e) {
			throw new HttpServerErrorException(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PostMapping("/textbook-donation-post/")
	public TextBookDonationPost addTextbookDonationPost(@RequestBody TextBookDonationPost requestedRequest) {
		try {
			return textbookDonationPostService.addTextbookDonationPost(requestedRequest);
		} catch (Exception e) {
			throw new HttpServerErrorException(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/textbook-donation-post/")
	public List<TextBookDonationPost> getAllTextbookDonationPost() {
		try {
			return textbookDonationPostService.getAllTextbookDonationPost();
		} catch (Exception e) {
			throw new HttpServerErrorException(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/textbook-donation-post/{name}/{subject}/{author}")
	public List<TextBookDonationPost> searchTextBookDonationPost(@PathVariable String name, @PathVariable String subject, @PathVariable String author) {
		try {
			return textbookDonationPostService.searchTextbookDonationPost(name, subject, author);
		} catch (Exception e) {
			throw new HttpServerErrorException(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@DeleteMapping("textbook-donation-post/{id}")
    public void deleteTextbookDonationPost(@PathVariable String id){
        try{
			textbookDonationPostService.deleteTextbookDonationPost(id);
        }catch (Exception e){
            throw new HttpServerErrorException(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

	@GetMapping("/textbook-donation-post/{id}")
	public void claimTextbookDonationPost(@PathVariable String id) {
		try {
			textbookDonationPostService.claimTextbookDonationPost(id);
		} catch (Exception e) {
			throw new HttpServerErrorException(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}

// What type am I expected to return? What are the list of functions that I need to prepare?

// public interface TextbookDonationPostService {

//     TextBookDonationPost addTextbookDonationPost(TextBookDonationPost textBookDonationPost);
//     List<TextBookDonationPost> getAllTextbookDonationPost();
//     void deleteTextbookDonationPost(String postId);
//     Optional<TextBookDonationPost> getTextbookDonationPost(String postId);
//     void claimTextbookDonationPost(String postId);
//     List<TextBookDonationPost> searchTextbookDonationPost(String name, String subject, String author);

// }