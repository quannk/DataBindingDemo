package com.example.myapplication.util;

import android.text.TextUtils;

//import androidx.databinding.ObservableField;
//
//import com.vccorp.base.entity.insertLikeFollow.InsertFollow;
//import com.vccorp.base.helper.DateTimeHelper;

import androidx.databinding.ObservableField;

import java.io.Serializable;

/**
 * Created by TungGaru on 17/12/2018.
 * Mail : tunglequangson@vccorp.vn
 * Skype : sontung1088
 */

public class HeaderUserInfo implements Serializable {
    public ObservableField<String> avatar= new ObservableField();
    public ObservableField<String> name= new ObservableField();
    public String time;
    public String id;
    public boolean hasFollow;
    public ObservableField<Boolean> isFollow = new ObservableField();
    public String postId;
//    /**
//     * Khởi tạo header user info
//     *
//     * @param avatar     : ảnh đại diện header
//     * @param name:      tên header
//     * @param time:      thời gian tạo card
//     * @param hasFollow: true khi cho phép theo dõi
//     * @param isFollow:  true khi đã theo dõi
//     * @return
//     */
    public HeaderUserInfo(String avatar, String name, String id, long time, boolean hasFollow, boolean isFollow, String postId) {
        this.avatar.set(avatar);
//        this.name.set(name);;
        this.id = id;
   //     this.time = DateTimeHelper.convertTimeStampToTimeAgo(time);
        this.hasFollow = hasFollow;
        this.isFollow.set(isFollow);
        this.postId=postId;
    }

    public HeaderUserInfo() {
    }

//    public String getAvatar() {
//        return avatar;
//    }
//
//    public void setAvatar(String avatar) {
//        this.avatar = avatar;
//    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        long timeResult = -1;
        try {
            timeResult = Long.parseLong(time);
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
    //    this.time = DateTimeHelper.convertTimeStampToTimeAgo(timeResult);
    }

    public boolean isHasFollow() {
        return hasFollow;
    }

    public void setHasFollow(boolean hasFollow) {
        this.hasFollow = hasFollow;
    }

    public ObservableField<Boolean> getIsFollow() {
        return isFollow;
    }

    public void setIsFollow(ObservableField<Boolean> isFollow) {
        this.isFollow = isFollow;
    }

    /**
     * Hàm xử lý khi click button dấu cộng ở header user info
     *
     * @param
     * @return
     */
    public void addClick(FeedCallback callback, int position) {
        this.isFollow.set(!this.isFollow.get());
        if (callback != null) {
          //  callback.addHeader(position, isFollow.get(), id, InsertFollow.TYPE_FOLLOW_USER,postId);
        }
    }

    public void addClickActionMore(FeedCallback callback, int position) {

        if (callback != null) {
            callback.clickActionMore(position);
        }
    }

    public void addClickProfile(FeedCallback callback, int position) {

        if (callback != null) {
            callback.clickProfile(position,id);
        }
    }

    public void addClickProfile(FeedCallback callback, String userId) {
        if (TextUtils.isEmpty(userId)) return;
        if (callback != null) {
            callback.clickProfile(-1, userId);
        }
    }
}
