package com.app.dasher.models.common;

/**
 * @author Paly
 * @version 1.0
 * @date 12/07/21 5:52 PM
 * @company NextUp
 */
public class VideoInfo {
    private String muxId;
    private String name;
    private String thumbnailUrl;
    private String videoUrl;
    private Long addedAt;
    private int numberOfLikes;

    public int getNumberOfLikes() {
        return numberOfLikes;
    }

    public void setNumberOfLikes(int numberOfLikes) {
        this.numberOfLikes = numberOfLikes;
    }

    public Long getAddedAt() {
        return addedAt;
    }

    public void setAddedAt(Long addedAt) {
        this.addedAt = addedAt;
    }

    public String getMuxId() {
        return muxId;
    }

    public void setMuxId(String muxId) {
        this.muxId = muxId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getThumbnailUrl() {
        return thumbnailUrl;
    }

    public void setThumbnailUrl(String thumbnailUrl) {
        this.thumbnailUrl = thumbnailUrl;
    }

    public String getVideoUrl() {
        return videoUrl;
    }

    public void setVideoUrl(String videoUrl) {
        this.videoUrl = videoUrl;
    }
}
