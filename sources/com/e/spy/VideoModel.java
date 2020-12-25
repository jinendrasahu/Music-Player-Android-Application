package com.e.spy;

public class VideoModel {
    boolean bool_selected;
    String str_thumb;
    String video_path;

    public String getVideo_path() {
        return this.video_path;
    }

    public void setVideo_path(String video_path2) {
        this.video_path = video_path2;
    }

    public String getStr_thumb() {
        return this.str_thumb;
    }

    public void setStr_thumb(String str_thumb2) {
        this.str_thumb = str_thumb2;
    }

    public boolean isBool_selected() {
        return this.bool_selected;
    }

    public void setBool_selected(boolean bool_selected2) {
        this.bool_selected = bool_selected2;
    }
}
