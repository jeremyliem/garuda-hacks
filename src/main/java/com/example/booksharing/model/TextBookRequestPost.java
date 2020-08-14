package com.example.booksharing.model;
import java.time.OffsetDateTime;

public class TextBookRequestPost {
    private String nameBookReq;
    private String commentBookReq;
    private String locationBookReq;
    private String emailBookReq;
    private OffsetDateTime createdAt;

    public TextBookRequestPost(){

    }
    public TextBookRequestPost(String nameBookReq, String commentBookReq, String locationBookReq, String emailBookReq, OffsetDateTime createdAt){
        super();
        this.nameBookReq=nameBookReq;
        this.commentBookReq=commentBookReq;
        this.locationBookReq=locationBookReq;
        this.emailBookReq=emailBookReq;
        this.createdAt = createdAt;
    }

    public String getLocationBookReq() {return locationBookReq;}

    public String getCommentBookReq() { return commentBookReq;}

    public String getEmailBookReq() { return emailBookReq;}

    public String getNameBookReq() { return nameBookReq;}

    public OffsetDateTime getCreatedAt() { return createdAt; }

    public void setCommentBookReq(String commentBookReq) { this.commentBookReq = commentBookReq;}

    public void setEmailBookReq(String emailBookReq) { this.emailBookReq = emailBookReq; }

    public void setLocationBookReq(String locationBookReq) { this.locationBookReq = locationBookReq; }

    public void setNameBookReq(String nameBookReq) { this.nameBookReq = nameBookReq; }


}
