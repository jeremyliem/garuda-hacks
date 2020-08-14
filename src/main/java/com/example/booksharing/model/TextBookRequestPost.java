package com.example.booksharing.model;
import java.util.*;
import java.io.*;

public class TextBookRequestPost {
    private String nameBookReq;
    private String commentBookReq;
    private String locationBookReq;
    private String emailBookReq;

    public TextBookRequestPost(){

    }
    public TextBookRequestPost(String nameBookReq, String commentBookReq, String locationBookReq, String emailBookReq){
        super();
        this.nameBookReq=nameBookReq;
        this.commentBookReq=commentBookReq;
        this.locationBookReq=locationBookReq;
        this.emailBookReq=emailBookReq;
    }

    public String getLocationBookReq() {return locationBookReq;}

    public String getCommentBookReq() { return commentBookReq;}

    public String getEmailBookReq() { return emailBookReq;}

    public String getNameBookReq() { return nameBookReq;}

    public void setCommentBookReq(String commentBookReq) { this.commentBookReq = commentBookReq;}

    public void setEmailBookReq(String emailBookReq) { this.emailBookReq = emailBookReq; }

    public void setLocationBookReq(String locationBookReq) { this.locationBookReq = locationBookReq; }

    public void setNameBookReq(String nameBookReq) { this.nameBookReq = nameBookReq; }


}
