package com.example.booksharing.controller;

import com.example.booksharing.model.TextBookRequestPost;
import com.example.booksharing.service.TextbookRequestPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpServerErrorException;

import java.util.List;

@RestController
public class TextbookRequestController {

    private TextbookRequestPostService textbookRequestPostService;

    @Autowired
    public TextbookRequestController(TextbookRequestPostService textbookRequestPostService){
        this.textbookRequestPostService = textbookRequestPostService;
    }

    @GetMapping("textbook-request-post/{postId}")
    public ResponseEntity<TextBookRequestPost> getTextbookRequestPost(@PathVariable String postId) throws HttpServerErrorException{
        try {
             return new ResponseEntity<>(textbookRequestPostService.getTextbookRequestPost(postId), HttpStatus.OK);
        } catch (Exception e) {
            throw new HttpServerErrorException(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @PutMapping("textbook-request-post/{postId}")
    public ResponseEntity<TextBookRequestPost> putTextbookRequestPost(@PathVariable String postId, @RequestBody TextBookRequestPost requestedRequest) throws HttpServerErrorException{
        try{
            return new ResponseEntity<>(textbookRequestPostService.addTextbookRequestPost(requestedRequest), HttpStatus.OK);
        }catch(Exception e){
            throw new HttpServerErrorException(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @PostMapping("textbook-request-post/")
    public TextBookRequestPost addTextbookRequestPost(@RequestBody TextBookRequestPost requestedRequest){
        try{
            return textbookRequestPostService.addTextbookRequestPost(requestedRequest);
        }catch(Exception e){
            throw new HttpServerErrorException(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("textbook-request-post/")
    public List<TextBookRequestPost> getAllTextbookRequestPost(){
        try{
            return textbookRequestPostService.getAllTextbookRequestPost();
            }
        catch(Exception e){
            throw new HttpServerErrorException(HttpStatus.INTERNAL_SERVER_ERROR);
            }

    }


    @GetMapping("textbook-request-post/{name}/{subject}/{author}")
    public List<TextBookRequestPost> searchTextbookRequestPost(@PathVariable String name, @PathVariable String subject, @PathVariable String author){
        try{
            return textbookRequestPostService.searchTextbookRequestPost(name);
        }catch (Exception e){
            throw new HttpServerErrorException(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @DeleteMapping("textbook-request-post/{id}")
    public void deleteTextbookRequestPost(@PathVariable String id){
        try{
            textbookRequestPostService.deleteTextbookRequestPost(id);
        }catch (Exception e){
            throw new HttpServerErrorException(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("textbook-request-post/{id}/claim")
    public void claimTextbookRequestPost(@PathVariable String id){
        try{
            textbookRequestPostService.claimTextbookRequestPost(id);
        }catch (Exception e){
            throw new HttpServerErrorException(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }



}
