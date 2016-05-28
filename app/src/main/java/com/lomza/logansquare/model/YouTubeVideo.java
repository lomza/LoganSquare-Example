package com.lomza.logansquare.model;

import com.bluelinelabs.logansquare.annotation.JsonField;
import com.bluelinelabs.logansquare.annotation.JsonIgnore;
import com.bluelinelabs.logansquare.annotation.JsonObject;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

@JsonObject(fieldDetectionPolicy = JsonObject.FieldDetectionPolicy.NONPRIVATE_FIELDS_AND_ACCESSORS)
public class YouTubeVideo {

    private String id;

    private Date uploaded;

    private Date updated;

    private String category;

    private String title;

    private String description;

    private List<String> tags;

    private Thumbnail thumbnail;

    private HashMap<String, String> content;

    private int duration;

    private double rating;

    private long viewCount;

    private long commentCount;

    @JsonField(typeConverter = EnumStringConverter.class)
    public Status status;

    @JsonIgnore
    private boolean watched;

    public YouTubeVideo() {

    }

    public YouTubeVideo(String id, Date uploaded, Date updated, String category, String title,
                        String description, List<String> tags, Thumbnail thumbnail, HashMap<String, String> content,
                        int duration, double rating, long viewCount, long commentCount, Status status, boolean watched) {
        this.id = id;
        this.uploaded = uploaded;
        this.updated = updated;
        this.category = category;
        this.title = title;
        this.description = description;
        this.tags = tags;
        this.thumbnail = thumbnail;
        this.content = content;
        this.duration = duration;
        this.rating = rating;
        this.viewCount = viewCount;
        this.commentCount = commentCount;
        this.status = status;
        this.watched = watched;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Date getUploaded() {
        return uploaded;
    }

    public void setUploaded(Date uploaded) {
        this.uploaded = uploaded;
    }

    public Date getUpdated() {
        return updated;
    }

    public void setUpdated(Date updated) {
        this.updated = updated;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<String> getTags() {
        return tags;
    }

    public void setTags(List<String> tags) {
        this.tags = tags;
    }

    public Thumbnail getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(Thumbnail thumbnail) {
        this.thumbnail = thumbnail;
    }

    public HashMap<String, String> getContent() {
        return content;
    }

    public void setContent(HashMap<String, String> content) {
        this.content = content;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public long getViewCount() {
        return viewCount;
    }

    public void setViewCount(long viewCount) {
        this.viewCount = viewCount;
    }

    public long getCommentCount() {
        return commentCount;
    }

    public void setCommentCount(long commentCount) {
        this.commentCount = commentCount;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public boolean isWatched() {
        return watched;
    }

    public void setWatched(boolean watched) {
        this.watched = watched;
    }

    @Override
    public String toString() {
        return "{" +
                "        \"id\":\"" + getId() + "\",\n" +
                "        \"uploaded\":\"" + getUploaded() + "\",\n" +
                "        \"updated\":\"" + getUpdated() + "\",\n" +
                "        \"category\":\"" + getCategory() + "\",\n" +
                "        \"title\":\"" + getTitle() + "\",\n" +
                "        \"description\":\"" + getDescription() + "\",\n" +
                "        \"tags\":" + getTags().toString() +
                "        ,\n" +
                "        \"thumbnail\":" + getThumbnail().toString() +
                "        ,\n" +
                "        \"content\":{\n" + getContent().toString() +
                "        },\n" +
                "        \"duration\":" + getDuration() + ",\n" +
                "        \"rating\":" + getRating() + ",\n" +
                "        \"viewCount\":" + getViewCount() + ",\n" +
                "        \"commentCount\":" + getCommentCount() + ",\n" +
                "        \"status\": \"" + getStatus() + "\"\n" +
                "}";
    }
}