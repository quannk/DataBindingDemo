package com.example.myapplication.ui;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.text.Html;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.TextPaint;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.text.style.StyleSpan;
import android.text.style.URLSpan;
import android.util.AttributeSet;
import android.view.View;

import androidx.appcompat.widget.AppCompatTextView;



import java.util.ArrayList;
import java.util.List;

public class HyperLinkTextView extends AppCompatTextView {
    private OnTagClick mOnTagClick;
    private int mTagColor = Color.parseColor("#000000");

    public HyperLinkTextView(Context context) {
        super(context);
    }

    public HyperLinkTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public HyperLinkTextView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public void setOnTagClick(OnTagClick onTagClick) {
        mOnTagClick = onTagClick;
    }

    public void setTagColor(int color) {
        mTagColor = color;
    }

//    public void setTagUser(User owner, List<SearchUser> tagUserList) {
//        SearchUser myUser = BaseHelper.convertFromUser(owner);
//
//        List<Status> statusList = new ArrayList<>();
//        // thêm chính user của người dùng
//        statusList.add(createExtension(myUser.getId(), myUser.getFullName(), ContentData.Type.TAG));
//
//        //thêm các user khác trong tag friend
//        if (tagUserList != null && !tagUserList.isEmpty()) {
//            int ind = 0;
//            if (tagUserList.size() <= 2) {
//                for (SearchUser user : tagUserList) {
//                    if (ind == 0) {
//                        statusList.add(createExtension("", " với ", ContentData.Type.TEXT));
//                    }
//                    statusList.add(createExtension(user.getId(), user.getFullName(), ContentData.Type.TAG));
//
//                    if (ind != tagUserList.size() - 1) {
//                        statusList.add(createExtension("", " và ", ContentData.Type.TEXT));
//                    }
//                    ind++;
//                }
//            } else {
//                statusList.add(createExtension("", " với ", ContentData.Type.TEXT));
//                SearchUser user = tagUserList.get(0);
//                statusList.add(createExtension(user.getId(), user.getFullName(), ContentData.Type.TAG));
//                statusList.add(createExtension("", " và ", ContentData.Type.TEXT));
//                statusList.add(createExtension("", (tagUserList.size() - 1 )+ " người khác", ContentData.Type.TAG_MORE));
//
//            }
//        }
//
//        Extension extension = new Extension();
//        extension.setStatus(statusList);
//        setExtension(extension);
//    }

//    private Status createExtension(String userID, String fullName, String type) {
//        Status status = new Status();
//        status.setUserID(userID);
//        status.setFullText(fullName);
//        status.setType(type);
//
//        return status;
//    }
//
//    public void setExtension(Extension extension) {
//        String content = "";
//        List<Status> statusList = new ArrayList<>();
//        if (extension != null) {
//            statusList = extension.getStatus();
//        }
//
//        if (statusList.size() > 0)
//            for (Status status : statusList) {
//                String type = status.getType();
//                String text = status.getFullText();
//
//                if (ContentData.Type.HASH_TAG.equals(type)) {
//                    content += "<a href='" + status.getLink() + "'>" + text + "</a>";
//                } else if (ContentData.Type.TAG.equals(type)) {
//                    content += "<a href='" + status.getUserID() + "'>" + text + "</a>";
//                } else if (ContentData.Type.LINK.equals(type)) {
//                    content += "<a href='" + status.getLink() + "'>" + text + "</a>";
//                } else if (ContentData.Type.TAG_MORE.equals(type)) {
//                    content += "<a href='" + ContentData.Type.TAG_MORE + "'>" + text + "</a>";
//                } else if (ContentData.Type.TEXT.equals(type)) {
//                    content += text;
//                }
//
//                content += " ";
//            }
//
//        CharSequence sequence = Html.fromHtml(content);
//        SpannableStringBuilder strBuilder = new SpannableStringBuilder(sequence);
//        URLSpan[] urls = strBuilder.getSpans(0, sequence.length(), URLSpan.class);
//        for (URLSpan span : urls) {
//            int start = strBuilder.getSpanStart(span);
//            int end = strBuilder.getSpanEnd(span);
//            int flags = strBuilder.getSpanFlags(span);
//            strBuilder.setSpan(new StyleSpan(Typeface.BOLD), start, end, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
//            ClickableSpan clickable = new ClickableSpan() {
//                @Override
//                public void onClick(View widget) {
//                    if (mOnTagClick != null) {
//                        String data = span.getURL();
//                        String type = BaseHelper.StatusType.STATUS_TYPE_HASHTAG;
//                        if (!data.contains("http")) {
//                            type = BaseHelper.StatusType.STATUS_TYPE_TAG;
//                        }
//                        if (ContentData.Type.TAG_MORE.equals(data)) {
//                            type = ContentData.Type.TAG_MORE;
//                        }
//                        mOnTagClick.onTagClick(data, type);
//                    }
//                }
//
//                @Override
//                public void updateDrawState(TextPaint ds) {
//                    super.updateDrawState(ds);
//                    ds.setUnderlineText(false);
//                    ds.setFakeBoldText(true);
////                    ds.setTextSize(35f);
//                    ds.setColor(mTagColor);
//                }
//            };
//            strBuilder.setSpan(clickable, start, end, flags);
//            strBuilder.removeSpan(span);
//        }
//
//        this.setText(strBuilder);
//        this.setLinksClickable(true);
//        this.setMovementMethod(LinkMovementMethod.getInstance());
//    }

    public interface OnTagClick {
        /*
        @param data: Link hoac userID (phu thuoc vao type)
         */
        void onTagClick(String userId, String type);
    }
}
