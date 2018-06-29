package com.example.windows.chatwith.adapters;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.design.widget.TextInputEditText;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.windows.chatwith.R;
import com.example.windows.chatwith.beans.ForumCommentBean;
import com.example.windows.chatwith.beans.ForumInfoBean;
import com.example.windows.chatwith.utils.Data;
import com.example.windows.chatwith.utils.DateFormatUtil;
import com.example.windows.chatwith.utils.DensityUtil;
import com.example.windows.chatwith.utils.PersonInfoUtil;
import com.jaeger.ninegridimageview.NineGridImageView;
import com.jaeger.ninegridimageview.NineGridImageViewAdapter;

import java.util.ArrayList;

/**
 * Created by Windows on 2018/6/29.
 */

public class ForumAdapter extends RecyclerView.Adapter implements AdapterView.OnItemClickListener {
    private int mResId;
    private ArrayList<Object> mArticleList;
    private ViewHolder mViewHolder;
    private Activity mThis;
    private Dialog mBottomDialog;
    private TextInputEditText mEt_comment;
    private ForumCommentBean mComment;
    private ArrayList<Object> mReviewList = Data.getReplyList();
    private ForumReplyAdapter mReviewAdapter;
    private OnItemClickListener mOnItemClickListener;
    private String mReviewerName= "";

    public ForumAdapter(int resId, ArrayList<Object> list, Activity mthis) {
        mResId = resId;
        mArticleList = list;
        mThis = mthis;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_forum, null);
        mViewHolder = new ViewHolder(inflate);
        return mViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, final int position) {
        ViewHolder viewHolder = (ViewHolder) holder;
        View itemView = viewHolder.itemView;

        ForumInfoBean mForumInfo = (ForumInfoBean) mArticleList.get(position);
        viewHolder.publisherHp = itemView.findViewById(R.id.iv_headPortrait);
        viewHolder.articleTitle = itemView.findViewById(R.id.tv_articleTitle);
        viewHolder.articleContent = itemView.findViewById(R.id.tv_articleContent);
        viewHolder.publisherName = itemView.findViewById(R.id.tv_niceName);
        viewHolder.publishTime = itemView.findViewById(R.id.tv_publishTime);
        viewHolder.nineImageView = itemView.findViewById(R.id.nineImageView);
        viewHolder.review = itemView.findViewById(R.id.ib_comment);

        Glide.with(mViewHolder.publisherHp.getContext())
                .load(mForumInfo.getPublisherHp())
                .apply(new RequestOptions().centerCrop())
                .into(mViewHolder.publisherHp);

        viewHolder.articleTitle.setText(mForumInfo.getArticleTitle());
        viewHolder.articleContent.setText(mForumInfo.getArticleContent());
        viewHolder.publisherName.setText(mForumInfo.getPublisherName());
        viewHolder.publishTime.setText(DateFormatUtil.getDate(mForumInfo.getPublishTime()));
        viewHolder.review.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //评论
                dialogEditText();
            }
        });
        viewHolder.nineImageView.setAdapter(new NineGridImageViewAdapter() {
            @Override
            protected void onDisplayImage(Context context, ImageView imageView, Object o) {
                Glide.with(context).load(o).apply(new RequestOptions().centerCrop()).into(imageView);
            }
        });
        viewHolder.nineImageView.setImagesData(mForumInfo.getPublishImage());
        //这个为评论的列表布局
        viewHolder.recyclerView = itemView.findViewById(R.id.recyclerView);
        viewHolder.recyclerView.setLayoutManager(new LinearLayoutManager(mViewHolder.recyclerView.getContext()));

        mReviewAdapter = new ForumReplyAdapter(R.layout.item_forum_reply, mReviewList);
        viewHolder.recyclerView.setAdapter(mReviewAdapter);
        mReviewAdapter.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onClick(int position) {
                dialogEditText();
                ForumCommentBean commentBean = (ForumCommentBean) mReviewList.get(position);
                mReviewerName = commentBean.getReviewerName();
            }
        });

        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mOnItemClickListener.onClick(position);
            }
        });

    }

    /**
     * 弹出dialog
     */
    private void dialogEditText() {
        mBottomDialog = new Dialog(mThis);
        View contentView = LayoutInflater.from(mThis).inflate(R.layout.dialog_comment, null);
        mBottomDialog.setContentView(contentView);
        ViewGroup.MarginLayoutParams params = (ViewGroup.MarginLayoutParams) contentView.getLayoutParams();
        params.width = mThis.getResources().getDisplayMetrics().widthPixels - DensityUtil.dp2px(mThis, 16f);
        params.bottomMargin = DensityUtil.dp2px(mThis, 8f);
        contentView.setLayoutParams(params);

        mBottomDialog.setCanceledOnTouchOutside(true);
        mBottomDialog.getWindow().setGravity(Gravity.BOTTOM);
        mBottomDialog.getWindow().setWindowAnimations(R.style.BottomDialog_Animation);
        mBottomDialog.show();

        mEt_comment = contentView.findViewById(R.id.et_comment);
        contentView.findViewById(R.id.btn_send).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                review();
            }
        });
    }

    /**
     * 发表评论
     */
    private void review() {
        String comment = mEt_comment.getText().toString().trim();
        if (!comment.equals("")) {
            mComment = new ForumCommentBean();
//            mComment.setReplyId(mReplyUid);
//            mComment.setReplyName(mReplyUName);
            mComment.setReviewContent(comment);
            mComment.setReviewId(1);//此条没用
            mComment.setReviewTime(System.currentTimeMillis());
            mComment.setReviewerName(PersonInfoUtil.getNickName());
            mComment.setReviewerHp(PersonInfoUtil.getHeadPortrait());
            mComment.setReplyName(mReviewerName);

            mReviewList.add(mComment);
            mReviewAdapter.notifyDataSetChanged();

            hintKeyboard();
            mBottomDialog.dismiss();
        }
    }

    private void hintKeyboard() {
        InputMethodManager imm = (InputMethodManager) mThis.getSystemService(Context.INPUT_METHOD_SERVICE);
        if (imm != null) {
            if (imm.isActive() && mThis.getCurrentFocus() != null) {
                if (mThis.getCurrentFocus().getWindowToken() != null) {
                    imm.hideSoftInputFromWindow(mThis.getCurrentFocus().getWindowToken(), InputMethodManager.HIDE_NOT_ALWAYS);
                }
            }
        }
    }


    @Override
    public int getItemCount() {
        return mArticleList.size();
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Toast.makeText(mThis, position + ":" + id, Toast.LENGTH_SHORT).show();
    }


    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView articleTitle;
        TextView articleContent;
        TextView publisherName;
        ImageView publisherHp;
        TextView publishTime;
        ImageButton review;
        NineGridImageView nineImageView;
        RecyclerView recyclerView;

        private View mView;


        ViewHolder(View itemView) {
            super(itemView);
            mView = itemView;
        }

        public View getView() {
            return mView;
        }


    }

    public interface OnItemClickListener {
        void onClick(int position);
    }

    public void setOnItemClickListener(OnItemClickListener listener) {
        mOnItemClickListener = listener;
    }

}
