package com.example.myapplication.util;

import android.widget.ImageView;
//
//import com.vccorp.base.entity.data.BaseData;
//import com.vccorp.base.entity.extension.SearchUser;
//import com.vccorp.base.entity.request.comment.Status;
//import com.vccorp.base.entity.user.User;
//import com.vccorp.base.entity.widget.WidgetData;
//import com.vccorp.feed.base.util.BaseFeed;
//import com.vccorp.feed.sub.photo.CardPhoto;
//import com.vccorp.video.foreground.PlayerUpdateMessage;

import java.util.List;

/**
 * Created by YurikoMatsuki on 11/26/2018.
 * Phone : 0439312984
 * Mail : yurikomatsuki2702@gmail.com
 * Skype : yuriko2702
 */
public interface FeedCallback {
    void emoji(int position, boolean liked, String postId);

    void comment(int position, String id);

    void post(int position);

    void repost(int position);

    void send(int position, String link);

    void save(int position);

    void followFooter(int position, boolean isFollow, int type, String postId, String userId, String boardId);

    void callFooter(int position, String phone_number);

    void messageFooter(int position, String message); //co the la id hoac gi do chua ro lam

    void refreshHeader(int position);

    void addHeader(int position, boolean isFollow, String userId, int type, String postId);

    void followHeader(int position, boolean isFollow, String userId, int type, String postId);

//    void playerSetData(int position, PlayerUpdateMessage message);

    void playerSeek(long to);

    void click(String message);

//    void clickBaseData(BaseData data);

//    void clickFeed(int position, BaseFeed baseFeed);

//    void clickGoDetailsAndComment(int position, BaseFeed baseFeed);

    void scrolledToPosition(int position);

    void focusToPosition(int position, boolean isAutoFocus);

//    void onClickImageFeed(int position, ImageView shareImageView, String url, CardPhoto cardPhoto);

//    void onClickFrameItem(int position, BaseFeed baseFeed);

//    void onClickItemVieoPlaylist(int position, BaseFeed baseFeed);

    void onClickViewMorePlaylist(String idPlaylist);

    //thaond
    void deleteCreatePost(int id, int position);

    void clickActionMore(int position);

//    void clickReport(int position, User user, String postId);

//    void clickUndoHide(int position, User user, String postId);

//    void clickHideAllByUser(int position, User user, String postId);

//    void clickExtension(Status status);

//    void clickWidgetItem(WidgetData link, int position);

    void clickProfile(int position, String userID);

    void clickReadmore(int position);

    void clickMuteVolume();
    void clickToken(int position);

//    void showMoreTagFiend(List<SearchUser> userList);

}
