package com.example.myapplication.ui.extension;

public interface ContentData {
    interface Type {
        String TEXT = "text";
        String TAG = "tag";
        String HASH_TAG = "hashtag";
        String LINK = "link";
        String TAG_MORE = "tag_more";
        String ACTION = "action";
    }

    interface Color {
        String TEXT = "#000000";
        String TAG = "#1F9FFC";
        String HASH_TAG = "#1F9FFC";
        String LINK = "#1F9FFC";
        String LINK_IN_EDITTEXT = "#000000";
        String READ_MORE = "#1F9FFC";
    }

    interface Symbol {
        String TAG = "@";
        String HASH_TAG = "#";
    }

    interface Format {
        String TAG = "<special id='" + Type.TAG + "' userId='%s'>%s</special>";
        String HASH_TAG = "<special id='" + Type.HASH_TAG + "' link='%s'>%s</special>";
        String LINK = "<special id='" + Type.LINK + "' link='%s'>%s</special>";
        String HTML_FONT_TAG = "<font color='" + Color.TAG + "'>@%s</font>";
        String HTML_FONT_HASHTAG = "<font color='" + Color.HASH_TAG + "'>#%s</font>";
        String HTML_FONT_LINK = "<font color='" + Color.LINK + "'>#%s</font>";
    }
}
