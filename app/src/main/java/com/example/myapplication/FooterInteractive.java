package com.example.myapplication;

import androidx.databinding.ObservableField;


import com.example.myapplication.util.FeedCallback;

import java.io.Serializable;

/**
 * Created by TungGaru on 17/12/2018.
 * Mail : tunglequangson@vccorp.vn
 * Skype : sontung1088
 */

public class FooterInteractive implements Serializable {
    public ObservableField<Boolean> isPosted = new ObservableField();
    public ObservableField<Boolean> isReposted = new ObservableField();
    public ObservableField<Boolean> isSended = new ObservableField();
    public ObservableField<Boolean> isSaved = new ObservableField();
    public String shareLink;

    public FooterInteractive(boolean isPosted, boolean isReposted, boolean isSended, boolean isSaved, String shareLink) {
        this.isPosted.set(isPosted);
        this.isReposted.set(isReposted);
        this.isSended.set(isSended);
        this.isSaved.set(isSaved);
        this.shareLink = shareLink;
    }

    /**
     * Hàm xử lý khi click button Post ở footer
     *
     * @param
     * @return
     */
    public void postClick(FeedCallback callback, int position) {
//        this.isPosted.set(!this.isPosted.get());
        this.isPosted.set(true);
        if (callback != null) {
            callback.post(position);
        }
    }

    /**
     * Hàm xử lý khi click button RePost ở footer
     *
     * @param
     * @return
     */
    public void repostClick(FeedCallback callback, int position) {
//        this.isReposted.set(!this.isReposted.get());
        this.isReposted.set(true);
        if (callback != null) {
            callback.repost(position);
        }
    }

    /**
     * Hàm xử lý khi click button Send ở footer
     *
     * @param
     * @return
     */
    public void sendClick(FeedCallback callback, int position) {
//        this.isSended.set(!this.isSended.get());
        this.isSended.set(true);
        if (callback != null) {
            callback.send(position, shareLink);
        }
    }

    /**
     * Hàm xử lý khi click button Save ở footer --> chuyển sang token
     *
     * @param
     * @return
     */
    public void saveClick(FeedCallback callback, int position) {
//        this.isSaved.set(!this.isSaved.get());
        this.isSaved.set(true);
        if (callback != null) {
            callback.save(position);
        }
    }
}
