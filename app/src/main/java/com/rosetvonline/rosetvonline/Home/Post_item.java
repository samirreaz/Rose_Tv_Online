package com.rosetvonline.rosetvonline.Home;

public class Post_item {
    private String postID;
    private String imageURL;
    private String postTitle;
    private String postDescription;
    private String postCategory;
    private String mawlanaName;
    private String postYear;
    private String postTags;
    private String youtubeURL;

    public Post_item() {
    }

    public Post_item(String postID, String imageURL) {
        this.postID = postID;
        this.imageURL = imageURL;
    }

    public Post_item(String postID, String imageURL, String postTitle, String postDescription, String postCategory, String mawlanaName, String postYear, String postTags, String youtubeURL) {
        this.postID = postID;
        this.imageURL = imageURL;
        this.postTitle = postTitle;
        this.postDescription = postDescription;
        this.postCategory = postCategory;
        this.mawlanaName = mawlanaName;
        this.postYear = postYear;
        this.postTags = postTags;
        this.youtubeURL = youtubeURL;
    }


    public String getPostID() {
        return postID;
    }

    public void setPostID(String postID) {
        this.postID = postID;
    }

    public String getImageURL() {
        return imageURL;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }

    public String getPostTitle() {
        return postTitle;
    }

    public void setPostTitle(String postTitle) {
        this.postTitle = postTitle;
    }

    public String getPostDescription() {
        return postDescription;
    }

    public void setPostDescription(String postDescription) {
        this.postDescription = postDescription;
    }

    public String getPostCategory() {
        return postCategory;
    }

    public void setPostCategory(String postCategory) {
        this.postCategory = postCategory;
    }

    public String getMawlanaName() {
        return mawlanaName;
    }

    public void setMawlanaName(String mawlanaName) {
        this.mawlanaName = mawlanaName;
    }

    public String getPostYear() {
        return postYear;
    }

    public void setPostYear(String postYear) {
        this.postYear = postYear;
    }

    public String getPostTags() {
        return postTags;
    }

    public void setPostTags(String postTags) {
        this.postTags = postTags;
    }

    public String getYoutubeURL() {
        return youtubeURL;
    }

    public void setYoutubeURL(String youtubeURL) {
        this.youtubeURL = youtubeURL;
    }
}
