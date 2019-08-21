package com.example.myapplication.ui.extension;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.text.style.ForegroundColorSpan;
import android.util.AttributeSet;
import android.view.View;

import androidx.appcompat.widget.AppCompatTextView;

import java.util.List;

/**
 * ThomPV
 * e-mail: thomphamvan@vccorp.vn
 **/
public class ExtensionTextView extends AppCompatTextView {
    private static final long LICK_TIME = 100;
//    private ContentParser contentParser;

    private static final int MAX_LINE = 4;
    private static final int DEFAULT_TRIM_LENGTH = 210;
    private static final String ELLIPSIS = "... Xem thêm";

    private CharSequence originalText;
    private CharSequence trimmedText;
    private BufferType bufferType;
    private boolean trim = true;
    private int trimLength, trimLength2;
    private int lineCount = 0;
    private String colorString = null;

    long startTime = 0, endTime = 0;

    public ExtensionTextView(Context context) {
        super(context, null);
    }

    public ExtensionTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
//        init();
//        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.ExpandableTextView);
//        this.trimLength = typedArray.getInt(R.styleable.ExpandableTextView_trimLength, DEFAULT_TRIM_LENGTH);
//        typedArray.recycle();

        // xử lý click trên textview
//        setOnTouchListener(new OnTouchListener() {
//            @Override
//            public boolean onTouch(View v, MotionEvent event) {
//                switch (event.getAction()) {
//                    case MotionEvent.ACTION_DOWN:
//                        startTime = System.currentTimeMillis();
//                        break;
//                    case MotionEvent.ACTION_UP:
//                        endTime = System.currentTimeMillis();
//                        if (endTime - startTime <= LICK_TIME) {
//                            new Handler().postDelayed(new Runnable() {
//                                @Override
//                                public void run() {
//                                    if (!isClickExtension) {
//                                        trim = !trim;
//                                        setText();
//                                    }
//
//                                    isClickExtension = false;
//                                }
//                            }, 100);
//
////                            requestFocusFromTouch();
//                        }
//                        break;
//                }
//                return false;
//            }
//        });

        setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                if (hasReadmore()) {
                    trim = !trim;
                    setText();
                }

                if (mCustomOnClicklistener != null) {
                    mCustomOnClicklistener.onClick();
                }
            }
        });
    }

    private void setText() {
        super.setText(getDisplayableText(), bufferType);

        if (!trim) {
            if (mReadMoreListener != null) {
                mReadMoreListener.onReadMoreListener();
            }
        }
    }

    private Spannable getDisplayableText() {
        // create "Xem thêm" spannable
        Spannable spannable = new SpannableString(trim ? trimmedText : originalText);
        int start = trimmedText.toString().lastIndexOf(ELLIPSIS);
        int end = trimmedText.length();
        if (trim && start > 0) {
            ClickableSpan clickableReadmore = new ClickableSpan() {
                @Override
                public void onClick(View widget) {
                    // do nothing
                }

                @Override
                public void updateDrawState(TextPaint ds) {
                    super.updateDrawState(ds);
                    ds.setUnderlineText(false);
                    String color = ContentData.Color.READ_MORE;
                    ds.setColor(Color.parseColor(color));
                }
            };
            spannable.setSpan(clickableReadmore, start + 3, end, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        }
//        setText(spannable);
//        return trim ? trimmedText : originalText;
        return spannable;
    }

    @Override
    public void setText(CharSequence text, BufferType type) {
        originalText = text;
        trimmedText = getTrimmedText(text);
        bufferType = type;
        setText();
    }

    private CharSequence getTrimmedText(CharSequence text) {
        if (isCanExpand()) {
            return new SpannableStringBuilder(originalText, 0, trimLength2 + 1).append(ELLIPSIS);
        }

        if (originalText != null && originalText.length() > trimLength) {
            return new SpannableStringBuilder(originalText, 0, trimLength + 1).append(ELLIPSIS);
        } else {
            return originalText;
        }
    }

    private boolean isCanExpand() {
        if (originalText != null) {
            int length = Math.min(trimLength, originalText.length());
            lineCount = 0;
            for (int i = 0; i < length; i++) {
                if (originalText.charAt(i) == '\n') {
                    lineCount++;
                    if (lineCount > MAX_LINE) {
                        trimLength2 = i;
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public boolean hasReadmore() {
        return originalText.length() >= DEFAULT_TRIM_LENGTH || lineCount > MAX_LINE;
    }

    public boolean isExpand() {
        return !trim;
    }

    public void expand() {
        if (!hasReadmore()) return;

        trim = false;
        setText();
//        requestFocusFromTouch();
    }

    public void collapse() {
        if (!hasReadmore()) return;

        trim = true;
        setText();
//        requestFocusFromTouch();
    }

    public ExtensionTextView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
//        init();
    }
//
//    private void init() {
//        if (contentParser == null) {
//            contentParser = new ContentParser();
//        }
//    }

    @Override
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
    }

    @Override
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
    }

    boolean isClickExtension = false;

//    private Spannable createText() {
//        List<ContentParser.Offset> offsets = contentParser.getOffsets();
//        Spannable spannable = new SpannableString(contentParser.getResult());
//        String color = colorString == null ? ContentData.Color.TEXT : colorString;
//        spannable.setSpan(new ForegroundColorSpan(Color.parseColor(color)), 0, contentParser.getResult().length(), Spannable.SPAN_INCLUSIVE_INCLUSIVE);
//        if (offsets != null && offsets.size() > 0) {
//            for (ContentParser.Offset item : offsets) {
//                int start = item.originalStart;
//                int end = item.originalStart + item.originalLength;
//
//                ClickableSpan clickableSpan = new ClickableSpan() {
//                    @Override
//                    public void onClick(View widget) {
//                        Status status = contentParser.parseExtensionByOffset(item);
//                        if (extensionCLickListener != null) {
//                            isClickExtension = true;
//                            if (!TextUtils.isEmpty(status.getLink()) || !TextUtils.isEmpty(status.getUserID())) {
//                                extensionCLickListener.onClicked(status);
//                            }
//                        }
//                    }
//
//                    @Override
//                    public void updateDrawState(TextPaint ds) {
//                        super.updateDrawState(ds);
//                        ds.setUnderlineText(false);
//                        String color = colorString == null ? ContentData.Color.TEXT : colorString;
////                        ds.setTextSize(ds.getTextSize() + 3f);
//
//                        if (ContentData.Type.TAG.equals(item.type)) {
////                            color = ContentData.Color.TAG;
//                            ds.setFakeBoldText(true);
//                        } else if (ContentData.Type.HASH_TAG.equals(item.type)) {
////                            color = ContentData.Color.TEXT;
//                            ds.setFakeBoldText(true);
//                        } else if (ContentData.Type.LINK.equals(item.type)) {
//                            color = ContentData.Color.LINK;
//                        } else if (ContentData.Type.ACTION.equals(item.type)) {
////                            color = ContentData.Color.TEXT;
//                            ds.setFakeBoldText(true);
//                        }
//
//                        ds.setColor(Color.parseColor(color));
//                    }
//                };
//                setMovementMethod(LinkMovementMethod.getInstance());
//                spannable.setSpan(clickableSpan, start, end, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
//            }
//        }
//        return spannable;
//    }
//
//    public Extension getExtension() {
//        Extension extension = new Extension();
//        extension.setStatus(contentParser.getExtension());
//        return extension;
//    }
//
//    public void setExtension(Extension extension) {
//        List<Status> statusList = extension.getStatus();
//        contentParser.clear();
//        if (statusList != null && statusList.size() > 0) {
//            for (Status status : statusList) {
//                if (status != null && status.getText() != null) {
//                    int index = contentParser.getResult().length();
//                    if (ContentData.Type.TAG.equals(status.getType())
//                            || ContentData.Type.HASH_TAG.equals(status.getType())
//                            || ContentData.Type.LINK.equals(status.getType())
//                            || ContentData.Type.ACTION.equals(status.getType())) {
//                        if (ContentData.Type.HASH_TAG.equals(status.getType())) { // xử lý thừa dấu # (mẹ, bên ios éo sửa làm bên android fix ngu học)
//                            String text = status.getText().replaceAll("#", "");
//                            status.setText(text);
//                            status.setFullText(text);
//                        }
//
//                        contentParser.putExtension(index, "", status);
//                    } else {
//                        contentParser.putText(index, status.getText());
//                    }
//                }
//            }
//        }
//        Spannable spannable = createText();
//        setMovementMethod(LinkMovementMethod.getInstance());
//        setText(spannable);
//    }

    public void setColorForText(String color) {
        if (color != null && !color.isEmpty()) {
            colorString = color;
        }
    }

//    ExtensionCLickListener extensionCLickListener;
//
//    public void setExtensionCLickListener(ExtensionCLickListener extensionCLickListener) {
//        this.extensionCLickListener = extensionCLickListener;
//    }

//    public interface ExtensionCLickListener {
//        void onClicked(Status status);
//    }

    private ReadMoreListener mReadMoreListener;

    public void setReadMoreListener(ReadMoreListener mReadMoreListener) {
        this.mReadMoreListener = mReadMoreListener;
    }

    public interface ReadMoreListener {
        void onReadMoreListener();
    }

    private CustomOnClicklistener mCustomOnClicklistener;

    public void setCustomOnClicklistener(CustomOnClicklistener mCustomOnClicklistener) {
        this.mCustomOnClicklistener = mCustomOnClicklistener;
    }

    public interface CustomOnClicklistener {
        void onClick();
    }
}
